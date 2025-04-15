import java.util.Scanner;
import java.util.Random;
public class SimonSays {
    
    /**This checks whether the input from the user matches the answer by checking input against check and returning true or false depending on if they got it right or wrong
     * @param check this is the answer in a format without spaces
     * @param input this is the input of the user, which is checked against check to see if its correct
     * @return true or false depending on if check is the same as input
     */
    public static boolean checkAns(String check,String input){
        String ans = input.replaceAll("\s", "");
        if(check.equalsIgnoreCase(ans)){
            return true;
        }else{
            return false;
        }   
    }
    
    /**This creates the sequence that the player has to copy
     * @param score the score that the player has, is used to tell how long the next sequence is
     * @param hard this is the boolean that checks whether the game is in hard mode or not
     * @return things which is the sequence in string form
     */
    public static String getAns(int score, boolean hard){
        Random rand = new Random();
        String things = "";
        if(hard == false){
            for(int i = 0; i < score; i++){
                int number = rand.nextInt(4);
                if(number == 0){
                    things = things + "green ";
                }else if (number == 1){
                    things = things + "red ";
                }else if (number == 2){
                    things = things + "yellow ";
                }else{
                    things = things + "blue ";
                }
            }
        }else{
            for(int i = 0; i < score; i++){
                things = things + rand.nextInt(10) + " ";  
            }
        }
        return things;
    }
    
    /** this is the provided clear screen method*/
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        }
    
        public static void main(String[] args) throws Exception {
        boolean gameStatus = true;
        boolean wantPlay = true;
        Scanner input = new Scanner(System.in);
        int score;
        boolean hard;
        boolean wantG = false;
        while(wantPlay == true){
            System.out.println("Let's play Simon Says!");
            System.out.print("Select difficulty(easy / hard)");
            score = 0;
            gameStatus = true;
            String diffi = input.next();
            if(diffi.equalsIgnoreCase("easy")){
                System.out.println("Easy mode - colors");
                hard = false;
                while(gameStatus == true){
                    String ans = "";
                    String check = "";
                    String printOut = "";
                    score++;
                    printOut = getAns(score, hard);
                    check = printOut.replaceAll("\s", "");
                    System.out.println("Simon says: " + printOut);
                    try {
                        Thread.sleep(3000);
                        } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        }
                    clearScreen();
                    System.out.print("Player repeats: ");
                    ans = input.nextLine();
                    if (ans.equals("")){
                        ans = input.nextLine();
                    }
                    gameStatus = checkAns(check, ans);
                    if (gameStatus == true){
                        System.out.println("Score:" + score);
                    }
                }
                System.out.println("Round over! Your score was " + (score-1) + "! :3");
                while(wantG == false){
                    System.out.print("would you like to play another round?");
                    String ans;
                    ans = input.next();
                    if(ans.equalsIgnoreCase("yes")){
                        wantPlay = true;
                        wantG = true;
                    }else if (ans.equalsIgnoreCase("no")){
                        wantPlay = false;
                        wantG = true;
                    }else{
                        System.out.println("Invalid input");
                    }
                }
                wantG = false;
            }else if(diffi.equalsIgnoreCase("hard")){
                System.out.println("Hard mode - numbers");
                hard = true;
                while(gameStatus == true){
                    while(gameStatus == true){
                        String ans;
                        String check = "";
                        String printOut = "";
                        score ++;
                        printOut = getAns(score, hard);
                        check = printOut.replaceAll("\s", "");
                        System.out.println("Simon says: " + printOut);
                        try {
                            Thread.sleep(3000);
                            } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            }
                        clearScreen();
                        System.out.print("Player repeats:");
                        ans = input.nextLine();
                        if (ans.equals("")){
                            ans = input.nextLine();
                        }
                        gameStatus = checkAns(check, ans);
                        if (gameStatus == true){
                            System.out.println("Score:" + score);
                        }
                    }
                    System.out.println("Round over! Your score was " + (score-1) + "! :3");
                    while(wantG == false){
                        System.out.print("would you like to play another round?");
                        String ans;
                        ans = input.next();
                        if(ans.equalsIgnoreCase("yes")){
                            wantPlay = true;
                            wantG = true;
                        }else if (ans.equalsIgnoreCase("no")){
                            wantPlay = false;
                            wantG = true;
                        }else{
                            System.out.println("Invalid input");
                        }
                    }
                    wantG = false;
                }
            }else{
                System.out.println("Invalid difficulty");
            }
        }
        input.close();
        System.exit(0);
    }
}
