package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.*;
public class Player {
    private final Scanner inputScanner;

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */
    public String getGuess(){
        while (true) {
            System.out.print("\nInput 4 digit code:");
            String code = this.inputScanner.nextLine();
            if (code.equalsIgnoreCase("quit") || code.equalsIgnoreCase("exit")){
                return  code;
            }
            else if(code.length() != 4 || !code.matches("[1-8]*") ){
                System.out.print("\nPlease enter exactly 4 digits (each from 1 to 8).");

            }else{
                return  code;
            }


        }
    }
//    public static void main(String[] args){
//        Player play = new Player();
//        play.getGuess();
//    }
}
