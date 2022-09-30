package functionalInterface;

public class Operation implements OperationSimple {
    @Override
    public int calculer(int i) {
        return 2*i;
    }
}
