package exercise6;

public class User {
    private static final String DELIM = "\t";

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String password;

    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toStorageString() {
        return String.join(DELIM, firstName, lastName, username, email, password);
    }

    public static User fromStorageString(String line) {
        String[] parts = line.split("\\t", -1);
        if (parts.length < 5) {
            return null;
        }
        return new User(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
