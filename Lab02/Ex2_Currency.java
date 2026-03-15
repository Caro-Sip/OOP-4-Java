package Lab02;

public class Ex2_Currency {
    public static void main(String[] args){
        java.util.Scanner s = new java.util.Scanner(System.in);

        System.out.println("Program for converting money in Riels to Dollars.");
        System.out.print("Please input conversion rate of 1 dollar in Riels: ");
        int rielConversion = s.nextInt();

        System.out.print("Please input money to exchange in Riels: ");
        int value = s.nextInt();

        System.out.println();

        double converted = (double)value/rielConversion;

        System.out.printf("%d RIELS = %.2f USD", value, converted);

        s.close();
    }
}
