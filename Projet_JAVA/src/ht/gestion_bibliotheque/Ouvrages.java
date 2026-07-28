package ht.gestion_bibliotheque;

import java.util.Scanner;

public class Ouvrages {
    private String ISBN;
    private String titre;
    private int categorie;
    private int idRayon;
    private  int NbreExemplaire;
    private String disponible;

    public String getISBN() {
        return ISBN;
    }

    public boolean setISBN(String ISBN) {
        if (ISBN.trim().isEmpty()){
            System.out.println("Veuillez remplir le champ");
            return false;
        } else if (!ISBN.matches("\\d+")) {
            System.out.println("Ne mettez pas de lettres");
            return  false;
        } else if (ISBN.length()!=10) {
            System.out.println("Vous devez mettre 10 chiffres");
            return  false;
        } else {
            this.ISBN=ISBN;
            return  true;
        }
    }

    public String getTitre() {
        return titre;
    }

    public boolean setTitre(String titre) {
        if (titre.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else {
            this.titre = titre;
            return true;
        }
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public int getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(int idRayon) {
        this.idRayon = idRayon;
    }

    public int getNbreExemplaire() {
        return NbreExemplaire;
    }

    public boolean setNbreExemplaire(int NbreExemplaire) {
        if (NbreExemplaire <= 0) {
            System.out.println("Le nombre d'exemplaires doit être supérieur à 0");
            return false;
        } else {
            this.NbreExemplaire = NbreExemplaire;
            return true;
            }
    }

    public String getDisponible() {
        return disponible;
    }

    public boolean setDisponible(String disponible) {
        if (disponible.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        } else if (!disponible.matches("[a-zA-ZÀ-ÿ -]+")) {
            System.out.println("Ne mettez pas de chiffre dans ce champ");
            return false;
        } else if (!disponible.matches("y") && !disponible.matches("n") && !disponible.matches("Y") &&
                !disponible.matches("N")) {
            System.out.println("Veuillez mettre y ou n");
            return  false;
        } else {
            this.disponible = disponible;
            return true;
        }
    }
    public static boolean isbnExiste(String isbn) {
        if (TestBibliotheque.ouv == null) {
            return false;
        }

        for (Ouvrages o : TestBibliotheque.ouv) {
            if (o != null && o.getISBN() != null && isbn.equals(o.getISBN())) {
                return true;
            }
        }

        return false;
    }
    
    public void ajouter(){
        System.out.println("\n--- ENREGISTREMENT D'UN OUVRAGE ---");
        String isbn,nom,disp;
        int nb,ray,cat;
        Scanner sc = new Scanner(System.in);
        if (TestBibliotheque.ray == null || TestBibliotheque.ray.length == 0) {
            System.out.println("Aucun rayon enregistré,Veuillez d'abord enregistrer un rayon.");
            return;
        }
        if (TestBibliotheque.cat == null || TestBibliotheque.cat.length == 0) {
            System.out.println("Aucune catégorie enregistrée,Veuillez d'abord en enregistré une.");
            return;
        }
        do {
            System.out.print("Rentrez l'ISBN du livre (10 chiffres): ");
            isbn = sc.nextLine();

            if (isbnExiste(isbn)) {
                System.out.println("Cet ISBN existe déjà.");
            }

        } while (isbnExiste(isbn) || !setISBN(isbn));
        do {
            System.out.print("Rentrez le titre: ");
            nom = sc.nextLine();
        }while (!setTitre(nom));
        setTitre(nom);
        System.out.println("Liste des catégories :");
        for (int i = 0; i < TestBibliotheque.cat.length; i++) {
            if (TestBibliotheque.cat[i] != null) {
                System.out.println("Code: " + TestBibliotheque.cat[i].getCode() + " - " +
                        TestBibliotheque.cat[i].getNom());
            }
        }
        do {
            System.out.print("Rentrez le code de la catégorie: ");
            while (!sc.hasNextInt()){
                System.out.println("Veuillez rentrer un nombre");
                sc.next();
                System.out.print("Rentrez le code de la catégorie:");
            }
            cat = sc.nextInt();
            sc.nextLine();
            boolean existe = false;
            for (int i =0;i<TestBibliotheque.cat.length;i++){
                if (TestBibliotheque.cat[i] != null &&TestBibliotheque.cat[i].getCode()==cat){
                    existe = true;
                    break;
                }
            }
            if (existe) {
                setCategorie(cat);
                break;
            } else {
                System.out.println("Cette catégorie n'existe pas.");
            }
        }while (true);
        System.out.println("Liste des rayons :");
        for (int i = 0; i < TestBibliotheque.ray.length; i++) {
            if (TestBibliotheque.ray[i] != null) {
                System.out.println("ID: " + TestBibliotheque.ray[i].getId() + " - " +
                        TestBibliotheque.ray[i].getNomRayon());
            }
        }
        do {
            System.out.print("Entrez l'id du rayon : ");
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer uniquement un nombre !");
                sc.next();
                System.out.print("Rentrez l'id du rayon: ");
            }
            ray = sc.nextInt();
            sc.nextLine();

            boolean existe = false;

            for (int i = 0; i < TestBibliotheque.ray.length; i++) {
                if (TestBibliotheque.ray[i] != null &&TestBibliotheque.ray[i].getId() == ray) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                setIdRayon(ray);
                break;
            } else {
                System.out.println("Ce rayon n'existe pas.");
            }

        } while (true);
        do {
            System.out.print("Rentrez le nombre d'exemplaire: ");

            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer uniquement un nombre !");
                sc.next();
                System.out.print("Rentrez le nombre d'exemplaire: ");
            }
            nb = sc.nextInt();
            sc.nextLine();

        } while (!setNbreExemplaire(nb));
        setNbreExemplaire(nb);
        do {
            System.out.print("Ce livre est-il disponible(y/n): ");
            disp = sc.nextLine();
        }while (!setDisponible(disp));
        setDisponible(disp);

    }
    public void lister(){
        System.out.println("\nISBN: "+ISBN);
        System.out.println("Titre: "+titre);
        System.out.println("Catégorie: "+categorie);
        System.out.println("Rayon: "+idRayon);
        System.out.println("Nombre d'exemplaire: "+NbreExemplaire);
        System.out.println("Disponibilité: "+disponible);
    }
}
