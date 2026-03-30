package Benutzerverwaltung;

public class Admin extends Benutzer {

    private boolean superAdmin;

    public Admin(String benutzername, String email, String passwort, boolean superAdmin) {
        super(benutzername, email, passwort);
        this.superAdmin = superAdmin;
    }

    public Admin(String benutzername, String email, String passwort, boolean aktiv, boolean superAdmin) {
        super(benutzername, email, passwort, aktiv);
        this.superAdmin = superAdmin;
    }

    @Override
    public void info() {
        System.out.println("Admin: " + getBenutzername() + " (" + getEmail() + "), SuperAdmin: " + superAdmin);
        System.out.println("Aktiv: " + isAktiv());
    }
}
