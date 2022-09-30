package immutablelist;

import java.util.List;

public final class Nil<A> implements ImmutableList<A> {
        @Override
    public A head() {
        return null;
    }

    @Override
    public ImmutableList<A> tail() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof Nil<?>) return true;

        return false;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int size() {
        return 0;
    }
    public boolean isEmpty() {
        return true;
    }

    public A get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return -1;
    }

    @Override
    public List<A> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        if( o == null ) return true;
        return false;
    }


    // J'avais une erreur pendant la démo car ma classe était mal déclarée :
    //   j'avais fait un "implements ImmutableList" au lieu d'un "implements ImmutableList<A>"
    //   du coup mon IDE n'était pas capable de reconnaître les types de ma classe
    @Override
    public <A,B> ImmutableList<B> map(Function<A, B> f) {
        return null;
    }
}
