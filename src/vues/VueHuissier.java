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
    private JButton stop;
    private JButton start;

    public VueHuissier(Enchere mod){
        mod.addObserver(this);
        this.modele = mod;
        buildFrame();
    }

    public void buildFrame(){
        fenetre = new JFrame("Huissier");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setPreferredSize(new Dimension(500, 300));

        infos = new JPanel();
        infos.setLayout(new GridLayout(6, 1));

        article = new JLabel[4];
        article[0] = new JLabel("Article : "+modele.getNom());
        article[1] = new JLabel("Prix : "+modele.getPrix());
        article[2] = new JLabel("Dernière enchère : "+modele.getLastEnchere());
        article[3] = new JLabel("Depot : "+modele.getDepot());

        infos.add(article[0]);
        infos.add(article[1]);
        infos.add(article[2]);
        infos.add(article[3]);

        start = new JButton("Start");
        start.addActionListener(e -> {
            modele.startEnchere();
        });
        infos.add(start);
        if (modele.getOpen()) {
            start.setEnabled(false);
        }

        stop = new JButton("Stop");
        stop.addActionListener(e -> {
            modele.stopEnchere();
        });
        infos.add(stop);
        if (!modele.getOpen()){
            stop.setEnabled(false);
        }

        fenetre.add(infos);
        fenetre.pack();
        fenetre.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        article[0].setText("Article : "+modele.getNom());
        article[1].setText("Prix : "+modele.getPrix());
        article[2].setText("Dernière enchère : "+modele.getLastEnchere());
        article[3].setText("Depot : "+modele.getDepot());

        if (modele.getOpen()) {
            stop.setEnabled(true);
            start.setEnabled(false);
        } else {
            stop.setEnabled(false);
            start.setEnabled(true);
        }
    }
}
