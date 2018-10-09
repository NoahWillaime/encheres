package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Lot extends Articles {
    private ArrayList<Articles> composant;

    public Lot(String nom, int base_price) {
        super(nom, base_price);
        composant=new ArrayList<Articles>();
    }

    public void ajouterComposant(Articles article){
        composant.add(article);
        price += article.getPrice();
    }

    public int getTaille(){
        if (composant.size() == 0)
            return 1;
        return composant.size();
    }

    public String getNom(){
        if (getTaille() < 1){
            return nom+" : 1 piece";
        } else {
            StringBuilder sb=new StringBuilder();
            sb.append(nom+" ( ");
            Iterator it = composant.iterator();
            Articles a;
            while (it.hasNext()){
                a =(Articles)it.next();
                sb.append(a.getNom());
                if (it.hasNext())
                    sb.append(", ");
                else
                    sb.append(" )");
            }
            sb.append(" : "+getTaille()+" pieces");
            return sb.toString();
        }
    }
}
