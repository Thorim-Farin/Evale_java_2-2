package functionalInterface.cartographie;

public class Usine {
    private String nom;
    public Usine(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String accept(VisiteurCartoInterface v) {
        return v.exportToXML(this);
    }
}
