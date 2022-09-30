package animals;

public class AnalyseStats implements VisitorStats {
    @Override
    public void doForLion(Lion lion) {
        System.out.println("Stats Lion : "+lion.nom);
    }

    @Override
    public void doForHomme(Homme homme) {
        System.out.println("Stats homme : "+homme.nom);

    }

    @Override
    public void doForHyene(Hyene hyene) {
        System.out.println("Stats hyene : "+hyene.nom);

    }

    @Override
    public void doForLapin(Lapin lapin) {
        System.out.println("Stats lapin : "+lapin.nom);

    }
}
