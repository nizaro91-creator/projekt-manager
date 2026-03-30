package Benutzerverwaltung;

public class Benutzertest {

    public static void main(String[] args) {

        // Benutzer 1
        Benutzer b1 = new Benutzer("Tim", "tim@test.de", "1234");
        b1.info();
        System.out.println();

        // Benutzer 2 (überladener Konstruktor)
        Benutzer b2 = new Benutzer("Sara", "sara@test.de", "abcd", false);
        b2.info();
        System.out.println();

        // Benutzer 3
        Benutzer b3 = new Benutzer("Ali", "ali@test.de", "pass");
        b3.info();
        System.out.println();

        // Änderung über Setter
        b1.setEmail("tim.neu@test.de");
        b1.setPasswort("9999");

        System.out.println("Nach Änderung:");
        b1.info();
    }


}
