package Ex5;


class MathUtils {
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return a / b;
    }
    
    public static double min(double a, double b) {
        return a < b ? a : b;
    }
    
    public static double max(double a, double b) {
        return a > b ? a : b;
    }
}

public class Ex5_StaticMath {
    public static void main(String[] args) {
        double a = 5;
        double b = 7;
        
        System.out.println("A = " + a + ", B = " + b);
        System.out.println();
        System.out.println("Add: " + MathUtils.add(a, b));
        System.out.println("Subtract: " + MathUtils.subtract(a, b));
        System.out.println("Multiply: " + MathUtils.multiply(a, b));
        System.out.println("Divide: " + MathUtils.divide(a, b));
        System.out.println("Min: " + MathUtils.min(a, b));
        System.out.println("Max: " + MathUtils.max(a, b));
    }
}
