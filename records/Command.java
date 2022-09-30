package records;

public record Command(String action, Integer step) {
    public String get_debug() {
        return new String(action + " --> " +step.toString());
    }
}
