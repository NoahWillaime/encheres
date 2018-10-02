package vues;

import modele.Enchere;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueHuissier implements Observer {
    private Enchere modele;
    private JFrame fenetre;
    private JPanel infos;
    private JLabel[] article;

    public VueHuissier(Enchere mod){
        mod.addObserver(this);
        this.modele = mod;
        buildFrame();
    }

    public void buildFrame(){
        fenetre = new JFrame("Huissier");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        infos = new JPanel();
        infos.setLayout(new BoxLayout(infos, BoxLayout.Y_AXIS));

        article = new JLabel[3];
        article[0] = new JLabel("Article : "+modele.getNom());
        article[1] = new JLabel("Prix : "+modele.getPrix());
        article[2] = new JLabel("Dernière enchère : "+modele.getCurrent_price());
        infos.add(article[0]);
        infos.add(article[1]);
        infos.add(article[2]);

        fenetre.add(infos);
        fenetre.pack();
        fenetre.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
