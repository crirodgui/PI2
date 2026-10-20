package com.crirogui;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cartelera {
    private ArrayList<Pelicula> cartelera;
    private String nombreCartel;

    public Cartelera(String nombreCartel) {
        this.nombreCartel = nombreCartel;
        cartelera = new ArrayList<>();
    }

    public void addPelicula(Pelicula p) {
        cartelera.add(p);
    }

    public void genFile() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("cartelera.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Pelicula p : cartelera) {
            pw.println(p.toString());
        }
        pw.close();
    }

    public void leerCartel() {
        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("cartelera.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            System.out.println(linea);
        }
        sc.close();
    }

}
