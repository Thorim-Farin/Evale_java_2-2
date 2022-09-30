import algebraicdatatype.Resultat;
import animals.*;
import functionalInterface.cartographie.Usine;
import functionalInterface.cartographie.Ville;
import functionalInterface.cartographie.VisteurCarto;
import immutablelist.Cons;
import immutablelist.Function;
import immutablelist.ImmutableList;
import immutablelist.Nil;
import records.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//        System.out.println(s1==s2);

        /*
        System.out.println("Thread ...");
        FakeObjet fakeObjet = new FakeObjet();
        ArrayList<Thread> listDeThread = new ArrayList<>();
        for( int i=0; i<100; i++ ) {
            listDeThread.add(new Thread(new ThreadTraitement(i, fakeObjet)));
        }

        System.out.println("Lancement des threads ...");
        for( Thread t : listDeThread ) {
            t.start();
        }

//        try {
//            thread4.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("C'est fini");
         */


//        Integer fibo_final = Integer.valueOf(6);
//        System.out.println("Fibonacci de "+fibo_final + " = " + fibonacci(fibo_final));
//        fibo_final = Integer.valueOf(46);
//        System.out.println("Fibonacci de "+fibo_final + " = " + fibonacci(fibo_final));
//        Long fin = Long.valueOf(46);
//        System.out.println("Fibonacci (Long) de "+fin + " = " + fibonacci(fin));


        {
            Calendar calendar = new GregorianCalendar(2010, 11, 25);
            Date dateNaissance = calendar.getTime();
            Personne personne = new Personne("Pierre", dateNaissance);
            System.out.println("Date de naissance de " + personne.getNom() + " : " + personne.getDateNaissance());
            dateNaissance.setTime(Long.valueOf(dateNaissance.getTime() + 365 * 24 * 3600000l));
            System.out.println("Date de naissance de " + personne.getNom() + " : " + personne.getDateNaissance());

            Date dateNaissance2 = personne.getDateNaissance();
            dateNaissance2.setTime(Long.valueOf(dateNaissance.getTime() + 2 * 365 * 24 * 3600000l));
            System.out.println("Date de naissance de " + personne.getNom() + " : " + personne.getDateNaissance());
        }


        ArrayList<Integer> monArrayList = new ArrayList<>();
        for( int i=0; i < 100; i++ ) {
            monArrayList.add(Integer.valueOf(new Random().nextInt(0, 10)));
        }
//        System.out.println(monArrayList.toString());
//        List<Integer> listImmutable = Collections.unmodifiableList(monArrayList);
//        System.out.println("listImmutable : " +listImmutable);
//        listImmutable.add(Integer.valueOf(99));
//        System.out.println("listImmutable : " +listImmutable);
//        System.out.println(monArrayList);

//        monArrayList.sort( (a,b) -> a<b ? -1 : (a==b ? 0 : 1) );

//        System.out.println(monArrayList);


//        Optional<String> str = Optional.ofNullable("imerir");
        Optional<String> str = Optional.ofNullable(null);
        System.out.println("is present ? " + str.isPresent());
        System.out.println(str.orElse("Aucune String fournie"));
        str.ifPresent(System.out::println);


//        OperationSimple os = i -> i*2;
//        OperationSimple osx5 = i -> i*5;
//        System.out.println(os.calculer(10));
//        System.out.println(osx5.calculer(10));
//        Operation os2 = new Operation();
//        System.out.println(os2.calculer(10));

        {
            Command cmd = new Command("imerir", Integer.valueOf(5));
            System.out.println(cmd.get_debug());
            System.out.println(" action : " + cmd.action());
//        cmd.action() = 99;    // --> Impossible de modifier action car le record est immutable

            Command cmd2 = new Command("imerir", Integer.valueOf(5));
            System.out.println(cmd.equals(cmd2));
        }


        {
            Calendar calendar = new GregorianCalendar(2010, 11, 25);
            Date dateNaissance = calendar.getTime();
            PersonneR perso = new PersonneR("Paul", dateNaissance);
            System.out.println(perso.nom() + " est né le " + perso.dateNaissance());
            dateNaissance.setTime(Long.valueOf(dateNaissance.getTime() + 365 * 24 * 3600000l));
            System.out.println(perso.nom() + " est né le " + perso.dateNaissance());

            Date dateNaissance2 = perso.dateNaissance();
            dateNaissance2.setTime(Long.valueOf(dateNaissance.getTime() + 2 * 365 * 24 * 3600000l));
            System.out.println(perso.nom() + " est né le " + perso.dateNaissance());

        }



        {
            List<Integer> numbers = Arrays.asList(3, 6, 5, 4, 9, 8, 10, 2, 4);
            System.out.println(numbers.stream().toList().toString());
//            System.out.println(numbers.stream().sorted().toList().toString());
//            System.out.println(numbers.stream().toList().toString());
//            System.out.println(numbers.stream().distinct().sorted().toList().toString());

            System.out.println(numbers.stream().map( a -> 2*a ).toList().toString());
            System.out.println( numbers.stream().filter(a -> a%2==0).toList().toString());
            System.out.println( numbers.stream().reduce(0, (a,b) -> a+b).toString() );

            // Afficher le Max de numbers :
            System.out.println( "Max : " + numbers.stream().reduce(0, (a,b) -> a>b ? a : b).toString() );
            System.out.println( "Min : " + numbers.stream().reduce(numbers.get(0), (a,b) -> a<b ? a : b).toString() );

            System.out.println( "Max : " + numbers.stream().reduce(Integer::max).orElse(Integer.valueOf(-9)) );


//            System.out.println(Stream.concat(numbers.stream(),
//                    Arrays.asList(13, 16).stream()).toList().toString()  );
//
//            List<Long> retourFibo = fibonacciFunctionnal(Long.valueOf(46));
//            System.out.println("fibo : " + retourFibo.get( retourFibo.size() - 1));
        }


/*
        {
//            ExecutorService pool = Executors.newFixedThreadPool((3));
//            for(int i=0; i<10; i++) {
//                pool.submit(new Thread(new ThreadTraitement(i)));
//            }
//            pool.shutdown();
//            System.out.println("Fini du pool Thread");


//            new Thread(() -> {
//                for(int i=0; i<3; i++) {
//                    System.out.println("<<<< Lambda : "+i);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }).start();


            Callable<String> myCall = () -> {
                for(int i=0; i<3; i++) {
                    System.out.println("<<<< myCall : "+i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                return new String("myCall fini");
            };

            ExecutorService exec = Executors.newSingleThreadExecutor();
            Future<String> retourMyCall = exec.submit(myCall);
            System.out.println("myCall submited");
            try {
                System.out.println("retour de myCall : " + retourMyCall.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Shutdown executor ...");
            exec.shutdown();
        }


 */


        {
            Homme homme = new Homme();
            homme.nom = "Pierre";
            homme.manger();

            Lion lion = new Lion();
            lion.nom = "lion";
            lion.manger();

            Hyene hyene = new Hyene();
            hyene.nom = "hyène";
            hyene.manger();

            AnalyseStats visiteur = new AnalyseStats();
            homme.accept(visiteur);
            lion.accept(visiteur);
            hyene.accept(visiteur);
            System.out.println(" stat visiteur : " +visiteur);
        }

        {
            Ville v = new Ville("Perpignan");
            Usine u1 = new Usine("C'est moi");
            Usine u2 = new Usine("Imerir");

            VisteurCarto visiteur = new VisteurCarto();
            System.out.println(v.accept(visiteur));
            System.out.println(u1.accept(visiteur));
            System.out.println(u2.accept(visiteur));

        }



        {
//            Resultat<Float, String> resultat = Resultat.div(10f, 0f);
//            switch ( resultat.getCas() ) {
//                case Gauche -> System.out.println("Droit : "+resultat.getB());
//                case Droit -> System.out.println("Gauche : " + resultat.getA());
//            }
//            switch ( resultat.getCas() ) {
//                case Gauche:
//                    System.out.println("Droit : "+resultat.getB());
//                    break;
//                case Droit:
//                    System.out.println("Gauche : " + resultat.getA());
//                break;
//            }

//            switch (resultat) {
//                case Resultat.Droit resD -> System.out.println(resD.getB());
//                case Resultat.Gauche resG -> System.out.println(resG.getA());
//                default -> System.out.println("Y A UN PROBLEME");
//            }

//            if( resultat instanceof Resultat.Gauche ) {
//                Resultat.Droit<Float, String> resG = (Resultat.Droit<Float, String>) resultat;
//                System.out.println("Resultat : " + resG.getB());
//            }
//            else {
//                Resultat.Gauche<Float, String> resD = (Resultat.Gauche<Float, String>) resultat;
//                System.out.println("Erreur : " + resD.getA());
//            }

            Resultat<Float, String> resultat = Resultat.div(10f, 0f);
            resultat.match(new Resultat.Cases<Float, String>() {
                @Override
                public void casGauche(Float gauche) {
                    System.out.println(" La réponse est : "+gauche);
                }

                @Override
                public void casDroit(String droit) {
                    System.out.println(" Il y a une erreur : "+droit);
                }
            });
        }





        {
            /**
             * ImmutableList
             */

            ImmutableList<Integer> maliste = new Cons(4, new Cons(9, new Cons(39, new Nil())));
            System.out.println(maliste);

            ImmutableList<Integer> maliste2 = new Cons(4, new Cons(9, new Cons(39, new Nil())));
            System.out.println(maliste.hashCode());
            System.out.println(maliste2.hashCode());
            System.out.println(maliste2.equals(maliste));
            System.out.println(maliste2.toString());
            maliste.size();

            System.out.println("rev : "+ImmutableList.rev(maliste));


            System.out.println("Optional : " + ImmutableList.find(maliste, 12).orElse(Integer.valueOf(-99)));
            Optional<Integer> opt = ImmutableList.find(maliste, 9);
            opt.ifPresent(System.out::println);

            System.out.println("MAP de maliste : "+maliste);
            Function<Integer, Integer> x2 = i -> i*2;
            System.out.println(maliste.map(x2));
            Function<Integer, Float> div2 = i -> i/2f;
            System.out.println(maliste.map(div2));
        }


        calculMoyenneQCM("src/notesqcm1.csv");
    }




    public static void calculMoyenneQCM(String filename) {
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filename));
            long nbLigne = lines.count();

            // On récupère de nouveau notre Stream car il ne peut pas être utilisé 2 fois d'affilé
            lines = Files.lines(Paths.get(filename));

            List<Float> values =
                    lines
                            .skip(1)    // on ignore la première ligne
                            .limit(nbLigne-2)   // On ignore la dernière ligne
                            // On applique Filter pour éléminer les lignes sans notes (donc avec un "-" à la place d'une note)
                            .filter((line) -> !line.replaceAll("\"([0-9]+),([0-9]+)\"", "$1.$2").split(",")[7].equals("-"))
                            // On utilise Map pour convertir la 7 ème colonne (la note) en Float
                            .map((line) -> Float.parseFloat(line.replaceAll("\"([0-9]+),([0-9]+)\"", "$1.$2").split(",")[7]))
                            //      dans les 2 méthodes précédentes on utilise une regex dans replaceAll pour convertir les notes ( actuellement au format "10,50" ) vers le format : 10.50 afin d'éliminer les guillemets et de remplacer la , par un .
                            //      on fait également un split(",") pour découper la ligne en colonne ( séparées par des "," )

                            // Enfin, on converti en List :
                            .toList();

            Float moyenne = values.stream().reduce(0f, (a,b) -> a+b) / values.size();
            values.forEach((l)->System.out.println(l));
            System.out.println("Moyenne : "+moyenne);
            System.out.println("Moyenne : "+new DecimalFormat("###.##").format(moyenne));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }


        static List<Long> fibonacciFunctionnal(Long n) {
        if( n <= 1 ) {
            return Arrays.asList(Long.valueOf(1));
        }
        List<Long> retFiboFunctionnal_n1 = fibonacciFunctionnal(n-1);
        Long last;
        Long avlast;
        if( retFiboFunctionnal_n1.size() <= 1 ) {
            last = Long.valueOf(1);
            avlast = Long.valueOf(1);
        }
        else {
            last = retFiboFunctionnal_n1.get( retFiboFunctionnal_n1.size() - 1 );
            avlast = retFiboFunctionnal_n1.get( retFiboFunctionnal_n1.size() - 2 );
        }
        return Stream.concat(
                retFiboFunctionnal_n1.stream(),
                Arrays.asList(last + avlast).stream()
        ).toList();

    }

    static Integer fibonacci(Integer index) {
        if( index <= 1  ) {
            return 1;
        }
        return fibonacci(index-1) + fibonacci(index-2);
    }

    static Long fibonacci(Long index) {
        if( index <= 1  ) {
            return Long.valueOf(1);
        }
        return fibonacci(index-1) + fibonacci(index-2);
    }
}