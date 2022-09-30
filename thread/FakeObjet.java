package thread;

import java.util.ArrayList;

public class FakeObjet {
    private ArrayList<Integer> listThread = new ArrayList();


    public synchronized void pushToList(Integer i) {
        this.listThread.add(i);
    }

    public synchronized boolean checkInList(Integer i) {
        for( Integer a : this.listThread ) {
            if( a.equals(i) ) {
                return true;
            }
        }

        return false;
    }
}
