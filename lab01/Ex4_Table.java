package Lab01;

import java.util.ArrayList;

class Person{
    public Person(String country, String name, String profession, int age) {
        this.country = country;
        this.name = name;
        this.profession = profession;
        this.age = age;
    }
    String country;
    String name;
    String profession;
    int age;
}

class PeopleTable{
    ArrayList<Person> people;
    int longestCountry;
    int longestName;
    int longestProfession;
    int longestAge;

    PeopleTable(ArrayList<Person> people){
        this.people = people;

        findLongestCells();
    }

    public void printRowFrame(){
        System.out.print("+");
        for(int i = 0; i < longestCountry;i++){
            System.out.print("-");
        }
        
        System.out.print("+");
        for(int i = 0; i < longestName;i++){
            System.out.print("-");
        }

        System.out.print("+");
        for(int i = 0; i < longestProfession;i++){
            System.out.print("-");
        }

        System.out.print("+");
        for(int i = 0; i < longestAge;i++){
            System.out.print("-");
        }
        
        System.out.println("+");
    }

    public void printRowPerson(int index){
        System.out.print("|");
        System.out.printf("%-"+longestCountry+"s|",people.get(index).country);
        System.out.printf("%-"+longestName+"s|",people.get(index).name);
        System.out.printf("%-"+longestProfession+"s|",people.get(index).profession);
        System.out.printf("%-"+longestAge+"s|",people.get(index).age);
    }

    public void findLongestCells(){
        longestCountry = "Country".length();
        longestName = "Name".length();
        longestProfession = "Profession".length();
        longestAge = "Age".length();

        for(Person p : people){
            longestCountry = Math.max(longestCountry, p.country.length());
            longestName = Math.max(longestName, p.name.length());
            longestProfession = Math.max(longestProfession, p.profession.length());
            longestAge = Math.max(longestAge, String.valueOf(p.age).length());
        }

        longestCountry += 2;
        longestName += 2;
        longestProfession += 2;
        longestAge += 2;
    }
    public void printHeader(){
        System.out.print("|");
        System.out.printf("%-"+longestCountry+"s|","Country");
        System.out.printf("%-"+longestName+"s|","Name");
        System.out.printf("%-"+longestProfession+"s|","Profession");
        System.out.printf("%-"+longestAge+"s|","Age");
        System.out.println();
    }


    public void print(){
        printRowFrame();
        printHeader();
        printRowFrame();

        for(int i=0;i<people.size();i++){
            printRowPerson(i);
            System.out.println();
            
            printRowFrame();
        }
    }
}

public class Ex4_Table {
    static final int COLS = 10;
    static final int ROWS = 5;
    static final int CELL_WIDTH = 5;
    
    static void printCell(int i){
        System.out.printf("%"+CELL_WIDTH+"d|",i);
    }
    
    static void printHeader(){
        System.out.printf("%"+CELL_WIDTH+"s|","");
        for(int i = 1; i <= COLS; i++){
            printCell(i);
        }
        System.out.println();
    }
    
    static void printSeparator(){
        for(int i = 0; i < (CELL_WIDTH + 1) * (COLS + 1); i++) 
            System.out.print("-");
        System.out.println();
    }
    
    public static void main(String[] args){
        printHeader();
        printSeparator();
        
        for(int i = 1; i <= ROWS; i++){
            printCell(i);
            for(int j = 1; j <= COLS; j++){
                printCell(i*j);
            }
            System.out.println();
        }

        System.out.println();

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Cambodia","Caro","Jr. Software Dev",20));
        people.add(new Person("Germany","Franklin","Economist",52));
        people.add(new Person("Laos", "Jane", "Artist", 32));
        people.add(new Person("Philipines", "Daka", "Clay Potter", 78));

        PeopleTable peopleTable = new PeopleTable(people);

        peopleTable.print();
    }
}