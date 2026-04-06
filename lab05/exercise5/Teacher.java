package exercise5;

public class Teacher {
    private static final String DELIM = "\t";

    private final String firstName;
    private final String lastName;
    private final String sex;
    private final String email;
    private final String subjects;
    private final double salary;

    public Teacher(String firstName, String lastName, String sex, String email, String subjects, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.subjects = subjects;
        this.salary = salary;
    }

    public String toStorageString() {
        return String.join(DELIM,
                firstName,
                lastName,
                sex,
                email,
                subjects,
                Double.toString(salary));
    }

    public String toDisplayString() {
        return String.format("[%s %s][%s][%s][%s][%s]",
                firstName, lastName, sex, email, subjects, formatSalary());
    }

    public static Teacher fromStorageString(String line) {
        String[] parts = line.split("\\t", -1);
        if (parts.length < 6) {
            return null;
        }
        double parsedSalary;
        try {
            parsedSalary = Double.parseDouble(parts[5]);
        } catch (NumberFormatException e) {
            parsedSalary = 0.0;
        }
        return new Teacher(parts[0], parts[1], parts[2], parts[3], parts[4], parsedSalary);
    }

    private String formatSalary() {
        if (salary == Math.rint(salary)) {
            return String.format("%.0f$", salary);
        }
        return String.format("%.2f$", salary);
    }
}
