package Benutzerverwaltung;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // ===== ArrayList anlegen =====
        ArrayList<Benutzer> liste = new ArrayList<>();

        // ===== Testdaten =====
        liste.add(new Benutzer("Tim", "tim@test.de", "1234"));
        liste.add(new Benutzer("Sara", "sara@test.de", "abcd", false));
        liste.add(new Admin("max123", "max@test.de", "adminpass", true));
        liste.add(new Gast("anna_guest", "anna@test.de", "gastpass", 20));

        Scanner sc = new Scanner(System.in);

        // ===== Hauptschleife =====
        while (true) {

            System.out.println("\n= Benutzerverwaltung =");
            System.out.println("1- Benutzerliste anzeigen");
            System.out.println("2- Benutzer hinzufügen");
            System.out.println("3- Benutzer löschen");
            System.out.println("4- Benutzer suchen");
            System.out.println("5- Benutzer bearbeiten");
            System.out.println("6- Spezialfunktionen");
            System.out.println("0- Programm beenden");
            System.out.println("-----");
            System.out.print("Auswahl: ");

            int auswahl = sc.nextInt();
            sc.nextLine();

            switch (auswahl) {

                // ===== Liste anzeigen =====
                case 1:
                    System.out.println("\n===== Benutzerliste =====");

                    if (liste.isEmpty()) {
                        System.out.println("Liste ist leer.");
                    } else {
                        for (Benutzer b : liste) {
                            b.info();
                            System.out.println();
                        }
                    }
                    break;

                // ===== Benutzer hinzufügen =====
                case 2:
                    System.out.println("\nWelchen Typ möchtest du hinzufügen?");
                    System.out.println("1) Benutzer");
                    System.out.println("2) Admin");
                    System.out.println("3) Gast");
                    System.out.print("Auswahl: ");

                    int typ = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Benutzername: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Passwort: ");
                    String passwort = sc.nextLine();

                    switch (typ) {
                        case 1:
                            liste.add(new Benutzer(name, email, passwort));
                            System.out.println("Benutzer hinzugefügt.");
                            break;

                        case 2:
                            System.out.print("SuperAdmin (true/false): ");
                            boolean superAdmin = sc.nextBoolean();
                            sc.nextLine();

                            liste.add(new Admin(name, email, passwort, superAdmin));
                            System.out.println("Admin hinzugefügt.");
                            break;

                        case 3:
                            System.out.print("Gültig bis Tag: ");
                            int gultigbisTage = 20 ;
                            gultigbisTage = sc.nextInt();

                            liste.add(new Gast(name, email, passwort, gultigbisTage));
                            System.out.println("Gast hinzugefügt.");
                            break;

                        default:
                            System.out.println("Ungültiger Typ.");
                    }
                    break;

                // ===== Benutzer löschen =====
                case 3:
                    System.out.print("E-Mail des zu löschenden Benutzers: ");
                    String loeschEmail = sc.nextLine();

                    boolean gefunden = false;

                    for (int i = 0; i < liste.size(); i++) {
                        if (liste.get(i).getEmail().equalsIgnoreCase(loeschEmail)) {
                            liste.remove(i);
                            gefunden = true;
                            System.out.println("Benutzer wurde gelöscht.");
                            break;
                        }
                    }

                    if (!gefunden) {
                        System.out.println("Benutzer nicht gefunden.");
                    }
                    break;

                // ===== Benutzer suchen =====
                case 4:
                    System.out.print("E-Mail des zu suchenden Benutzers: ");
                    String suchEmail = sc.nextLine();

                    boolean gefundenSuche = false;

                    for (Benutzer b : liste) {
                        if (b.getEmail().equalsIgnoreCase(suchEmail)) {
                            System.out.println("Benutzer gefunden:");
                            b.info();
                            gefundenSuche = true;
                            break;
                        }
                    }

                    if (!gefundenSuche) {
                        System.out.println("Benutzer nicht gefunden.");
                    }
                    break;

                // ===== Benutzer bearbeiten =====
                case 5:
                    System.out.print("E-Mail des zu bearbeitenden Benutzers: ");
                    String bearbEmail = sc.nextLine();

                    Benutzer gefundenBenutzer = null;

                    for (Benutzer b : liste) {
                        if (b.getEmail().equalsIgnoreCase(bearbEmail)) {
                            gefundenBenutzer = b;
                            break;
                        }
                    }

                    if (gefundenBenutzer == null) {
                        System.out.println("Benutzer nicht gefunden.");
                        break;
                    }

                    System.out.println("\nBenutzer bearbeiten:");
                    System.out.println("1) Name ändern");
                    System.out.println("2) E-Mail ändern");
                    System.out.println("3) Passwort ändern");
                    System.out.println("0) Abbrechen");
                    System.out.print("Auswahl: ");

                    int edit = sc.nextInt();
                    sc.nextLine();

                    switch (edit) {
                        case 1:
                            System.out.println("Name kann nicht geändert werden (gekapselt).");
                            break;

                        case 2:
                            System.out.print("Neue E-Mail: ");
                            gefundenBenutzer.setEmail(sc.nextLine());
                            System.out.println("E-Mail erfolgreich geändert.");
                            break;

                        case 3:
                            System.out.print("Neues Passwort: ");
                            gefundenBenutzer.setPasswort(sc.nextLine());
                            System.out.println("Passwort erfolgreich geändert.");
                            break;

                        case 0:
                            System.out.println("Abbruch.");
                            break;

                        default:
                            System.out.println("Ungültige Auswahl.");
                    }
                    break;

                // ===== Spezialfunktionen =====
                case 6:
                    System.out.println("\n===== Spezialfunktionen =====");
                    System.out.println("1) Nur Admins anzeigen");
                    System.out.println("2) Nur Gäste anzeigen");
                    System.out.println("3) Mehrere Benutzer löschen");
                    System.out.println("4) Gast: Namen ändern");
                    System.out.println("0) Zurück");
                    System.out.print("Auswahl: ");

                    int spezial = sc.nextInt();
                    sc.nextLine();

                    switch (spezial) {

                        case 1:
                            for (Benutzer b : liste) {
                                if (b instanceof Admin) {
                                    b.info();
                                    System.out.println();
                                }
                            }
                            break;

                        case 2:
                            for (Benutzer b : liste) {
                                if (b instanceof Gast) {
                                    b.info();
                                    System.out.println();
                                }
                            }
                            break;

                        case 3:
                            System.out.print("E-Mails (durch Komma getrennt): ");
                            String[] emails = sc.nextLine().split(",");
                            int count = 0;

                            for (String mail : emails) {
                                mail = mail.trim();

                                for (int i = 0; i < liste.size(); i++) {
                                    if (liste.get(i).getEmail().equalsIgnoreCase(mail)) {
                                        liste.remove(i);
                                        count++;
                                        break;
                                    }
                                }
                            }

                            System.out.println(count + " Benutzer gelöscht.");
                            break;

                        case 4:
                            System.out.print("E-Mail des Gastes: ");
                            String gastMail = sc.nextLine();

                            for (Benutzer b : liste) {
                                if (b instanceof Gast && b.getEmail().equalsIgnoreCase(gastMail)) {

                                    System.out.print("Neuer Name: ");
                                    String neuerName = sc.nextLine();

                                    Gast g = (Gast) b;
                                    g.aendereName(neuerName);

                                    System.out.println("Name geändert.");
                                    break;
                                }
                            }
                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Ungültige Auswahl.");
                    }
                    break;

                // ===== Programm beenden =====
                case 0:
                    System.out.println("Programm wird beendet...");
                    sc.close();
                    return;

                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }
}
