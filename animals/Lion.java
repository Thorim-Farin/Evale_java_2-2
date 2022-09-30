package animals;

public class Lion extends Carnivore {
    public void faire_un_cri() {
    System.out.println("Grrrrrrrrrrr");
}

    @Override
    public void accept(AnalyseStats stats) {
        stats.doForLion(this);
    }


    public void cherhcer_nourriture() {
        System.out.println("chercher viande vivante");
    }
}
