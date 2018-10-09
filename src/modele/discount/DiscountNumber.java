package modele.discount;

import modele.Lot;

public class DiscountNumber implements Discount{

    public DiscountNumber(){
    }

    @Override
    public int calculDiscount(Lot article) {
        int nb_article = article.getTaille();
        int price = article.getPrice();
        if (nb_article <= 2){
            return price - (price*20)/100;
        } else if(nb_article <= 4){
            return price - (price*30)/100;
        } else if (nb_article >= 6)
            return price - (price*50)/100;
        return price;
    }
}
