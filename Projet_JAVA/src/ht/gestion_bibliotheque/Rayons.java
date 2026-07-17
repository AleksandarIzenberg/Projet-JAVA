package ht.gestion_bibliotheque;

import java.util.Scanner;

public class Rayons {

    private int id;
    private String nomRayon;
    private static int compt = 1;

    public int getId() {
        return id;
    }
    public Rayons() {
        id = compt;
        compt++;
    }

    public String getNomRayon() {
        return nomRayon;
    }

    public boolean setNomRayon(String nomRayon) {
        if (nomRayon.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!nomRayon.matches("[a-zA-ZÀ-ÿ -]+")) {
            System.out.println("Ne mettez pas de chiffre dans ce champ");
            return false;
        } else {
            this.nomRayon = nomRayon;
            return true;
        }
    }
    public void enregister(){
        String nom;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Rentrez le nom du rayon: ");
            nom = sc.nextLine();
        }while (!setNomRayon(nom)) ;
        setNomRayon(nom);
    }
    public void afficher(){
        System.out.println("Id du rayon: "+id);
        System.out.println("Nom du rayon: "+nomRayon);
    }
}
