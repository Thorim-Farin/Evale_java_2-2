package animals;

public abstract class Herbivore extends Animal {
    public abstract void faire_un_cri();

    public void cherhcer_nourriture() {
        System.out.println("chercher herbe");
    }
}
