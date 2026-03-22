package lab01;

public class Ex3_Asterisks {
    static void printChars(char ch, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
    }

    static void printPyramid(int numStars){
        for (int i = numStars, spaces = 0; i > 0; i -= 2, spaces++) {
            printChars(' ', spaces);
            printChars('*', i);
            System.out.println();
        }
    }

    static void printBox(int height, int width){
        printChars('*', width);
        for(int j = 0; j < height; j++){
            System.out.println();
            System.out.print("*");
            for (int i = 0; i < width - 2; i++) System.out.print(" ");
            System.out.print("*");
        }
        System.out.println();
        printChars('*', width);
        System.out.println();
    }

    static void printNum() {
        for (int j = 1; j <= 5;j++){
            for(int i = j; i <= j+4; i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numStars = 15;
        printPyramid(numStars);

        System.out.println();

        int height = 3;
        int width = 15;
        printBox(height, width);

        System.out.println();

        printNum();
    }
}