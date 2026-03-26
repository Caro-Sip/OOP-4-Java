class Department {
    String name;
    
    public Department() {}
    
    public Department(String name) {
        this.name = name;
    }
}

class Student {
    String id;
    String name;
    int age;
    Department department;
    
    public Student() {}
    
    public Student(String id, String name, int age, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    
    public void setValues(String id, String name, int age, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    
    public void display() {
        System.out.printf("ID: %s Name: %s Age: %d Dept: %s%n", 
            id, name, age, department.name);
    }
}

public class Ex8a_StudentDepartment {
    public static void main(String[] args) {
        Department dept1 = new Department("Computer Science");
        Department dept2 = new Department("Economi");
        
        Student stu1 = new Student();
        stu1.setValues("111", "Tola", 18, dept1);
        
        Student stu2 = new Student();
        stu2.setValues("222", "Makara", 17, dept2);
        
        Student stu3 = new Student();
        stu3.setValues("333", "Kompheak", 23, dept1);
        
        Student[] stuArr = new Student[3];
        stuArr[0] = stu1;
        stuArr[1] = stu2;
        stuArr[2] = stu3;
        
        System.out.println("\n=== Student List ===");
        for (Student stu : stuArr) {
            stu.display();
        }
    }
}
