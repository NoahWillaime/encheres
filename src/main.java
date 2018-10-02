import modele.Articles;
import modele.Enchere;
import vues.VueEncherisseur;
import vues.VueHuissier;

public class main {
    public static void main(String args[]){
        Enchere enchere = new Enchere();
        Articles ordi = new Articles("Ordinateur", 500);
        enchere.ajouterArticle(ordi);
        new VueHuissier(enchere);
    }
}
