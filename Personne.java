import java.util.Date;

public final class Personne {
    private final String nom;
    private final Date dateNaissance;

    public Personne(String nom, Date dateNaissance) {
        this.nom = nom;
//        this.dateNaissance = dateNaissance;
        // Copie défensive
        this.dateNaissance = new Date(dateNaissance.getTime());
    }

    public Date getDateNaissance() {
//        return dateNaissance;
        return new Date(this.dateNaissance.getTime());
    }

    public String getNom() {
        return nom;
    }

}
