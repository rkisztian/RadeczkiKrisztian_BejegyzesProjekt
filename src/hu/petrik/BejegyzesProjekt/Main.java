package hu.petrik.BejegyzesProjekt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bejegyzesekHozzaadasa();

        try {
            bejegyzesFelvetele();
        } catch (RuntimeException e) {
            System.out.println("A db szám csak pozitiv egész szám lehet.");
        }
        String fajlNev = "bejegyzesek.csv";
        try {
            bejegyzesekFelveteleSzovegeAllomanybol(fajlNev);
        } catch (FileNotFoundException e) {
            System.out.println("Hiba! Nem találhato a megadott fájl.");
        } catch (IOException e) {
            System.out.println("Ismeretlen Hiba történt a forrás fájl ovasása után");
            System.out.println(e.getMessage());
        }
        veletlenszeruLikeOsztas();
        bejegyzesModositasa();

    }


    private static void bejegyzesekHozzaadasa() {
        Bejegyzes ujbejegyzes = new Bejegyzes("Radeczki Krisztián",
                "Nem tudtam kihúzni a hunterem wotlk serveren,");

        Bejegyzes ujbejegyzes1 = new Bejegyzes("Szabo Bence",
                "Nem tudta kihúzni a Paladint wotlk szerveren, és még le is maradt");
        bejegyzesekLista.add(ujbejegyzes);
        bejegyzesekLista.add(ujbejegyzes1);

    }


    private static void bejegyzesFelvetele() {
        System.out.println("Kérem adjon meg egy darabszámot: ");
        int db = Integer.parseInt(sc.nextLine());
        if (db < 0) {
            throw new NumberFormatException("Nem megfelelő értéket adott meg!");
        }
        for (int i = 0; i < db; i++) {
            System.out.println("Kérem adja meg a bejegyzés szerzőjét.");
            String szerzo = sc.nextLine();
            System.out.println("Kérem adja meg a bejegyzés tartalmát ");
            String tartalom = sc.nextLine();
            Bejegyzes bejegyzes = new Bejegyzes(szerzo, tartalom);
            bejegyzesekLista.add(bejegyzes);
        }

    }


    private static void bejegyzesekFelveteleSzovegeAllomanybol(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()) {
            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
            bejegyzesekLista.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    private static void veletlenszeruLikeOsztas() {
        Random rnd = new Random();
        int likeok = bejegyzesekLista.size() * 20;
        for (int b = 0; b < likeok; b++) {
            bejegyzesekLista.get(rnd.nextInt(bejegyzesekLista.size())).like();
        }

    }

    private static void bejegyzesModositasa(){
        System.out.println("Kérem, adjonb meg egy szöveget, amire modosítjuk a tartalmat.");
        String modositas = sc.nextLine();
        bejegyzesekLista.get(1).setTartalom(modositas);
    }

}
