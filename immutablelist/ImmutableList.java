package immutablelist;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public sealed interface ImmutableList<A> permits Nil, Cons {
    public A head();
    public ImmutableList<A> tail();

    public int size();
    public boolean isEmpty();
    public A get(int index);
    public int indexOf(Object o);
    public int lastIndexOf(Object o);
    public List<A> subList(int fromIndex, int toIndex);
    boolean contains(Object a);

    static <A> Integer length(ImmutableList<A> list) {
        if( list.isEmpty() ) {
            return Integer.valueOf(0);
        }
        return 1 + length(list.tail());
    }

    static <A> ImmutableList<A> concat(ImmutableList<A> l1, ImmutableList<A> l2) {
        if( l1.isEmpty() ) {
            return l2;
        }

        return new Cons<A>(l1.head(), ImmutableList.concat(l1.tail(), l2));
    }


    static <A> ImmutableList<A> rev(ImmutableList<A> list) {
         if(list.isEmpty() ) {
             return new Nil<>();
         }

//         return new Cons(list.head(), rev(list.tail()));
//        return new Cons(list.tail(), rev(list.tail()));
//        return new Cons<A>(rev(list.tail()), list.head());
        return concat(rev(list.tail()), new Cons(list.head()));
    }

    static <A>Optional<A> find( ImmutableList<A> l , A a) {
        if( l.isEmpty() ) {
            return Optional.empty();
        }
        if( l.head().equals(a) ) {
            return Optional.of(a);
        }

        return find(l.tail(), a);
    }

    // Evaluation
    {
        static <A> Integer length_visitor(ImmutableList<A> l) {
            VisitorClasse visiteur = l.accept(new VisitorClasse());
            return visiteur.length_visitor();
    }
    }

    public abstract <A,B> ImmutableList<B> map(Function<A, B> f);

}
