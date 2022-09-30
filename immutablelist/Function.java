package immutablelist;

@FunctionalInterface
public interface Function<A, B> {
    public abstract B apply(A a);
}
