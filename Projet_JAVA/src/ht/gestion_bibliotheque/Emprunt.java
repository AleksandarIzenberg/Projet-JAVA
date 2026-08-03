package ht.gestion_bibliotheque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Emprunt {
    private int numEmp;
    private int idEtudiant;
    private String isbn;
    private int idBibliothecaire;
    private String dateEmprunt;
    private String dateRetour;
    private String dateEffective;
    private static int compt = 1;

    public int getNumEmp() {
        return numEmp;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getIdBibliothecaire() {
        return idBibliothecaire;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public String getDateEffective() {
        return dateEffective;
    }

    public Emprunt() {
        numEmp = compt;
        compt++;
        LocalDate aujourdhui = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateEmprunt = aujourdhui.format(formatter);
    }

    public boolean setIdEtudiant(int idEtudiant) {
        if (TestBibliotheque.etudiant == null || TestBibliotheque.etudiant.length == 0) {
            System.out.println("Aucun etudiant enregistre");
            return false;
        }
        boolean existe = false;
        for (int i = 0; i < TestBibliotheque.etudiant.length; i++) {
            if (TestBibliotheque.etudiant[i] != null && TestBibliotheque.etudiant[i].getId() == idEtudiant) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("Cet etudiant n'existe pas");
            return false;
        }
        this.idEtudiant = idEtudiant;
        return true;
    }

    public boolean setIsbn(String isbn) {
        if (isbn.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        }
        if (TestBibliotheque.ouv == null || TestBibliotheque.ouv.length == 0) {
            System.out.println("Aucun ouvrage enregistre");
            return false;
        }
        boolean existe = false;

        for (int i = 0; i < TestBibliotheque.ouv.length; i++) {
            if (TestBibliotheque.ouv[i] != null &&
                    TestBibliotheque.ouv[i].getISBN().equals(isbn)) {

                existe = true;

                if (TestBibliotheque.ouv[i].getDisponible().equals("n")) {
                    System.out.println("Cet ouvrage n'est pas disponible.");
                    return false;
                }

                break;
            }
        }
        if (!existe) {
            System.out.println("Cet ouvrage n'existe pas");
            return false;
        }

        this.isbn = isbn;
        return true;
    }

    public boolean setIdBibliothecaire(int idBibliothecaire) {
        if (TestBibliotheque.bib == null || TestBibliotheque.bib.length == 0) {
            System.out.println("Aucun bibliothecaire enregistre");
            return false;
        }
        boolean existe = false;
        for (int i = 0; i < TestBibliotheque.bib.length; i++) {
            if (TestBibliotheque.bib[i] != null && TestBibliotheque.bib[i].getId() == idBibliothecaire) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("Ce bibliothecaire n'existe pas");
            return false;
        }
        this.idBibliothecaire = idBibliothecaire;
        return true;
    }

    public boolean setDateRetour(String dateRetour) {
        if (dateRetour.trim().isEmpty()) {
            System.out.println("Veuillez remplir ce champ");
            return false;
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dateRet = LocalDate.parse(dateRetour, formatter);
            LocalDate dateEmp = LocalDate.parse(dateEmprunt, formatter);
            
            if (dateRet.isBefore(dateEmp) || dateRet.isEqual(dateEmp)) {
                System.out.println("La date de retour doit etre posterieure a la date d'emprunt (" + dateEmprunt + ")");
                return false;
            }
            
            this.dateRetour = dateRetour;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Format de date invalide. Utilisez le format jj/mm/aaaa");
            return false;
        }
    }

    public void setDateEffective(String dateEffective) {
        this.dateEffective = dateEffective;
    }

    public void effectuerEmprunt() {
        int idEtud, idBib;
        String isbn, dateRet;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EFFECTUER UN EMPRUNT ---");

        if (TestBibliotheque.etudiant == null || TestBibliotheque.etudiant.length == 0) {
            System.out.println("Aucun etudiant enregistre. Veuillez d'abord enregistrer un etudiant.");
            return;
        }

        if (TestBibliotheque.bib == null || TestBibliotheque.bib.length == 0) {
            System.out.println("Aucun bibliothecaire enregistre. Veuillez d'abord enregistrer un bibliothecaire.");
            return;
        }

        if (TestBibliotheque.ouv == null || TestBibliotheque.ouv.length == 0) {
            System.out.println("Aucun ouvrage enregistre. Veuillez d'abord enregistrer un ouvrage.");
            return;
        }

        boolean dispo = false;
        for (int i = 0; i < TestBibliotheque.ouv.length; i++) {
            if (TestBibliotheque.ouv[i] != null && TestBibliotheque.ouv[i].getDisponible().equals("y")) {
                dispo = true;
                break;
            }
        }
        if (!dispo) {
            System.out.println("Aucun ouvrage disponible actuellement.");
            return;
        }

        System.out.println("\nLISTE DES ETUDIANTS :");
        for (int i = 0; i < TestBibliotheque.etudiant.length; i++) {
            if (TestBibliotheque.etudiant[i] != null) {
                System.out.println("ID: " + TestBibliotheque.etudiant[i].getId() + " - " + 
                                  TestBibliotheque.etudiant[i].getPrenom() + " " + 
                                  TestBibliotheque.etudiant[i].getNom());
            }
        }

        do {
            System.out.print("Rentrez l'ID de l'etudiant: ");
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre");
                sc.next();
                System.out.print("Rentrez l'ID de l'etudiant: ");
            }
            idEtud = sc.nextInt();
            sc.nextLine();
        } while (!setIdEtudiant(idEtud));
        setIdEtudiant(idEtud);

        System.out.println("\nLISTE DES OUVRAGES DISPONIBLES :");
        for (int i = 0; i < TestBibliotheque.ouv.length; i++) {
            if (TestBibliotheque.ouv[i] != null && TestBibliotheque.ouv[i].getDisponible().equals("y")) {
                System.out.println("ISBN: " + TestBibliotheque.ouv[i].getISBN() + " - " + 
                                  TestBibliotheque.ouv[i].getTitre() + " (Exemplaires: " + 
                                  TestBibliotheque.ouv[i].getNbreExemplaire() + ")");
            }
        }

        do {
            System.out.print("Rentrez l'ISBN du livre (10 chiffres): ");
            isbn = sc.nextLine();
        } while (!setIsbn(isbn));
        setIsbn(isbn);

        System.out.println("\nDate d'emprunt: " + dateEmprunt);
        do {
            System.out.print("Rentrez la date de retour prevue (jj/mm/aaaa): ");
            dateRet = sc.nextLine();
        } while (!setDateRetour(dateRet));
        setDateRetour(dateRet);

        System.out.println("\nLISTE DES BIBLIOTHECAIRES :");
        for (int i = 0; i < TestBibliotheque.bib.length; i++) {
            if (TestBibliotheque.bib[i] != null) {
                System.out.println("ID: " + TestBibliotheque.bib[i].getId() + " - " + 
                                  TestBibliotheque.bib[i].getPrenom() + " " + 
                                  TestBibliotheque.bib[i].getNom());
            }
        }

        do {
            System.out.print("Rentrez l'ID du bibliothecaire: ");
            while (!sc.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre");
                sc.next();
                System.out.print("Rentrez l'ID du bibliothecaire: ");
            }
            idBib = sc.nextInt();
            sc.nextLine();
        } while (!setIdBibliothecaire(idBib));
        setIdBibliothecaire(idBib);

        for (int i = 0; i < TestBibliotheque.ouv.length; i++) {
            if (TestBibliotheque.ouv[i] != null && TestBibliotheque.ouv[i].getISBN().equals(isbn)) {
                int nbEx = TestBibliotheque.ouv[i].getNbreExemplaire() - 1;
                TestBibliotheque.ouv[i].setNbreExemplaire(nbEx);
                if (nbEx == 0) {
                    TestBibliotheque.ouv[i].setDisponible("n");
                }
                break;
            }
        }

        System.out.println("\nEmprunt effectue avec succes !");
        System.out.println("Numero d'emprunt: " + numEmp);
        System.out.println("Date d'emprunt: " + dateEmprunt);
        System.out.println("Date de retour prevue: " + dateRetour);
    }

    public void retournerEmprunt(int numEmp) {
        if (TestBibliotheque.emp == null || TestBibliotheque.emp.length == 0) {
            System.out.println("Aucun emprunt enregistre.");
            return;
        }

        for (int i = 0; i < TestBibliotheque.emp.length; i++) {
            if (TestBibliotheque.emp[i] != null && TestBibliotheque.emp[i].getNumEmp() == numEmp) {
                if (TestBibliotheque.emp[i].getDateEffective() != null) {
                    System.out.println("Cet emprunt a deja ete retourne.");
                    return;
                }

                LocalDate aujourdhui = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                TestBibliotheque.emp[i].setDateEffective(aujourdhui.format(formatter));

                String isbn = TestBibliotheque.emp[i].getIsbn();
                for (int j = 0; j < TestBibliotheque.ouv.length; j++) {
                    if (TestBibliotheque.ouv[j] != null && TestBibliotheque.ouv[j].getISBN().equals(isbn)) {
                        int nbEx = TestBibliotheque.ouv[j].getNbreExemplaire() + 1;
                        TestBibliotheque.ouv[j].setNbreExemplaire(nbEx);
                        TestBibliotheque.ouv[j].setDisponible("y");
                        break;
                    }
                }

                System.out.println("Retour effectue avec succes pour l'emprunt n°" + numEmp);
                System.out.println("Date effective de retour: " + TestBibliotheque.emp[i].getDateEffective());
                return;
            }
        }
        System.out.println("Emprunt n°" + numEmp + " non trouve.");
    }

    public void afficher() {
        System.out.println("\n--- EMPRUNT N° " + numEmp + " ---");
        System.out.println("ID Etudiant: " + idEtudiant);
        System.out.println("ISBN Livre: " + isbn);
        System.out.println("ID Bibliothecaire: " + idBibliothecaire);
        System.out.println("Date d'emprunt: " + dateEmprunt);
        System.out.println("Date de retour prevue: " + dateRetour);
        if (dateEffective != null) {
            System.out.println("Date effective de retour: " + dateEffective);
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate retour = LocalDate.parse(dateRetour, formatter);
                LocalDate effective = LocalDate.parse(dateEffective, formatter);
                if (effective.isAfter(retour)) {
                    long joursRetard = ChronoUnit.DAYS.between(retour, effective);
                    System.out.println("EN RETARD de " + joursRetard + " jour(s) !");
                } else {
                    System.out.println("Retour dans les delais");
                }
            } catch (Exception e) {
            }
        } else {
            System.out.println("Statut: Non retourne");
        }
    }
}