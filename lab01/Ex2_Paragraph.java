package lab01;

public class Ex2_Paragraph {
    static void printFormat(String special, String desc){
        System.out.printf("%-15s %s%n", special, desc);
    }
    public static void main(String[] args){
        printFormat("\\n", "Line break.");
        printFormat("\\t", "Tabulation.");
        printFormat("\\'", "Single Quote.");
        printFormat("\"", "Double Quote.");
        printFormat("\\\\", "\\ sign.");
        printFormat("\\\\\\\\", "\\\\ sign.");
        printFormat("//", "Line Comment.");
        printFormat("/*...*/", "Block Comment.");
        System.out.printf("%-15s%n","\"\"\"");
        System.out.printf("%-15s %s%n","","Text block.");
        System.out.printf("%-15s%n","\"\"\"");
    }
}
