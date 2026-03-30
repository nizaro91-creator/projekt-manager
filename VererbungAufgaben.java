package Benutzerverwaltung;

public class VererbungAufgaben {

    public static void main(String[] args) {

        // Admin erstellen
        Admin admin1 = new Admin("max123", "max@test.de", "adminpass", true);
        admin1.info();
        System.out.println();

        // Gast erstellen
        Gast gast1 = new Gast("anna_guest", "anna@test.de", "gastpass", 20);
        gast1.info();
    }

}
