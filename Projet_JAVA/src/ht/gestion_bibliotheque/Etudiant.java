package ht.gestion_bibliotheque;

import java.util.Scanner;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String tel;
    private String adresse;
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

    public String getSexe() {
        return sexe;
    }

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public Etudiant() {
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

    public boolean setSexe(String sexe) {
        if (sexe.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!sexe.matches("[a-zA-ZÀ-ÿ -]+")) {
            System.out.println("Le sexe ne doit contenir que des lettres");
            return false;
        } else if (!sexe.equalsIgnoreCase("M") && !sexe.equalsIgnoreCase("F")) {
            System.out.println("Veuillez entrer 'M' pour Masculin ou 'F' pour Féminin");
            return false;
        } else {
            this.sexe = sexe;
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

    public void enregistrer() {
        String nom, prenom, sexe, tel, adresse;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- ENREGISTREMENT D'UN ÉTUDIANT ---");

        do {
            System.out.print("Rentrez le nom de l'étudiant: ");
            nom = sc.nextLine();
        } while (!setNom(nom));
        setNom(nom);

        do {
            System.out.print("Rentrez le prénom de l'étudiant: ");
            prenom = sc.nextLine();
        } while (!setPrenom(prenom));
        setPrenom(prenom);

        do {
            System.out.print("Rentrez le sexe (M/F): ");
            sexe = sc.nextLine();
        } while (!setSexe(sexe));
        setSexe(sexe);

        do {
            System.out.print("Rentrez le numéro de téléphone (8 chiffres): ");
            tel = sc.nextLine();
        } while (!setTel(tel));
        setTel(tel);

        do {
            System.out.print("Rentrez l'adresse de l'étudiant : ");
            adresse = sc.nextLine();
        } while (!setAdresse(adresse));
        setAdresse(adresse);

        System.out.println("Étudiant enregistré avec succès !");
    }

    public void afficher() {
        System.out.println("ID de l'étudiant: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Sexe: " + sexe);
        System.out.println("Téléphone: " + tel);
        System.out.println("Adresse: " + adresse);
    }
}