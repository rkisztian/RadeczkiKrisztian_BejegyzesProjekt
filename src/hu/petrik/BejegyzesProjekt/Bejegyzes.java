package hu.petrik.BejegyzesProjekt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bejegyzes {

    private String szerzo;
    private String tartalom;

    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }


    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }


    public int getLikeok() {
        return likeok;
    }

    public void like(){
        likeok++;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }


    @Override
    public String toString() {
        DateTimeFormatter bejegyzesletrejott =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return String.format("Szerzo :%s - Likeok :%d - Letrejött :%s \n" +
                "Szerkesztve :%s \n" +
                "Tartalom : %s",
                this.szerzo, this.likeok, this.letrejott,
                this.szerkesztve,
                this.tartalom
        );
    }
}
