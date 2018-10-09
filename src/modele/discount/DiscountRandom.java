package modele.discount;

import modele.Lot;

import java.util.Random;

public class DiscountRandom implements Discount{
    public DiscountRandom(){
    }

    @Override
    public int calculDiscount(Lot article) {
        Random rand = new Random();
        int reduction = rand.nextInt(51);
        int price = article.getPrice();
        return price - (price*reduction)/100;
    }
}
