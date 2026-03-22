package lab02;

import java.util.Scanner;

public class Ex7_CharacterCounter {
    static boolean isVowel(char ch) {
        // checking if the char is part of the vowel list
        return "AEIOU".contains(String.valueOf(ch).toUpperCase());
    }

    static int countVowels(String textString) {
        int counter = 0;
        for (int i = 0; i < textString.length(); i++){
            char ch = textString.charAt(i);
            if(isVowel(ch)) counter++;
        }
        return counter;
    }

    static boolean isConsonant(char ch) {
        int ascii = (int) Character.toUpperCase(ch);
        for (int i = 65; i <= 90; i++){
            if (ascii == i) return true;
        }
        return false;
    }

    static int countConsonants(String textString) {
        int counter = 0;
        for (int i = 0; i < textString.length(); i++){
            char ch = textString.charAt(i);
            if(isConsonant(ch)) counter++;
        }
        return counter;
    }

    static int countSpaces(String textString) {
        int counter = 0;
        for (int i = 0; i < textString.length(); i++){
            char ch = textString.charAt(i);
            if (ch == ' ') counter++;
        }
        return counter;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Input a sentence: ");
        String sentence = s.nextLine();

        System.out.println("Count of vowel is: " + countVowels(sentence));
        System.out.println("Count of consonant is: " + countConsonants(sentence));
        System.out.println("Count of space is: " + countSpaces(sentence));

        s.close();
    }
}
