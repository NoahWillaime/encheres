package modele;

import java.util.ArrayList;
import java.util.Observable;

public class Enchere extends Observable{
    private ArrayList<Articles> articles;
    private int current_price;

    public Enchere(){
        this.articles = new ArrayList<>();
        this.current_price = 0;
    }

    public void ajouterArticle(Articles article){
        articles.add(article);
    }

    public String getNom(){
        return articles.get(0).getNom(); //REMPLACER PAR ARTICLE ACTU
    }

    public int getPrix(){
        return articles.get(0).getPrice(); //REMPLACER PAR PRIX ACTU
    }

    public int getCurrent_price(){
        return current_price;
    }
}
