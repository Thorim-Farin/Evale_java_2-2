package animals;

public class Lapin extends Herbivore {
    public void faire_un_cri() {
        System.out.println("iiiiiiii");
    }

    @Override
    public void accept(AnalyseStats stats) {
        stats.doForLapin(this);
    }
}
