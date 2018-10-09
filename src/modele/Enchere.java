package modele;

import modele.discount.Discount;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class Enchere extends Observable{
    private ArrayList<Lot> articles;
    private String current_nom;
    private String current_depot;
    private int current_price;
    private int last_enchere;
    private int nb_encherisseur;
    private boolean open;
    private int next;
    private Discount discount;

    public Enchere(){
        this.articles = new ArrayList<>();
        this.current_nom = "Attendre début";
        this.current_depot = "none";
        this.current_price = 0;
        this.last_enchere = 0;
        this.nb_encherisseur = 0;
        this.open = false;
        this.next = -1;
    }

    public void startEnchere(){
        next++;
        if (articles.size() > next && !open){
            open = true;
            current_nom = articles.get(next).getNom();
            current_price = articles.get(next).getPrice();
            current_depot = articles.get(next).getDepot();
            if (discount != null){
                current_price = discount.calculDiscount(articles.get(next));
            }
            last_enchere = 0;
            setChanged();
            notifyObservers();
        }
    }

    public void stopEnchere(){
        if (open){
            open = false;
            setChanged();
            notifyObservers();
        }
    }

    public int ajouterEncherisseur(){
        nb_encherisseur++;
        return nb_encherisseur;
    }

    public void ajouterArticle(Lot article){
        articles.add(article);
    }

    public void faireEnchere(int enchere, int ID){
        Date date = new Date();
        System.out.println(date+" : Enchérisseur "+ID+" pour "+getNom()+" - Enchère="+enchere+" - Open="+getOpen());
        if (enchere >= getPrix() && enchere > last_enchere && open){
            last_enchere = enchere;
            setChanged();
            notifyObservers();
        }
    }

    public void setDiscount(Discount disc){
        discount = disc;
    }

    public boolean getOpen(){
        return open;
    }

    public String getNom(){
        return current_nom;
    }

    public int getPrix(){
        return current_price;
    }

    public String getDepot(){
        return current_depot;
    }

    public int getLastEnchere(){
        return last_enchere;
    }
}
