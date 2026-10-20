package com.crirogui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {
    private static Cartelera cartel = new Cartelera("filmaffinity");
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    public static void main(String[] args) {
        scrapWeb();
        cartel.genFile();
        cartel.leerCartel();
    }

    public static void scrapWeb() {
        Document doc;

        try {
            doc = Jsoup.connect("https://www.filmaffinity.com/es/cat_new_th_es.html")
                    .userAgent(USER_AGENT)
                    .timeout(30000)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements peliculas = doc.select("a.movie-title");
        for (Element pelicula : peliculas) {
            String titulo = pelicula.text();
            String href = pelicula.attr("abs:href"); // Uso de enlace absoluto

            if (href.isEmpty()) continue;

            Document movieDoc;
            try {
                movieDoc = Jsoup.connect(href)
                        .userAgent(USER_AGENT)
                        .header("Accept-Language", "es-ES,es;q=0.9")
                        .timeout(30000)
                        .get();
            } catch (IOException e) {
                continue;
            }

            try {
                int ano = Integer.parseInt(movieDoc.select("dt:contains(Año) + dd").text().trim());
                String pais = movieDoc.select("dt:contains(País) + dd").text();
                String direccion = movieDoc.select("dt:contains(Dirección) + dd").text();
                String sinopsis = movieDoc.select("dt:contains(Sinopsis) + dd").text();

                Pelicula p = new Pelicula(titulo, ano, pais, direccion, sinopsis);
                cartel.addPelicula(p);
                System.out.println(p);
            } catch (Exception e) {
                // Control de errores de parseo
            }

            try {
                Thread.sleep(2000); // Pausa para evitar error 429
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}