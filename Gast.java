package Benutzerverwaltung;


public class Gast extends Benutzer {

    private int gueltigBisTag;
    private String setBenutzernname;

    public Gast(String benutzername, String email, String passwort, int gueltigBisTag) {
        super(benutzername, email, passwort);
        this.gueltigBisTag = gueltigBisTag;
    }

    public Gast(String benutzername, String email, String passwort, boolean aktiv, int gueltigBisTag) {
        super(benutzername, email, passwort, aktiv);
        this.gueltigBisTag = gueltigBisTag;
    }

    @Override
    public void info() {
        System.out.println("Gast: " + getBenutzername() + ", gültig bis Tag " + gueltigBisTag);
        System.out.println("Aktiv: " + isAktiv());
    }
    public void aendereName(String neuerName) {
        setBenutzername(neuerName);
    }

}
