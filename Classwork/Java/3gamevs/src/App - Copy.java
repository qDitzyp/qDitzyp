import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.*;

public class App {

    /**
     * This is what picks the word randomly from the list of given words and checks to make sure the word is 7 unique letters
     * 
     * @param words the full list of valid words
     * @param chosenWord the string variable that holds the randomly chosen word
     * @return it returns the word chosen at random
     */
    public static String wordPicker(ArrayList<String>words, String chosenWord ){
        boolean wordCheck = true;              
        Random rand = new Random();
        chosenWord = words.get(rand.nextInt(words.size()));
        while(chosenWord.length() < 7 || chosenWord.length() > 7 || wordCheck == false){
            wordCheck = true;          
            chosenWord = words.get(rand.nextInt(words.size()));
            ArrayList <Character> wordFix= new ArrayList<Character>();            
            for(int i = 0; i< chosenWord.length(); i++){
                wordFix.add(chosenWord.charAt(i));
            }
            for(int i = 0; i < wordFix.size(); i++){
                for(int d = 0; d < wordFix.size(); d++){
                    if(wordFix.get(d) == wordFix.get(i) && d != i){
                            wordCheck = false;
                    }                
                }                
            }        
        }
        return chosenWord; 
    }
    
    /**
     * this is what shuffles the letters within the ArrayList wordLetters, this is in a method of its own because originally it also held the part that adds the numbers to the list
     * 
     * @param chosenWord this is the word chosen at random 
     * @param wordLetters this is the letters in the chosen word
     * @return this returns the shuffled letters of the chosen word
     */
    public static ArrayList<Character> shuffleWord(String chosenWord, ArrayList<Character> wordLetters ){            
        Collections.shuffle(wordLetters);
        return wordLetters;
    }
    
    public static void main(String[] args) throws Exception {       
        int points = 0;        
        int justforFunsies;        
        boolean alreadyUsed = false;
        boolean isWord = true;       
        boolean check = false;      
        String chosenWord = "null";      
        String inputWord;      
        ArrayList<String> inputWords = new ArrayList<String>();        
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Character> wordLetters = new ArrayList<Character>();        
        Scanner fileScanner = new Scanner(new File("words.txt"));
        Scanner input = new Scanner(System.in);        
        while(fileScanner.hasNext()){
            words.add(fileScanner.nextLine());
        }   
        Collections.shuffle(words);        
        chosenWord = wordPicker(words, chosenWord);        
       for(int n = 0; n <=6; n++){
            wordLetters.add(chosenWord.charAt(n));
        }        
        wordLetters = shuffleWord(chosenWord, wordLetters);       
        System.out.println("      " + wordLetters.get(0) + "      " + wordLetters.get(1) + "      " + wordLetters.get(2) + "      " + wordLetters.get(3) + "      " + wordLetters.get(4) + "      " + wordLetters.get(5) + "      " + wordLetters.get(6));
        while(check == false){        
            alreadyUsed = false;
            inputWord = input.next();    
            justforFunsies = inputWord.length();        
            if(inputWord.equalsIgnoreCase("bye")){
                System.out.println("Goodbye! :3");
                check = true;           
                System.exit(0);
            } else if(inputWord.equalsIgnoreCase("ls")){
                for(int i = 0; i < inputWords.size(); i++ ){
                    System.out.println(inputWords.get(i));
                }
                System.out.println("Score: " + points);
            }else if(inputWord.equalsIgnoreCase("mix")){
                wordLetters = shuffleWord(chosenWord, wordLetters);
                System.out.println("      " + wordLetters.get(0) + "      " + wordLetters.get(1) + "      " + wordLetters.get(2) + "      " + wordLetters.get(3) + "      " + wordLetters.get(4) + "      " + wordLetters.get(5) + "      " + wordLetters.get(6));        
                System.out.println("Score: " + points);        
            } else{
                if(words.contains(inputWord) == false){
                    isWord = false;                              
                }           
                if(inputWords.contains(inputWord) == true){
                    alreadyUsed = true;
                }                       
                for(int n = 0; n < justforFunsies; n++){                
                    if(wordLetters.contains(inputWord.charAt(n)) == false){
                    isWord = false;
                    }
                }           
                if(isWord == true && alreadyUsed == false){
                    if(justforFunsies == 4){
                        points = points + 1;
                    }else if(justforFunsies > 3){ 
                        points = points + justforFunsies;
                    }        
                    inputWords.add(inputWord);            
                }else{
                    System.out.println("Your word uses unavailable letters or is not a valid word! >:(");
                    isWord = true;                
                }
                 System.out.println("Score = " + points);
            }        
        }    
    input.close();
    fileScanner.close();
    }
}
