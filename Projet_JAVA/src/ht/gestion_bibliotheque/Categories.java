package ht.gestion_bibliotheque;

import java.util.Scanner;

public class Categories {
    private int code;
    private String nom;
    private String description;
    private static int compt = 1;

    public int getCode() {
        return code;
    }
    public Categories() {
        code = compt;
        compt++;
    }

    public String getNom() {
        return nom;
    }

    public boolean setNom(String nom) {
        if (nom.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!nom.matches("[a-zA-ZÀ-ÿ -]+")) {
            System.out.println("Ne mettez pas de chiffre dans ce champ");
            return false;
        } else {
            this.nom = nom;
            return true;
        }
    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (description.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
//        } else if (!description.matches("[a-zA-ZÀ-ÿ -]+")) {
//            System.out.println("Ne mettez pas de chiffre dans ce champ");
//            return false;
        } else {
            this.description = description;
            return true;
        }
    }
    public void ajouter(){
        System.out.println("\n--- ENREGISTREMENT D'UNE CATÉGORIE ---");
        String nomCat,desc;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Rentrez le nom de la catégorie: ");
            nomCat = sc.nextLine();
        }while (!setNom(nomCat)) ;
        setNom(nomCat);
        do {
            System.out.print("Rentrez la description: ");
            desc = sc.nextLine();
        }while (!setDescription(desc));
        setDescription(desc);
    }
    public void lister(){
        System.out.println("Code de la catégorie: "+code);
        System.out.println("Nom de la catégorie: "+nom);
        System.out.println("Description de la catégorie: "+description);
    }
}
