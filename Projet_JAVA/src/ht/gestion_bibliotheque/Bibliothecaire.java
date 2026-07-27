package ht.gestion_bibliotheque;

import java.util.Scanner;

public class Bibliothecaire {
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    private double salaire;
    private static int compt = 1;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getSalaire() {
        return salaire;
    }

    public Bibliothecaire() {
        id = compt;
        compt++;
    }

    public boolean setNom(String nom) {
        if (nom.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!nom.matches("[a-zA-ZÀ-ÿ -]+")) {
            System.out.println("Le nom ne doit contenir que des lettres");
            return false;
        } else {
            this.nom = nom;
            return true;
        }
    }

    public boolean setPrenom(String prenom) {
        if (prenom.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!prenom.matches("[a-zA-ZÀ-ÿ -]+")) {
            System.out.println("Le prénom ne doit contenir que des lettres");
            return false;
        } else {
            this.prenom = prenom;
            return true;
        }
    }

    public boolean setTel(String tel) {
        if (tel.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!tel.matches("\\d+")) {
            System.out.println("Le téléphone ne doit contenir que des chiffres");
            return false;
        } else if (tel.length() != 8) {
            System.out.println("Le numéro de téléphone doit avoir exactement 8 chiffres");
            return false;
        } else {
            this.tel = tel;
            return true;
        }
    }

    public boolean setAdresse(String adresse) {
        if (adresse.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
//        } else if (!adresse.matches("[a-zA-ZÀ-ÿ\\s'\\-]+")) {
//            System.out.println("L'adresse ne doit contenir que des lettres, espaces, tirets ou apostrophes");
//            return false;
        } else {
            this.adresse = adresse;
            return true;
        }
    }

    public boolean setSalaire(double salaire) {
        if (salaire <= 0) {
            System.out.println("Le salaire doit être supérieur à 0");
            return false;
        } else {
            this.salaire = salaire;
            return true;
        }
    }

    public void enregistrer() {
        String nom, prenom, tel, adresse;
        double salaire;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- ENREGISTREMENT D'UN BIBLIOTHÉCAIRE ---");

        do {
            System.out.print("Rentrez le nom du bibliothécaire: ");
            nom = sc.nextLine();
        } while (!setNom(nom));
        setNom(nom);

        do {
            System.out.print("Rentrez le prénom du bibliothécaire: ");
            prenom = sc.nextLine();
        } while (!setPrenom(prenom));
        setPrenom(prenom);

        do {
            System.out.print("Rentrez le numéro de téléphone (8 chiffres): ");
            tel = sc.nextLine();
        } while (!setTel(tel));
        setTel(tel);

        do {
            System.out.print("Rentrez l'adresse du bibliothécaire : ");
            adresse = sc.nextLine();
        } while (!setAdresse(adresse));
        setAdresse(adresse);

        do {
            System.out.print("Rentrez le salaire du bibliothécaire: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Veuillez entrer un nombre valide");
                sc.next();
                System.out.print("Rentrez le salaire: ");
            }
            salaire = sc.nextDouble();
            sc.nextLine();
        } while (!setSalaire(salaire));
        setSalaire(salaire);

        System.out.println("Bibliothécaire enregistré avec succès !");
    }

    public void afficher() {
        System.out.println("ID du bibliothécaire: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Téléphone: " + tel);
        System.out.println("Adresse: " + adresse);
        System.out.println("Salaire: " + salaire + " HTG");
    }
}