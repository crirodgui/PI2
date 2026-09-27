package com.croda;

public class App {

    public static void main(String[] args) {

        System.out.println("=== PRUEBA 1: CREAR NOTICIAS ===");
        Noticia n1 = new Noticia(20211030, 1005, "Descubren un nuevo yacimiento arqueológico.");
        Noticia n2 = new Noticia(20211030, 1230, "El equipo local gana el partido decisivo.");
        Noticia n3 = new Noticia(20211115, 900, "Nuevas medidas de sostenibilidad urbana.");
        Noticia n4 = new Noticia(20211201, 1845, "Apertura de la nueva biblioteca municipal.");

        System.out.println(n1.toString());
        System.out.println(n2.toString());

        System.out.println("=== PRUEBA 2: INSERTAR ===");
        Periodico periodico = new Periodico();
        periodico.insertar(n1);
        periodico.insertar(n2);
        periodico.insertar(n3);
        periodico.insertar(n4);

        System.out.println("Noticias en el periódico tras la inserción:");
        periodico.mostrar();

        System.out.println("=== PRUEBA 3: PRIMERA NOTICIA ===");
        // Buscar la primera noticia del 30/10/2021
        Noticia primera = periodico.primeraNoticia(30, 10, 2021);
        if (primera != null) {
            System.out.println("Primera noticia encontrada para el 30/10/2021:");
            System.out.print(primera.toString());
        } else {
            System.out.println("No se encontraron noticias para esa fecha.");
        }

        // Buscar una noticia en una fecha sin registros
        Noticia noExiste = periodico.primeraNoticia(1, 1, 2022);
        if (noExiste == null) {
            System.out.println("Correcto: No hay noticias para el 01/01/2022.");
        }

        System.out.println("\n=== PRUEBA 4: MÁS POPULARES ===");
        // Incrementar lecturas para simular interacción
        n1.incLecturas();
        n1.incLecturas();
        n3.incLecturas();
        n3.incLecturas(); // n1 y n3 empatan con 2 lecturas
        n2.incLecturas(); // n2 tiene 1 lectura

        System.out.println("Noticias más populares (con máximo de lecturas):");
        periodico.masPopulares();

        System.out.println("=== PRUEBA 5: BORRAR ANTERIORES ===");
        System.out.println("Borrando noticias anteriores al 15/11/2021...");
        periodico.borrarAnteriores(15, 11, 2021);

        System.out.println("\nNoticias restantes en el periódico:");
        periodico.mostrar();
    }
}