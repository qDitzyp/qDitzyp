import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App { 
    
     /**This creates a filewriter and writes the users input to the previously created file
     * @param words the words that the user input, this is what is written to the file
     * @param created this is the file that was previously created
     * @return null
     * @throws IOException
     */
    public static String writeText( String words, File created) throws IOException{
        FileWriter createdwriter = new FileWriter(created.getAbsolutePath());
        createdwriter.write(words);        
        createdwriter.close();        
        return null;
    }
    
    /** this counts the words in the file, a word is any text separated by a white space
     * @param created the file that was created 
     * @return wordcount
     * @throws FileNotFoundException
     */
    public static int countWords(File created) throws FileNotFoundException{
            Scanner filReader = new Scanner(created);
            int wordCount = 0;
            while(filReader.hasNext()){
                String word = filReader.next();                
                wordCount ++;
            }
            filReader.close();
        return wordCount;
    }
  
    public static void main(String[] args) throws Exception {      
        String words = "";
        Scanner input =  new Scanner(System.in);
        System.out.print("What is the name of the file?");   
        String name = input.nextLine();
        File created = new File(name);
        String file = created.getAbsolutePath();
        System.out.print("What would you like to print to the file?");
        words = input.nextLine();
        writeText(words, created);
        System.out.println("File " + created + " has " + countWords(created) + " words in it! :3");
        input.close();
    }
}
