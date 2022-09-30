package animals;

public class Hyene extends Carnivore {
    public void faire_un_cri() {
        System.out.println("uuuuuuuuu");
    }

    @Override
    public void accept(AnalyseStats stats) {
        stats.doForHyene(this);
    }
}
