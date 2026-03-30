package Benutzerverwaltung;

public class Benutzer {

    protected String benutzername;
    private String email;
    private String passwort;
    private boolean aktiv;

    // Hauptkonstruktor (verkettet)
    public Benutzer(String benutzername, String email, String passwort) {
        this(benutzername, email, passwort, true);
    }


    // Überladener Konstruktor
    public Benutzer(String benutzername, String email, String passwort, boolean aktiv) {
        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.aktiv = aktiv;
    }

    // Getter
    public String getBenutzername() {
        return benutzername;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    // Setter (nur erlaubt)
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    // Methode info()
    public void info() {
        System.out.println("Benutzer: " + benutzername + " (" + email + ")");
        System.out.println("Aktiv: " + aktiv);
    }
    protected void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }




}
