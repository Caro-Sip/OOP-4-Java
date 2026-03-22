package lab01;

public class Ex6_ClassesObjects {
    public static void main(String[] args){
        Employee employee1 = new Employee(2103905,"Caro",20,"Jr. Developer",750);
        Employee employee2 = new Employee(1203965,"June",49,"Sr. Developer",1200);
        System.out.println(employee1 + "\n" + employee2);
        
        Car car1 = new Car("Toyota", "Camry", 1001, "Blue", 2022);
        Car car2 = new Car("Honda", "Civic", 1002, "Red", 2023);
        System.out.println(car1 + "\n" + car2);
        
        BankAccount account1 = new BankAccount(5001, "Savings", "John Doe", 5000.50, 3.5);
        BankAccount account2 = new BankAccount(5002, "Checking", "Jane Smith", 15000.75, 2.0);
        System.out.println(account1 + "\n" + account2);
        
        Video video1 = new Video("Summer Vacation", 2023, 7, 15, "mp4");
        Video video2 = new Video("Birthday Party", 2023, 5, 20, "avi");
        System.out.println(video1 + "\n" + video2);
    }
}

class Employee{
    int employeeID;
    String name;
    int age;
    String position;
    double salary;

    public Employee(int employeeID, String name, int age, String position, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [employeeID=" + employeeID + ", name=" + name + ", age=" + age + ", position=" + position
                + ", salary=" + salary + "]";
    }
}

class Car{
    String brand;
    String name;
    int id;
    String color;
    int year;

    public Car(String brand, String name, int id, String color, int year) {
        this.brand = brand;
        this.name = name;
        this.id = id;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", name=" + name + ", id=" + id + ", color=" + color + ", year=" + year + "]";
    }
}

class BankAccount{
    int accountID;
    String accountName;
    String ownerName;
    double balance;
    double perAnnum;
    
    public BankAccount(int accountID, String accountName, String ownerName, double balance, double perAnnum) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.ownerName = ownerName;
        this.balance = balance;
        this.perAnnum = perAnnum;
    }

    @Override
    public String toString() {
        return "BankAccount [accountID=" + accountID + ", accountName=" + accountName + ", ownerName=" + ownerName + ", balance=" + balance + ", perAnnum=" + perAnnum + "]";
    }
}

class Video{
    String name;
    int year;
    int month;
    int day;
    String fileType;
    
    public Video(String name, int year, int month, int day, String fileType) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Video [name=" + name + ", year=" + year + ", month=" + month + ", day=" + day + ", fileType=" + fileType + "]";
    }
}