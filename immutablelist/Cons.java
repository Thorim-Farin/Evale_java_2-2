package immutablelist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class Cons<A> implements ImmutableList<A> {
    private final A head;
    private final ImmutableList<A> tail;

    public Cons(A head, ImmutableList<A> tail) {
        this.head = head;
        this.tail = tail;
    }
    public Cons(A head) {
        this.head = head;
        this.tail = new Nil<>();
    }
    public Cons(A head1, A head2) {
        this.head = head1;
        this.tail = new Cons<A>(head2);
    }
    public Cons(A head1, A head2, A head3) {
//        this(head1,new Cons(head2, head3));
        this.head = head1;
        this.tail = new Cons<A>(head2, head3);

    }

    public Cons(A head1, A head2, A head3, A head4) {
//        this(head1, new Cons(head2, head3, head4));
        this.head = head1;
        this.tail = new Cons<A>(head2, head3, head4);
    }



        @Override
    public A head() {
        return this.head;
    }

    @Override
    public ImmutableList<A> tail() {
        return this.tail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if( o instanceof Cons<?> c ) {
            return this.head.equals(c.head) && this.tail.equals(c.tail);
        }

        return false;
    }

    @Override
    public String toString() {
        if( tail == null ) {
            return "";
        }
//        if( tail.size() > 0 ) {
        if( tail instanceof Nil<?>) {
            return head.toString();
        }
        else {
            if( head == null ) {
                return "--HEAD-NULL--" + ", " + tail.toString();
            }
            return head.toString() + ", " + tail.toString();
        }
    }

    @Override
    public int hashCode() {
        return this.head.hashCode() + this.tail.hashCode();
    }


    @Override
    public int size() {
        return this.tail.size() + (head==null ? 0 : 1);
    }

    @Override
    public boolean isEmpty() {
        return this.head==null && this.tail.isEmpty();
    }


    public A get(int index) {
        if( index <= 0 ) {
            return head;
        }
        return this.tail.get(index-1);
    }

    @Override
    public int indexOf(Object o) {
        try {
            A a = (A) o;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException Cons indexOf : " + e);
            System.err.println(e);
            return -1;
        }
        if( head.equals(o) ) {
            return 0;
        }
        int indexTail = tail.indexOf(o);
        if( indexTail >= 0 ) {
            return 1 + indexTail;
        }
        else {
            return indexTail;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int indexTail = tail.lastIndexOf(o);
        if( indexTail >= 0 ) {
            return 1 + indexTail;
        }
        else {
            if( head.equals(o) ) {
                return 0;
            }
            return indexTail;
        }
    }

    @Override
    public List<A> subList(int fromIndex, int toIndex) {
        if( toIndex == 0 ) {
            return Arrays.asList(head);
        }
        if( fromIndex == 0 ) {
            return Stream.concat(Arrays.asList(head).stream(), tail.subList(0, toIndex-1).stream()).toList();
        }
        return tail.subList(fromIndex-1, toIndex-1);
    }









    @Override
    public boolean contains(Object o) {
        if( o == null ) return false;
        try {
            A a = (A) o;
            if (head.equals(a)) return true;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException Cons indexOf : " + e);
            System.err.println(e);
            return false;
        }

        return tail.contains(o);
    }


    // J'avais une erreur pendant la démo car ma classe était mal déclarée :
    //   j'avais fait un "implements ImmutableList" au lieu d'un "implements ImmutableList<A>"
    //   du coup mon IDE n'était pas capable de reconnaître les types de ma classe
    //   idem dans Nil
    @Override
    public <A,B> ImmutableList<B> map(Function<A, B> f) {
        if( tail.isEmpty() ) {
            return new Cons<B>(f.apply( (A) head), new Nil<>());
        }
        return new Cons<B>(f.apply( (A) head), tail.map(f));
    }

    // Evaluation
    {

    }

    }

}
