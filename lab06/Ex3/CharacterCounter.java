package Ex3;

public class CharacterCounter {
    int countVowels(String text){
        int count = 0;
        String vowels = "aeiou";

        for(char c : text.toCharArray()){
            // indexOf check if the case sensitive char exist in the string
            // it returns the index of first seen else -1
            if(vowels.indexOf(Character.toLowerCase(c)) != -1){
                count++;
            }
        }

        return count;
    }

    int countConsonants(String text){
        int count = 0;
        String consonants = "bcdfghjklmnpqrstvwxyz";

        for(char c : text.toCharArray()){
            if(consonants.indexOf(Character.toLowerCase(c)) != -1){
                count++;
            }
        }

        return count;
    }

    int countSpaces(String text){
        int count = 0;
        for(char c : text.toCharArray()){
            if(c == ' '){
                count++;
            }
        }

        return count;
    }
}
