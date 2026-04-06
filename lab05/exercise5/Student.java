package exercise5;

public class Student {
    private static final String DELIM = "\t";

    private final String firstName;
    private final String lastName;
    private final String sex;
    private final String email;
    private final int year;
    private final String major;

    public Student(String firstName, String lastName, String sex, String email, int year, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.year = year;
        this.major = major;
    }

    public String toStorageString() {
        return String.join(DELIM,
                firstName,
                lastName,
                sex,
                email,
                Integer.toString(year),
                major);
    }

    public String toDisplayString() {
        return String.format("[%s %s][%s][%s][%d][%s]",
                firstName, lastName, sex, email, year, major);
    }

    public static Student fromStorageString(String line) {
        String[] parts = line.split("\\t", -1);
        if (parts.length < 6) {
            return null;
        }
        int parsedYear;
        try {
            parsedYear = Integer.parseInt(parts[4]);
        } catch (NumberFormatException e) {
            parsedYear = 0;
        }
        return new Student(parts[0], parts[1], parts[2], parts[3], parsedYear, parts[5]);
    }
}
