package Lab02;

import java.util.Scanner;

public class Ex5_CharacterCounter {
    static boolean isVowel(char ch) {
        // checking if the char is part of the vowel list
        return "aeiou".contains(String.valueOf(ch).toLowerCase());
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
        return "bcdfghjklmnpqrstvwxyz".contains(String.valueOf(ch).toLowerCase());
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
