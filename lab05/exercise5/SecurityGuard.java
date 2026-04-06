package exercise5;

public class SecurityGuard {
    private static final String DELIM = "\t";

    private final String firstName;
    private final String lastName;
    private final String sex;
    private final String email;
    private final String role;

    public SecurityGuard(String firstName, String lastName, String sex, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.role = role;
    }

    public String toStorageString() {
        return String.join(DELIM,
                firstName,
                lastName,
                sex,
                email,
                role);
    }

    public String toDisplayString() {
        return String.format("[%s %s][%s][%s][%s]",
                firstName, lastName, sex, email, role);
    }

    public static SecurityGuard fromStorageString(String line) {
        String[] parts = line.split("\\t", -1);
        if (parts.length < 5) {
            return null;
        }
        return new SecurityGuard(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
