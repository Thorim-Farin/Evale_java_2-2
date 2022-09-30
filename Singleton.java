public class Singleton {
    private int id;
    private static Singleton instance;

    private Singleton() {

    }

    public int getId() {
        return id;
    }

    public static Singleton getInstance() {
        if( instance == null ) {
            instance = new Singleton();
        }
        return instance;
    }
}
