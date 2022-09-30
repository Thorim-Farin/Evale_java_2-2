package animals;

public abstract class Animal implements Survie {
    private int id;
    public String nom;
    public final static float PI = 3.14f;


    public void se_deplacer() {
        System.out.println("marcher");
    }
    public void se_deplacer(boolean courrir) {
        System.out.println(" courrir ? "+courrir);

    }

    public void manger() {
//        if( this instanceof Homme h ) {
//            System.out.println("Homme "+h.nom + " mange");
//        }

        switch (this) {
            case Homme h -> System.out.println("Homme "+h.nom + " mange");
            case Lion l -> System.out.println("Le lion mange ...");

            default -> System.out.println("Cet animal ne sait pas manger");
        }
    }

    @Override
    public abstract void cherhcer_nourriture();

    @Override
    public abstract void faire_un_cri();

    public abstract void accept(AnalyseStats stats);
}
