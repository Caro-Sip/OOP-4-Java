package Lab01;

public class Ex5_String {
    static boolean isVowel(char ch) {
        // checking if the char is part of the vowel list
        return "aeiouAEIOU".contains(String.valueOf(ch));
    }

    static void printVowels(String textString) {
        for (int i = 0; i < textString.length(); i++){
            char ch = textString.charAt(i);
            if(isVowel(ch)) System.out.println("String[" + (i+1) + "]: " + textString.charAt(i) + " is a vowel");
        }
    }
    public static void main(String[] args) {
        String text = "I love my home country.";

        System.out.print(text.length());

        text = "I love my little country."; 

        System.out.println();

        System.out.print(text.substring(7));

        System.out.println();

        text = "Hi students";
        printVowels(text);

        System.out.println();

        String text1 = "Hi Students";
        String text2 = "Students";
        String text3 = "Hi Students";

        System.out.println("Text1 == Text2: " + (text1 == text2));
        System.out.println("Text1 == Text3: " + (text1 == text3));
    }
}
