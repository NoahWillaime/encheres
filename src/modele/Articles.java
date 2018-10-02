package modele;

import java.util.ArrayList;

public class Articles {
    private String nom;
    private int price;

    public Articles(String nom, int base_price){
        this.nom = nom;
        this.price = base_price;
    }

    public String getNom() {
        return nom;
    }

    public int getPrice() {
        return price;
    }
}
