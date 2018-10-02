package vues;

import modele.Enchere;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VueEncherisseur implements Observer {
    private Enchere modele;
    private JFrame fenetre;

    public VueEncherisseur(Enchere mod){
        mod.addObserver(this);
        this.modele = mod;
        buildFrame();
    }

    public void buildFrame(){
        fenetre = new JFrame("Encherisseur");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.pack();
        fenetre.setVisible(true);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
}
