package ht.gestion_bibliotheque;

import java.util.Scanner;

public class TestBibliotheque {
    static Rayons[] ray = null;
    static Ouvrages[] ouv = null;
    static Categories[] cat = null;
    public static void main(String[] args) {
        int choix;
        Scanner sc = new Scanner(System.in);
    do {
        System.out.println("===Menu Principal===");
        System.out.println("1- Gestion de rayon");
        System.out.println("2- Gestion de Catégorie");
        System.out.println("3- Gestion d'ouvrages");
        System.out.print("Votre choix: ");
        choix = sc.nextInt();
        sc.nextLine();
        switch (choix){
            case 1:
            menuRayon();
            break;
            case  2:
                menuCategorie();
            break;
            case 3:
                menuOuvrage();
        }
    }while (choix!=0);
    }
    public static  void menuRayon(){
        Scanner sc = new Scanner(System.in);
        int choix;
//        Rayons[] ray = null;
        do {
            System.out.println("\n===== GESTION DES RAYONS =====");
            System.out.println("1. Enregistrer un rayon");
            System.out.println("2. Afficher les rayons");
            System.out.println("3. Rechercher un rayon");
            System.out.println("4. Modifier un rayon");
            System.out.println("5. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch(choix) {

                case 1:
                    System.out.print("Combien de rayons voulez-vous enregistrer ? ");
                    int n = sc.nextInt();
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
                    if (ray == null || ray.length==0) {
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
                    if (ray == null || ray.length==0){
                        System.out.println("Aucun rayon enregistré");
                    }else {
                        System.out.print("Entrez l'id du rayon à rechercher : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        boolean trouve = false;

                        for (int i = 0; i < ray.length; i++) {
                            if (ray[i].getId() == id) {
                                System.out.println("\nRayon trouvé :");
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
                    if (ray == null || ray.length==0){
                        System.out.println("Aucun rayon enregistré");
                    }else {
                        System.out.print("Entrez l'id du rayon à modifier : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        boolean trouve = false;
                        for (int i=0;i<ray.length;i++){
                            if (ray[i].getId()==id){
                                String nom;
                                System.out.println("Rentre le nouveau nom du rayon: ");
                                nom = sc.nextLine();
                                ray[i].setNomRayon(nom);
                                trouve = true;
                                System.out.println("Nom modifié avec succès");
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
                    System.out.println("AU revoir");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide");
            }

        } while(choix != 5);
    }
    public static void menuCategorie(){
        Scanner sc = new Scanner(System.in);
        int choix;
//        Categories[] cat = null;
        do {
            System.out.println("\n===== GESTION DES CATÉGORIES =====");
            System.out.println("1. Ajouter une catégorie");
            System.out.println("2. Lister les catégories");
            System.out.println("3. Modifier une catégorie");
            System.out.println("4. Supprimer une catégorie");
            System.out.println("5. Revenir au menu principal");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch(choix) {

                case 1:
                    System.out.print("Combien de catégories voulez-vous ajouter ? ");
                    int n = sc.nextInt();
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
                        System.out.println("\n LISTE DES CATÉGORIES");
                        for (int i = 0; i < cat.length; i++) {
                            if (cat[i] != null) {
                                System.out.println("\ncatégorie " + (i + 1));
                                cat[i].lister();
                            }else {
                                System.out.println("Aucune Catégorie enregistrée");
                            }
                        }
                    }
                    break;
                case 3:
                    int ch;
                    if (cat == null || cat.length == 0){
                        System.out.println("Aucune catégorie enregistrée");
                    }else {
                        System.out.print("Entrez le code de la catégorie à modifier : ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        do {
                            System.out.println("1. Modifier le nom");
                            System.out.println("2. Modifier la description");
                            System.out.println("3. Retour");
                            System.out.print("Votre choix: ");
                            ch = sc.nextInt();
                            sc.nextLine();
                            switch (ch){
                                case 1:
                                    boolean trouve = false;
                                    for (int i=0;i<cat.length;i++){
                                        if (cat[i] != null && cat[i].getCode() == id){
                                            String nom;
                                            System.out.print("Rentrez le nouveau nom de la catégorie: ");
                                            nom = sc.nextLine();
                                            cat[i].setNom(nom);
                                            trouve = true;
                                            System.out.println("Nom modifié avec succès");
                                            break;
                                        }
                                    }
                                    if (!trouve) {
                                        System.out.println("Aucune catégorie trouvée avec le code : " + id);
                                    }
                                    break;
                                case 2:
                                    boolean trouv = false;
                                    for (int i=0;i<cat.length;i++){
                                        if (cat[i] != null && cat[i].getCode() == id){
                                            String des;
                                            System.out.print("Rentrez la nouvelle description de la catégorie: ");
                                            des = sc.nextLine();
                                            cat[i].setDescription(des);
                                            trouv = true;
                                            System.out.println("Description modifiée avec succès");
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
                        }while (ch != 3);
                    }
                    break;
                case 4:
                    if (cat==null || cat.length == 0) {
                        System.out.println("Aucune catégorie enregistrée");
                    }else {
                        System.out.print("Entrez le code de la catégorie à supprimer : ");
                        int id = sc.nextInt();
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
                    System.out.println("AU revoir");
                    System.exit(0);

                default:
                    System.out.println("Choix invalide");
            }

        } while(choix != 5);
    }
    public static  void menuOuvrage(){
        Scanner sc = new Scanner(System.in);
        int choix;
//        Ouvrages[] ouv = null;
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
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Combien d'ouvrages voulez-vous ajouter ? ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    int ancienTaille = (ouv == null) ? 0 : ouv.length;

                    Ouvrages[] nouveauTableau = new Ouvrages[ancienTaille + n];
                    for (int i = 0; i < ancienTaille; i++) {
                        nouveauTableau[i] = ouv[i];
                    }
                    for (int i = ancienTaille; i < ancienTaille + n; i++) {
                        nouveauTableau[i] = new Ouvrages();
                        nouveauTableau[i].ajouter();
                    }
                    ouv = nouveauTableau;
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
                        System.out.print("Entrez l'id du rayon : ");
                        int id = sc.nextInt();
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
                            if (ouv[i].getDisponible().matches("y")){
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
                        int id = sc.nextInt();
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
                    }else {
                        System.out.print("Rentrez l'ISBN de l'ouvrage à modifier: ");
                        String id = sc.nextLine();
                        do {
                            System.out.println("1. Modifier l'ISBN");
                            System.out.println("2. Modifier le titre");
                            System.out.println("3. Modifier la catégorie");
                            System.out.println("4. Modifier le rayon");
                            System.out.println("5. Modifier le nombre d'exemplaire");
                            System.out.println("6. Modifier la dsiponibilité");
                            System.out.println("7. Retour au menu principal");
                            System.out.print("Votre choix: ");
                            ch = sc.nextInt();
                            sc.nextLine();
                            switch (ch){
                                case 1:
                                    boolean trouve = false;
                                    for (int i=0;i<ouv.length;i++){
                                            String isbn;
                                            System.out.print("Rentrez le nouveau ISBN: ");
                                            isbn = sc.nextLine();
                                            ouv[i].setISBN(isbn);
                                            trouve = true;
                                            System.out.println("ISBN modifié avec succès");
                                            break;
                                    }
                                    if (!trouve) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 2:
                                    boolean trouv = false;
                                    for (int i=0;i<ouv.length;i++){
                                        if (ouv[i].getISBN().matches(id)){
                                            String des;
                                            System.out.print("Rentrez le nouveau titre: ");
                                            des = sc.nextLine();
                                            ouv[i].setTitre(des);
                                            trouv = true;
                                            System.out.println("Titre modifié avec succès");
                                            break;
                                        }
                                    }
                                    if (!trouv) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 3:
                                    boolean trou = false;
                                    for (int i=0;i<ouv.length;i++){
                                        if (ouv[i].getISBN().matches(id)){
                                            int cat;
                                            System.out.print("Rentrez la nouvelle catégorie: ");
                                            cat = sc.nextInt();
                                            sc.nextLine();
                                            ouv[i].setCategorie(cat);
                                            trou = true;
                                            System.out.println("Catégorie modifiée avec succès");
                                            break;
                                        }
                                    }
                                    if (!trou) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 4:
                                    boolean tro = false;
                                    for (int i=0;i<ouv.length;i++){
                                        if (ouv[i].getISBN().matches(id)){
                                            int ra;
                                            System.out.print("Rentrez le nouveau rayon: ");
                                            ra = sc.nextInt();
                                            sc.nextLine();
                                            ouv[i].setIdRayon(ra);
                                            tro = true;
                                            System.out.println("Rayon modifié avec succès");
                                            break;
                                        }
                                    }
                                    if (!tro) {
                                        System.out.print("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 5:
                                    boolean tr = false;
                                    for (int i=0;i<ouv.length;i++){
                                        if (ouv[i].getISBN().matches(id)){
                                            int nb;
                                            System.out.print("Rentrez le nouveau nombre d'exemplaire: ");
                                            nb = sc.nextInt();
                                            sc.nextLine();
                                            ouv[i].setNbreExemplaire(nb);
                                            tr = true;
                                            System.out.println("Nombre d'exemplaire modifié avec succès");
                                            break;
                                        }
                                    }
                                    if (!tr) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 6:
                                    boolean t = false;
                                    for (int i=0;i<ouv.length;i++){
                                        if (ouv[i].getISBN().matches(id)){
                                            String dis;
                                            System.out.print("Ce livre est-il disponible?: ");
                                            dis = sc.nextLine();
                                            ouv[i].setDisponible(dis);
                                            t = true;
                                            System.out.println("Disponibilité modifié avec succès");
                                            break;
                                        }
                                    }
                                    if (!t) {
                                        System.out.println("Aucun ouvrage trouvé avec l'ISBN : " + id);
                                    }
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println("Choix invalide");
                            }
                        }while (ch != 7);
                    }
                case 7:
                    System.out.println("Retour au menu principal");
                    break;
                case 0:
                    System.out.println("Au revoir");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide!!!");
            }
        }while(choix != 5);
    }
    }

