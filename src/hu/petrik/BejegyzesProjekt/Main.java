package hu.petrik.BejegyzesProjekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        static List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args){
            bejegyzesekHozzaadasa();

            try {
                bejegyzesFelvetele();
            } catch (RuntimeException e){
                System.out.println("A db szám csak pozitiv egész szám lehet.");
            }

        }

        private static void bejegyzesFelvetele(){
            System.out.println("Kérem adjon meg egy darabszámot: ");
            int db =Integer.parseInt(sc.nextLine());
            if(db < 0){
                throw new NumberFormatException("Nem megfelelő értéket adott meg!");
            }
            for (int i = 0; i < db ; i++){
                System.out.println("Kérem adja meg a bejegyzés szerzőjét.");
                String szerzo = sc.nextLine();
                System.out.println("Kérem adja meg a bejegyzés tartalmát ");
                String tartalom = sc.nextLine();
                Bejegyzes bejegyzes = new Bejegyzes(szerzo,tartalom);
                bejegyzesekLista.add(bejegyzes);
            }

        }


        private static void bejegyzesekHozzaadasa(){
            Bejegyzes ujbejegyzes = new Bejegyzes("Radeczki Krisztián",
                    "Nem tudtam kihúzni a hunterem wotlk serveren,");

            Bejegyzes ujbejegyzes1 = new Bejegyzes("Szabo Bence",
                    "Nem tudta kihúzni a Paladint wotlk szerveren, és még le is maradt");
            bejegyzesekLista.add(ujbejegyzes);
            bejegyzesekLista.add(ujbejegyzes1);

        }

}
