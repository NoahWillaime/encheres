package modele;

import java.util.ArrayList;

public class Articles {
    protected String nom;
    protected String depot;
    protected int price;

    public Articles(String nom, int base_price, String depot){
        this.nom = nom;
        this.price = base_price;
        this.depot = depot;
    }

    public String getNom() {
        return nom;
    }

    public int getPrice() {
        return price;
    }

    public String getDepot(){
        return depot;
    }
}
