package za.co.wethinkcode.mastermind;
import  java.util.regex.*;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public int[] checkNumber(String numbers, String guessed ,int count){
        count --;
        int right = 0;
        int wrong = 0;
        for(int i = 0 ; i<4;i++){
            if(String.valueOf(numbers.charAt(i)).equals(String.valueOf(guessed.charAt(i)))){
                right+=1;
            } else if (numbers.charAt(i) != guessed.charAt(i) && numbers.contains(String.valueOf(guessed.charAt(i)))) {
                wrong+=1;
            }
        }return new int[] {right,wrong,count};
    }

    public void runGame(){
        //TODO: implement the main run loop logic
        String secret_code = this.code;
        String guess ;
        System.out.print("\n4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.");
        int counting = 12;

        while(true){
            guess = this.player.getGuess();
            int[] values =checkNumber(secret_code,guess,counting);
            System.out.print("\nNumber of correct digits in correct place: "+values[0]);
            System.out.print("\nNumber of correct digits not in correct place: "+values[1]);

            counting = values[2];
            if (guess.matches(secret_code)){
                System.out.print("\nCongratulations! You are a codebreaker!");
                System.out.print("\nThe code was: "+secret_code);
                break;
                }
            else if(counting == 0){
                System.out.print("\nNo more turns left.");
                System.out.print("\nThe code was: "+secret_code);
                break;

            }else{
                System.out.print("\nTurns left: "+values[2]);
            }
        }

    }


    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
