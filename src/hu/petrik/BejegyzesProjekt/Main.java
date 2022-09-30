package hu.petrik.BejegyzesProjekt;

import java.util.ArrayList;
import java.util.List;

public class Main {
        static List<Bejegyzes> bejegyzesekLista = new ArrayList<>();

        public static void main(String[] args){
            bejegyzesekHozzaadasa();
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
