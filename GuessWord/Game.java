import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        String[] words = {"happy","snow","scanner","vacation","guess","game"};
        char game=' ';

        do{
            int length = r.nextInt(words.length);
            String word = words[length];
            StringBuilder guess = new StringBuilder();
            guess.append("*".repeat(word.length()));
            int yes =0;
            int no = 0;

            while(yes<word.length()){
                System.out.println("Guess word: "+guess);
                System.out.print("Please enter first letter: ");
                char letter = input.next().charAt(0);
                if(guess.indexOf(String.valueOf(letter))>=0){
                    System.out.println("Letter "+letter+" is in the word");
                }else if(word.indexOf(letter)<0){
                    System.out.println("Letter "+ letter + " is not in the word");
                    no++;
                }else {
                    int index = word.indexOf(letter);
                    while(index >= 0 ){
                        guess.setCharAt(index, letter);
                        yes++;
                        index = word.indexOf(letter, index+1);
                    }
                }
            }
            System.out.println("correct word is : "+ word);
            System.out.println("You guess wrong "+ no + " times");
            System.out.println("Do you want to continue play (Y/N): ");
            game = input.next().charAt(0);

        }while(game == 'Y');
    }
}
