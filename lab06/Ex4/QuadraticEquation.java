package Ex4;

public class QuadraticEquation {
    
    public double[] solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            // Linear equation: bx + c = 0
            if (b == 0) {
                return null; // No solution
            }
            return new double[] { -c / b };
        }
        
        // Calculate discriminant
        double discriminant = (b * b) - (4 * a * c);
        
        if (discriminant < 0) {
            return null; // No real roots
        } else if (discriminant == 0) {
            // One root
            double root = -b / (2 * a);
            return new double[] { root };
        } else {
            // Two roots
            double sqrtDiscriminant = java.lang.Math.sqrt(discriminant);
            double x1 = (-b + sqrtDiscriminant) / (2 * a);
            double x2 = (-b - sqrtDiscriminant) / (2 * a);
            return new double[] { x1, x2 };
        }
    }
}