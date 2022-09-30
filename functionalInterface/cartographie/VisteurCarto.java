package functionalInterface.cartographie;

public class VisteurCarto implements VisiteurCartoInterface {

    @Override
    public String exportToXML(Ville v) {
        return new String("<ville>"+v.getNom()+"</ville>");
    }

    @Override
    public String exportToXML(Usine u) {
        return new String("<usine>"+u.getNom()+"</usine>");
    }
}
