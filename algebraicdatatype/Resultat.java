package algebraicdatatype;

public sealed abstract class Resultat<A,B> permits Resultat.Gauche, Resultat.Droit {
//    private Cas cas;
//    private A a;
//    private B b;
    public interface Cases<A, B> {
        public void casGauche(A gauche);
        public void casDroit(B droit);
    }

    public abstract void match(Cases<A, B> cases);

    public static final class Gauche<A, B> extends Resultat<A, B> {
        private A a;
        public Gauche(A a) {
            super();
            this.a = a;
        }

//        public A getA() {
//            return a;
//        }

        @Override
        public void match(Cases<A, B> cases) {
            cases.casGauche(a);
        }
    }

    public static final class Droit<A, B> extends Resultat<A, B> {
        private B b;
        Droit(B b) {
            super();
            this.b = b;
        }

//        public B getB() {
//            return b;
//        }

        @Override
        public void match(Cases<A, B> cases) {
            cases.casDroit(b);
        }
    }

    public Resultat() {}
//    public Resultat(Cas cas, A a, B b) {
//        this.cas = cas;
//        this.a = a;
//        this.b = b;
//    }


//    public A getA() {
//        return a;
//    }
//    public B getB() {
//        return b;
//    }
//    public Cas getCas() {
//        return cas;
//    }

    public static Resultat<Float, String> div(Float a, Float b) {
        if( b == 0 ) {
//            return new Resultat<>(Cas.Droit, null, "Impossible de diviser par 0");
            return new Resultat.Droit<>("Impossible de diviser par 0");
        }
//        return new Resultat<>(Cas.Gauche, a/b, null);
        return new Resultat.Gauche<>(a/b);
    }
}

