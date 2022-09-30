import java.util.Date;

public record PersonneR(String nom, Date dateNaissance) {
    public PersonneR {
        dateNaissance = new Date(dateNaissance.getTime());
    }

    public Date dateNaissance() {
        return new Date(dateNaissance.getTime());
    }
}
