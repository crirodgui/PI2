package com.croda;

import java.util.ArrayList;

public class Periodico {

    private ArrayList<Noticia> noticias;
    private int numNoticias;

    public Periodico() {
        noticias = new ArrayList<>(1000);
        this.numNoticias = 0;
    }

    // Inserta una noticia
    public void insertar(Noticia n) {
        if (numNoticias < 1000 && n != null) {
            noticias.add(n);
            numNoticias++;
        }
    }

    // Devuelva la primera noticia
    public Noticia primeraNoticia(int d, int m, int a) {
        for (Noticia n : noticias) {
            if (n.igualFecha(d, m, a)) {
                return n;
            }
        }
        return null;
    }

    // Imprimir las noticias más populares
    public void masPopulares() {
        if (numNoticias == 0) {
            System.out.println("No hay noticias en el periódico.");
            return;
        }

        int maxLecturas = -1;
        for (Noticia n : noticias) {
            if (n.getLecturas() > maxLecturas) {
                maxLecturas = n.getLecturas();
            }
        }

        for (Noticia n : noticias) {
            if (n.getLecturas() == maxLecturas) {
                System.out.print(n.toString());
            }
        }
    }

    // Borrar noticias anteriores a una fecha
    public void borrarAnteriores(int d, int m, int a) {

        int fechaLimite = a * 10000 + m * 100 + d;

        for (int i = noticias.size() - 1; i >= 0; i--) {
            if (noticias.get(i).getFecha() < fechaLimite) {
                noticias.remove(i);
                numNoticias--;
            }
        }
    }

    // Mostrar todas las noticias
    public void mostrar() {

        if (numNoticias == 0) {
            System.out.println("No hay noticias registradas.");
            return;
        }

        for (Noticia n : noticias) {
            System.out.print(n.toString());
        }
    }

}
