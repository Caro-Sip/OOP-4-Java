package Ex6;


class MathUtilsAdvanced {
    
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial of negative number!");
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static double rectangleSurface(double width, double height) {
        return width * height;
    }
    
    public static double circleSurface(double radius) {
        return Math.PI * radius * radius;
    }
    
    public static double max(double a, double b, double c, double d, double e) {
        double max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        if (e > max) max = e;
        return max;
    }
    
    public static double min(double a, double b, double c, double d, double e) {
        double min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        if (e < min) min = e;
        return min;
    }
}

public class Ex6_StaticMath2 {
    public static void main(String[] args) {
        // factorial
        System.out.println("=== Factorial ===");
        System.out.println("Factorial of 5: " + MathUtilsAdvanced.factorial(5));
        System.out.println("Factorial of 0: " + MathUtilsAdvanced.factorial(0));
        
        // rectangle surface
        System.out.println("\n=== Rectangle Surface ===");
        System.out.println("Width: 5, Height: 3");
        System.out.println("Surface: " + MathUtilsAdvanced.rectangleSurface(5, 3));
        
        // circle surface
        System.out.println("\n=== Circle Surface ===");
        System.out.println("Radius: 4");
        System.out.println("Surface: " + MathUtilsAdvanced.circleSurface(4));
        
        // max and min 
        System.out.println("\n=== Max and Min (5 parameters) ===");
        double a = 10, b = 45, c = 23, d = 67, e = 12;
        System.out.println("Values: " + a + ", " + b + ", " + c + ", " + d + ", " + e);
        System.out.println("Max: " + MathUtilsAdvanced.max(a, b, c, d, e));
        System.out.println("Min: " + MathUtilsAdvanced.min(a, b, c, d, e));
    }
}
