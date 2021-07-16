package NoteProblem;

import java.util.HashMap;

public class Note {
    //Used hashmap for storing the letters from the magazine
    //and how many times they occur
    private HashMap<Character, Integer> dictionary = new HashMap<>();

    //Method that puts the letters in the dictionary
    private void makeDictionary(String letters) {
        for(int i = 0; i < letters.length(); i++) {
            Character currLetter = letters.charAt(i);

            //First we say that the letter occurs for a first time
            int count = 1;
            //Then we check if is it really for a first time
            if(dictionary.containsKey(currLetter)) {
                count = dictionary.get(currLetter) + 1;
            }

            dictionary.put(currLetter, count);
        }
    }

    //It creates new directory after finishing with this one
    //so if the user need to check not only one possibility
    private void clearDirectory() {
        this.dictionary = new HashMap<>();
    }

    public boolean isPossible(String wantedNoteLetters, String magazineLetters) {
        //Adding the letters from the magazine
        makeDictionary(magazineLetters);

        for(int i = 0; i < wantedNoteLetters.length(); i++) {
            Character currLetter = wantedNoteLetters.charAt(i);
            if (!dictionary.containsKey(currLetter)) {
                clearDirectory();
                return false;
            }

            Integer letterCount = dictionary.get(currLetter);
            if(letterCount == 0) {
                clearDirectory();
                return false;
            }

            //We used a letter so we have to take out one from the
            //times that letter has occurred
            dictionary.put(currLetter, letterCount - 1);
        }

        clearDirectory();
        //If we reached here then there aren't any problems for
        //writing the node and we return that is possible
        return true;
    }
}
