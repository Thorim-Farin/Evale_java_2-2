package animals;

public class Homme extends Omnivore {
    public void faire_un_cri() {
//        this.nom = "homme";
        System.out.println(this.nom);
        System.out.println("AAAAAAAAAAHHHHHHHH");
    }

    @Override
    public void accept(AnalyseStats stats) {
        stats.doForHomme(this);
    }
}
