package cartographie;

public class Ville {
    private String nom;
    public Ville(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public String accept(VisiteurCartoInterface v) {
        return v.exportToXML(this);
    }
}
