import modele.Articles;
import modele.Enchere;
import modele.Lot;
import modele.discount.DiscountRandom;
import vues.VueEncherisseur;
import vues.VueHuissier;

public class main {
    public static void main(String args[]){
        Enchere enchere = new Enchere();
        Lot ordi = new Lot("Ordinateur Doll", 0);
        Articles cm = new Articles("Carte mere Pintel", 100);
        Articles hdd = new Articles("HDD 10TO", 50);
        Articles cg = new Articles("Carte Graphique GTY 1080 it", 250);
        ordi.ajouterComposant(cm);
        ordi.ajouterComposant(hdd);
        ordi.ajouterComposant(cg);
        Lot bureau = new Lot("Bureau Okea", 600);
        enchere.ajouterArticle(ordi);
        enchere.ajouterArticle(bureau);

        enchere.setDiscount(new DiscountRandom());
        new VueHuissier(enchere);
        new VueEncherisseur(enchere);
        new VueEncherisseur(enchere);
        new VueEncherisseur(enchere);
    }
}
