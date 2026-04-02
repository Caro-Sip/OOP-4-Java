package lab04.exercise8;

public class Ex8 {
    public static void main(String[] args) {
        BasicMath bm = new BasicMath();
        System.out.println(bm.addition(6, 9));
        System.out.println(bm.subtract(6, 9));

        AdvancedMath am = new AdvancedMath();
        System.out.println(am.addition(6, 9));
        System.out.println(am.subtract(6, 9));
        System.out.println(am.multiply(6, 9));
        System.out.println(am.divide(6, 9));
    }
}
