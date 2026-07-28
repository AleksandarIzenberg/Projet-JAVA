package ht.gestion_bibliotheque;

import java.util.Scanner;

public class TestBibliotheque {
    static Rayons[] ray = null;
    static Ouvrages[] ouv = null;
    static Categories[] cat = null;
    static Etudiant[] etudiant = null;
    static Bibliothecaire[] bib = null;
    static Emprunt[] emp = null;

    public static void main(String[] args) {
        int choix;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1- Gestion des rayons");
            System.out.println("2- Gestion des catégories");
            System.out.println("3- Gestion des ouvrages");
            System.out.println("4- Gestion des étudiants");
            System.out.println("5- Gestion des bibliothecaires");
            System.out.println("6- Gestion des emprunts");
            System.out.println("0- Quitter");
            System.out.print("Votre choix: ");
            choix = lireEntier(sc, 0, 6);
            sc.nextLine();

            switch (choix) {
                case 1:
                    menuRayon();
                    break;
                case 2:
                    menuCategorie();
                    break;
                case 3:
                    menuOuvrage();
                    break;
                case 4:
                    menuEtudiant();
                    break;
                case 5:
                    menuBibliothecaire();
                    break;
                case 6:
                    menuEmprunt();
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        } while (choix != 0);
    }

    public static int lireEntier(Scanner sc, int min, int max) {
        int valeur;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Veuillez entrer un nombre valide: ");
                sc.next();
            }
            valeur = sc.nextInt();
            if (valeur >= min && valeur <= max) {
                break;
            } else {
                System.out.print("Veuillez entrer un nombre entre " + min + " et " + max + ": ");
            }
        }
        return valeur;
    }

    public static void menuRayon() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== GESTION DES RAYONS =====");
            System.out.println("1. Enregistrer un rayon");
            System.out.println("2. Afficher les rayons");
            System.out.println("3. Rechercher un rayon");
            System.out.println("4. Modifier un rayon");
            System.out.println("5. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = lireEntier(sc, 0, 5);
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Combien de rayons voulez-vous enregistrer? ");
                    int n = lireEntier(sc, 1, 100);
                    sc.nextLine();
                    int ancienTaille = (ray == null) ? 0 : ray.length;
                    Rayons[] nouveauTableau = new Rayons[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = ray[i];
                    }
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Rayons();
                        nouveauTableau[i].enregister();
                    }
                    ray = nouveauTableau;
                    break;
                case 2:
                    if (ray == null || ray.length == 0) {
                        System.out.println("Aucun rayon enregistré");
                    } else {
                        System.out.println("\n LISTE DES RAYONS");
                        for (int i = 0; i < ray.length; i++) {
                            System.out.println("\nRayon " + (i + 1));
                            ray[i].afficher();
                        }
                    }
                    break;
                case 3:
                    if (ray == null || ray.length == 0) {
                        System.out.println("Aucun rayon enregistré");
                    } else {
                        System.out.print("Entrez l'id du rayon a rechercher : ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < ray.length; i++) {
                            if (ray[i].getId() == id) {
                                System.out.println("\nRayon trouvé:");
                                ray[i].afficher();
                                trouve = true;
                                break;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun rayon trouvé avec l'Id: " + id);
                        }
                    }
                    break;
                case 4:
                    if (ray == null || ray.length == 0) {
                        System.out.println("Aucun rayon enregistré");
                    } else {
                        System.out.print("Entrez l'id du rayon à modifier : ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < ray.length; i++) {
                            if (ray[i].getId() == id) {
                                String nom;
                                System.out.print("Entrez le nouveau nom du rayon: ");
                                nom = sc.nextLine();
                                ray[i].setNomRayon(nom);
                                trouve = true;
                                System.out.println("Nom modifié avec succes!");
                                break;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun rayon trouvé avec l'Id: " + id);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 5);
    }

    public static void menuCategorie() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== GESTION DES CATEGORIES =====");
            System.out.println("1. Ajouter une catégorie");
            System.out.println("2. Lister les catégories");
            System.out.println("3. Modifier une catégorie");
            System.out.println("4. Supprimer une catégorie");
            System.out.println("5. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = lireEntier(sc, 0, 5);
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Combien de catégories voulez-vous ajouter? ");
                    int n = lireEntier(sc, 1, 100);
                    sc.nextLine();
                    int ancienTaille = (cat == null) ? 0 : cat.length;
                    Categories[] nouveauTableau = new Categories[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = cat[i];
                    }
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Categories();
                        nouveauTableau[i].ajouter();
                    }
                    cat = nouveauTableau;
                    break;
                case 2:
                    if (cat == null || cat.length == 0) {
                        System.out.println("Aucune catégorie enregistrée");
                    } else {
                        System.out.println("\n LISTE DES CATEGORIES");
                        for (int i = 0; i < cat.length; i++) {
                            if (cat[i] != null) {
                                System.out.println("\ncatégorie " + (i + 1));
                                cat[i].lister();
                            }
                        }
                    }
                    break;
                case 3:
                    int ch;
                    if (cat == null || cat.length == 0) {
                        System.out.println("Aucune catégorie enregistrée");
                    } else {
                        System.out.print("Entrez le code de la catégorie à modifier : ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        do {
                            System.out.println("1. Modifier le nom");
                            System.out.println("2. Modifier la description");
                            System.out.println("3. Retour");
                            System.out.print("Votre choix: ");
                            ch = lireEntier(sc, 1, 3);
                            sc.nextLine();
                            switch (ch) {
                                case 1:
                                    boolean trouve = false;
                                    for (int i = 0; i < cat.length; i++) {
                                        if (cat[i] != null && cat[i].getCode() == id) {
                                            String nom;
                                            System.out.print("Entrez le nouveau nom de la catégorie: ");
                                            nom = sc.nextLine();
                                            cat[i].setNom(nom);
                                            trouve = true;
                                            System.out.println("Nom modifié avec succes");
                                            break;
                                        }
                                    }
                                    if (!trouve) {
                                        System.out.println("Aucune catégorie trouvée avec le code : " + id);
                                    }
                                    break;
                                case 2:
                                    boolean trouv = false;
                                    for (int i = 0; i < cat.length; i++) {
                                        if (cat[i] != null && cat[i].getCode() == id) {
                                            String des;
                                            System.out.print("Entrez la nouvelle description de la catégorie: ");
                                            des = sc.nextLine();
                                            cat[i].setDescription(des);
                                            trouv = true;
                                            System.out.println("Description modifiée avec succes");
                                            break;
                                        }
                                    }
                                    if (!trouv) {
                                        System.out.println("Aucune catégorie trouvée avec le code : " + id);
                                    }
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Choix invalide");
                            }
                        } while (ch != 3);
                    }
                    break;
                case 4:
                    if (cat == null || cat.length == 0) {
                        System.out.println("Aucune catégorie enregistrée");
                    } else {
                        System.out.print("Entrez le code de la catégorie à supprimer : ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < cat.length; i++) {
                            if (cat[i] != null && cat[i].getCode() == id) {
                                Categories[] nouveau = new Categories[cat.length - 1];
                                int k = 0;
                                for (int j = 0; j < cat.length; j++) {
                                    if (j != i) {
                                        nouveau[k++] = cat[j];
                                    }
                                }
                                cat = nouveau;
                                trouve = true;
                                System.out.println("Catégorie supprimée avec succès.");
                                break;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Catégorie introuvable.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 5);
    }

    public static void menuOuvrage() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== GESTION DES OUVRAGES =====");
            System.out.println("1. Ajouter un ouvrage");
            System.out.println("2. Lister les ouvrage");
            System.out.println("3. Lister les ouvrages d'un rayon");
            System.out.println("4. Lister les ouvrages disponibles");
            System.out.println("5. Lister les ouvrages d'une catégorie");
            System.out.println("6. Modifier les informations d'ouvrage");
            System.out.println("7. Retour au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = lireEntier(sc, 0, 7);
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.print("Combien d'ouvrages voulez-vous ajouter? ");
                    int n = lireEntier(sc, 1, 100);
                    sc.nextLine();
                    int ancienTaille = (ouv == null) ? 0 : ouv.length;
                    Ouvrages[] nouveauTableau = new Ouvrages[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = ouv[i];
                    }
                    ouv = nouveauTableau;
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Ouvrages();
                        nouveauTableau[i].ajouter();
                    }

                    break;
                case 2:
                    if (ouv == null || ouv.length == 0) {
                        System.out.println("Aucun ouvrages enregistré");
                    } else {
                        System.out.println("\n LISTE DES OUVRAGES");
                        for (int i = 0; i < ouv.length; i++) {
                            ouv[i].lister();
                        }
                    }
                    break;
                case 3:
                    if (ouv == null || ouv.length == 0) {
                        System.out.println("Aucun ouvrage enregistré.");
                    } else {
                        System.out.print("Entrez l'id du rayon: ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < ouv.length; i++) {
                            if (ouv[i].getIdRayon() == id) {
                                ouv[i].lister();
                                trouve = true;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun ouvrage dans ce rayon.");
                        }
                    }
                    break;
                case 4:
                    if (ouv == null || ouv.length == 0) {
                        System.out.println("Aucun ouvrage enregistré");
                    } else {
                        System.out.println("\n LISTE DES OUVRAGES DISPONIBLES");
                        boolean trouve = false;
                        for (int i = 0; i < ouv.length; i++) {
                            if (ouv[i].getDisponible().equals("y")) {
                                ouv[i].lister();
                                trouve = true;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun ouvrage disponible");
                        }
                    }
                    break;
                case 5:
                    if (ouv == null || ouv.length == 0) {
                        System.out.println("Aucun ouvrage enregistrée");
                    } else {
                        System.out.print("Entrez le code de la catégorie : ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < ouv.length; i++) {
                            if (ouv[i].getCategorie() == id) {
                                ouv[i].lister();
                                trouve = true;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun ouvrage dans cette catégorie");
                        }
                    }
                    break;
                case 6:
                    int ch;
                    if (ouv == null || ouv.length == 0) {
                        System.out.println("Aucune catégorie enregistrée");
                    } else {
                        System.out.print("Entrez l'ISBN de l'ouvrage a modifier: ");
                        String id = sc.nextLine();
                        do {
                            System.out.println("1. Modifier l'ISBN");
                            System.out.println("2. Modifier le titre");
                            System.out.println("3. Modifier la catégorie");
                            System.out.println("4. Modifier le rayon");
                            System.out.println("5. Modifier le nombre d'exemplaire");
                            System.out.println("6. Modifier la disponibilité");
                            System.out.println("7. Retour");
                            System.out.print("Votre choix: ");
                            ch = lireEntier(sc, 1, 7);
                            sc.nextLine();
                            switch (ch) {
                                case 1:
                                    boolean trouve = false;
                                    for (int i = 0; i < ouv.length; i++) {
                                        if (ouv[i].getISBN().equals(id)) {
                                            String isbn;
                                            System.out.print("Entrez le nouveau ISBN: ");
                                            isbn = sc.nextLine();
                                            ouv[i].setISBN(isbn);
                                            trouve = true;
                                            System.out.println("ISBN modifié avec succes");
                                            break;
                                        }
                                    }
                                    if (!trouve) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 2:
                                    boolean trouv = false;
                                    for (int i = 0; i < ouv.length; i++) {
                                        if (ouv[i].getISBN().equals(id)) {
                                            String des;
                                            System.out.print("Entrez le nouveau titre: ");
                                            des = sc.nextLine();
                                            ouv[i].setTitre(des);
                                            trouv = true;
                                            System.out.println("Titre modifié avec succes");
                                            break;
                                        }
                                    }
                                    if (!trouv) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 3:
                                    boolean trou = false;
                                    for (int i = 0; i < ouv.length; i++) {
                                        if (ouv[i].getISBN().equals(id)) {
                                            int cat;
                                            System.out.print("Entrez la nouvelle catégorie: ");
                                            cat = lireEntier(sc, 1, 9999);
                                            sc.nextLine();
                                            ouv[i].setCategorie(cat);
                                            trou = true;
                                            System.out.println("Catégorie modifiée avec succes");
                                            break;
                                        }
                                    }
                                    if (!trou) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN: " + id);
                                    }
                                    break;
                                case 4:
                                    boolean tro = false;
                                    for (int i = 0; i < ouv.length; i++) {
                                        if (ouv[i].getISBN().equals(id)) {
                                            int ra;
                                            System.out.print("Entrez le nouveau rayon: ");
                                            ra = lireEntier(sc, 1, 9999);
                                            sc.nextLine();
                                            ouv[i].setIdRayon(ra);
                                            tro = true;
                                            System.out.println("Rayon modifié avec succes");
                                            break;
                                        }
                                    }
                                    if (!tro) {
                                        System.out.print("Aucun ouvrage trouvé avec l'ISBN: " + id);
                                    }
                                    break;
                                case 5:
                                    boolean tr = false;
                                    for (int i = 0; i < ouv.length; i++) {
                                        if (ouv[i].getISBN().equals(id)) {
                                            int nb;
                                            System.out.print("Entrez le nouveau nombre d'exemplaire: ");
                                            nb = lireEntier(sc, 1, 9999);
                                            sc.nextLine();
                                            ouv[i].setNbreExemplaire(nb);
                                            tr = true;
                                            System.out.println("Nombre d'exemplaire modifié avec succes");
                                            break;
                                        }
                                    }
                                    if (!tr) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN: " + id);
                                    }
                                    break;
                                case 6:
                                    boolean t = false;
                                    for (int i = 0; i < ouv.length; i++) {
                                        if (ouv[i].getISBN().equals(id)) {
                                            String dis;
                                            System.out.print("Ce livre est-il disponible? (y/n): ");
                                            dis = sc.nextLine();
                                            ouv[i].setDisponible(dis);
                                            t = true;
                                            System.out.println("Disponibilite modifié avec succes");
                                            break;
                                        }
                                    }
                                    if (!t) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN: " + id);
                                    }
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println("Choix invalide");
                            }
                        } while (ch != 7);
                    }
                    break;
                case 7:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 7);
    }

    public static void menuEtudiant() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== GESTION DES ETUDIANTS =====");
            System.out.println("1. Enregistrer un étudiant");
            System.out.println("2. Lister les étudiants");
            System.out.println("3. Modifier les informations d'un étudiant");
            System.out.println("4. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = lireEntier(sc, 0, 4);
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Combien d'étudiants voulez-vous enregistrer? ");
                    int n = lireEntier(sc, 1, 100);
                    sc.nextLine();
                    int ancienTaille = (etudiant == null) ? 0 : etudiant.length;
                    Etudiant[] nouveauTableau = new Etudiant[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = etudiant[i];
                    }
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Etudiant();
                        nouveauTableau[i].enregistrer();
                    }
                    etudiant = nouveauTableau;
                    break;
                case 2:
                    if (etudiant == null || etudiant.length == 0) {
                        System.out.println("Aucun étudiant enregistré");
                    } else {
                        System.out.println("\n=== LISTE DES ETUDIANTS ===");
                        for (int i = 0; i < etudiant.length; i++) {
                            if (etudiant[i] != null) {
                                System.out.println("\nEtudiant " + (i + 1));
                                etudiant[i].afficher();
                            }
                        }
                    }
                    break;
                case 3:
                    if (etudiant == null || etudiant.length == 0) {
                        System.out.println("Aucun étudiant enregistré");
                    } else {
                        System.out.print("Entrez l'ID de l'étudiant à modifier: ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < etudiant.length; i++) {
                            if (etudiant[i] != null && etudiant[i].getId() == id) {
                                System.out.println("\n--- Modification de l'étudiant ---");
                                System.out.println("1. Modifier le nom");
                                System.out.println("2. Modifier le prenom");
                                System.out.println("3. Modifier le sexe");
                                System.out.println("4. Modifier le téléphone");
                                System.out.println("5. Modifier l'adresse");
                                System.out.println("6. Retour");
                                System.out.print("Votre choix: ");
                                int ch = lireEntier(sc, 1, 6);
                                sc.nextLine();
                                switch (ch) {
                                    case 1:
                                        String nom;
                                        do {
                                            System.out.print("Entrez le nouveau nom: ");
                                            nom = sc.nextLine();
                                        } while (!etudiant[i].setNom(nom));
                                        etudiant[i].setNom(nom);
                                        System.out.println("Nom modifié avec succes");
                                        break;
                                    case 2:
                                        String prenom;
                                        do {
                                            System.out.print("Entrez le nouveau prénom: ");
                                            prenom = sc.nextLine();
                                        } while (!etudiant[i].setPrenom(prenom));
                                        etudiant[i].setPrenom(prenom);
                                        System.out.println("Prénom modifié avec succes");
                                        break;
                                    case 3:
                                        String sexe;
                                        do {
                                            System.out.print("Entrez le nouveau sexe (M/F): ");
                                            sexe = sc.nextLine();
                                        } while (!etudiant[i].setSexe(sexe));
                                        etudiant[i].setSexe(sexe);
                                        System.out.println("Sexe modifié avec succes");
                                        break;
                                    case 4:
                                        String tel;
                                        do {
                                            System.out.print("Entrez le nouveau téléphone (8 chiffres): ");
                                            tel = sc.nextLine();
                                        } while (!etudiant[i].setTel(tel));
                                        etudiant[i].setTel(tel);
                                        System.out.println("Téléphone modifié avec succes");
                                        break;
                                    case 5:
                                        String adresse;
                                        do {
                                            System.out.print("Entrez la nouvelle adresse: ");
                                            adresse = sc.nextLine();
                                        } while (!etudiant[i].setAdresse(adresse));
                                        etudiant[i].setAdresse(adresse);
                                        System.out.println("Adresse modifiée avec succes");
                                        break;
                                    case 6:
                                        System.out.println("Retour");
                                        break;
                                    default:
                                        System.out.println("Choix invalide");
                                }
                                trouve = true;
                                break;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun étudiant trouvé avec l'ID : " + id);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 4);
    }

    public static void menuBibliothecaire() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== GESTION DES BIBLIOTHECAIRES =====");
            System.out.println("1. Enregistrer un bibliothecaire");
            System.out.println("2. Lister les bibliothecaires");
            System.out.println("3. Modifier les informations d'un bibliothecaire");
            System.out.println("4. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = lireEntier(sc, 0, 4);
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Combien de bibliothecaires voulez-vous enregistrer? ");
                    int n = lireEntier(sc, 1, 100);
                    sc.nextLine();
                    int ancienTaille = (bib == null) ? 0 : bib.length;
                    Bibliothecaire[] nouveauTableau = new Bibliothecaire[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = bib[i];
                    }
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Bibliothecaire();
                        nouveauTableau[i].enregistrer();
                    }
                    bib = nouveauTableau;
                    break;
                case 2:
                    if (bib == null || bib.length == 0) {
                        System.out.println("Aucun bibliothecaire enregistré");
                    } else {
                        System.out.println("\n=== LISTE DES BIBLIOTHECAIRES ===");
                        for (int i = 0; i < bib.length; i++) {
                            if (bib[i] != null) {
                                System.out.println("\nBibliothecaire " + (i + 1));
                                bib[i].afficher();
                            }
                        }
                    }
                    break;
                case 3:
                    if (bib == null || bib.length == 0) {
                        System.out.println("Aucun bibliothecaire enregistré");
                    } else {
                        System.out.print("Entrez l'ID du bibliothecaire a modifier: ");
                        int id = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i = 0; i < bib.length; i++) {
                            if (bib[i] != null && bib[i].getId() == id) {
                                System.out.println("\n--- Modification du bibliothecaire ---");
                                System.out.println("1. Modifier le nom");
                                System.out.println("2. Modifier le prénom");
                                System.out.println("3. Modifier le telephone");
                                System.out.println("4. Modifier l'adresse");
                                System.out.println("5. Modifier le salaire");
                                System.out.println("6. Retour");
                                System.out.print("Votre choix: ");
                                int ch = lireEntier(sc, 1, 6);
                                sc.nextLine();
                                switch (ch) {
                                    case 1:
                                        String nom;
                                        do {
                                            System.out.print("Entrez le nouveau nom: ");
                                            nom = sc.nextLine();
                                        } while (!bib[i].setNom(nom));
                                        bib[i].setNom(nom);
                                        System.out.println("Nom modifié avec succes");
                                        break;
                                    case 2:
                                        String prenom;
                                        do {
                                            System.out.print("Entrez le nouveau prénom: ");
                                            prenom = sc.nextLine();
                                        } while (!bib[i].setPrenom(prenom));
                                        bib[i].setPrenom(prenom);
                                        System.out.println("Prénom modifie avec succes");
                                        break;
                                    case 3:
                                        String tel;
                                        do {
                                            System.out.print("Entrez le nouveau téléphone (8 chiffres): ");
                                            tel = sc.nextLine();
                                        } while (!bib[i].setTel(tel));
                                        bib[i].setTel(tel);
                                        System.out.println("Téléphone modifié avec succes");
                                        break;
                                    case 4:
                                        String adresse;
                                        do {
                                            System.out.print("Entrez la nouvelle adresse: ");
                                            adresse = sc.nextLine();
                                        } while (!bib[i].setAdresse(adresse));
                                        bib[i].setAdresse(adresse);
                                        System.out.println("Adresse modifiée avec succes");
                                        break;
                                    case 5:
                                        double salaire;
                                        do {
                                            System.out.print("Entrez le nouveau salaire: ");
                                            while (!sc.hasNextDouble()) {
                                                System.out.println("Veuillez entrer un nombre valide");
                                                sc.next();
                                                System.out.print("Entrez le salaire: ");
                                            }
                                            salaire = sc.nextDouble();
                                            sc.nextLine();
                                        } while (!bib[i].setSalaire(salaire));
                                        bib[i].setSalaire(salaire);
                                        System.out.println("Salaire modifié avec succes");
                                        break;
                                    case 6:
                                        System.out.println("Retour");
                                        break;
                                    default:
                                        System.out.println("Choix invalide");
                                }
                                trouve = true;
                                break;
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun bibliothecaire trouvé avec l'ID: " + id);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 4);
    }

    public static void menuEmprunt() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== GESTION DES EMPRUNTS =====");
            System.out.println("1. Effectuer un emprunt");
            System.out.println("2. Lister les emprunts");
            System.out.println("3. Retourner un emprunt");
            System.out.println("4. Lister les emprunts en retard");
            System.out.println("5. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = lireEntier(sc, 0, 5);
            sc.nextLine();

            switch (choix) {
                case 1:
                    if (etudiant == null || etudiant.length == 0) {
                        System.out.println("Aucun étudiant enregistré. Veuillez d'abord enregistrer un étudiant.");
                        break;
                    }
                    if (bib == null || bib.length == 0) {
                        System.out.println("Aucun bibliothecaire enregistré. Veuillez d'abord enregistrer un bibliothecaire.");
                        break;
                    }
                    if (ouv == null || ouv.length == 0) {
                        System.out.println("Aucun ouvrage enregistré. Veuillez d'abord enregistrer un ouvrage.");
                        break;
                    }
                    boolean dispo = false;
                    for (int i = 0; i < ouv.length; i++) {
                        if (ouv[i] != null && ouv[i].getDisponible().equals("y")) {
                            dispo = true;
                            break;
                        }
                    }
                    if (!dispo) {
                        System.out.println("Aucun ouvrage disponible actuellement.");
                        break;
                    }

                    System.out.print("Combien d'emprunts voulez-vous effectuer? ");
                    int n = lireEntier(sc, 1, 100);
                    sc.nextLine();
                    int ancienTaille = (emp == null) ? 0 : emp.length;
                    Emprunt[] nouveauTableau = new Emprunt[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = emp[i];
                    }
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Emprunt();
                        nouveauTableau[i].effectuerEmprunt();
                    }
                    emp = nouveauTableau;
                    break;
                case 2:
                    if (emp == null || emp.length == 0) {
                        System.out.println("Aucun emprunt enregistré");
                    } else {
                        System.out.println("\n=== LISTE DES EMPRUNTS ===");
                        for (int i = 0; i < emp.length; i++) {
                            if (emp[i] != null) {
                                emp[i].afficher();
                            }
                        }
                    }
                    break;
                case 3:
                    if (emp == null || emp.length == 0) {
                        System.out.println("Aucun emprunt enregistré");
                    } else {
                        System.out.print("Entrez le numero de l'emprunt à retourner : ");
                        int num = lireEntier(sc, 1, 9999);
                        sc.nextLine();
                        boolean dejaRetourne = false;
                        for (int i = 0; i < emp.length; i++) {
                            if (emp[i] != null && emp[i].getNumEmp() == num) {
                                if (emp[i].getDateEffective() != null) {
                                    System.out.println("Cet emprunt a deja ete retourné.");
                                    dejaRetourne = true;
                                    break;
                                }
                            }
                        }
                        if (!dejaRetourne) {
                            Emprunt e = new Emprunt();
                            e.retournerEmprunt(num);
                        }
                    }
                    break;
                case 4:
                    if (emp == null || emp.length == 0) {
                        System.out.println("Aucun emprunt enregistre");
                    } else {
                        System.out.println("\n=== EMPRUNTS EN RETARD ===");
                        boolean trouve = false;
                        for (int i = 0; i < emp.length; i++) {
                            if (emp[i] != null && emp[i].getDateEffective() != null) {
                                String dateRetour = emp[i].getDateRetour();
                                String dateEffective = emp[i].getDateEffective();
                                if (dateRetour != null && dateEffective != null) {
                                    try {
                                        java.time.format.DateTimeFormatter formatter = 
                                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        java.time.LocalDate retour = java.time.LocalDate.parse(dateRetour, formatter);
                                        java.time.LocalDate effective = java.time.LocalDate.parse(dateEffective, formatter);
                                        if (effective.isAfter(retour)) {
                                            emp[i].afficher();
                                            trouve = true;
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        }
                        if (!trouve) {
                            System.out.println("Aucun emprunt en retard.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 5);
    }
}