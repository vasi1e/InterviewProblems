package NoteProblem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initialize a scanner for reading from the console
        Scanner scanner = new Scanner(System.in);
        //Initialize a Note
        Note note = new Note();

        System.out.println("A thief wants to know if he can write a note using letters from magazine");

        System.out.print("Write the wanted letters for the note: ");
        String wantedLetters = scanner.next();

        System.out.print("Write the letters from the magazine: ");
        String magazineLetters = scanner.next();

        //Call the method for checking
        if(note.isPossible(wantedLetters, "")) {
            System.out.println("Yes, he can!");
        } else {
            System.out.println("No, he can't!");
        }
    }
}
