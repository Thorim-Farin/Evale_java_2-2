package thread;

import java.util.Random;

public class ThreadTraitement implements Runnable {
    private int id;
    private int compteur = 5;
    private FakeObjet fakeObjet;

    public ThreadTraitement(int id) {
        this.id = id;
        this.fakeObjet = null;
    }

    public ThreadTraitement(int id, FakeObjet f) {
        this.id = id;
        this.fakeObjet = f;
    }

    @Override
    public void run() {
        while (this.compteur>0) {
            System.out.println("Thread N°"+this.id + " compteur restant : " + this.compteur);

//            this.fakeObjet.pushToList(this.id);
//            if( this.fakeObjet.checkInList(this.id) ) {
//                System.out.println(this.id + " est present dans le fake object");
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.compteur--;
        }
    }
}
