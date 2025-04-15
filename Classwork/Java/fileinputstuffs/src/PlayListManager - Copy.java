import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//make all necessary imports: you cannot use "import java.util.*"
//NOTE: This code has been sabotaged

public class PlayListManager {
    public static void main(String[] args) throws IOException{
      
        ArrayList<String> cartList = readDataFromFile("PlayList.txt");
        checkAndPrintSameItems(cartList);
    }

    public static ArrayList<String> readDataFromFile(String fileName) throws IOException{
        FileInputStream inputStream = new FileInputStream(fileName);
        Scanner inpScnr = new Scanner(inputStream);
        ArrayList<String> songsList = new ArrayList<String>();

        while(inpScnr.hasNextLine()){
            songsList.add(inpScnr.nextLine());
        }

        inputStream.close();
        inpScnr.close();

        return songsList;      
    }

    public static void checkAndPrintSameItems(ArrayList<String> songsList){
/*
 * This only works if the text file has only 2 of the song with a duplicate, it does not work if there are three
 * as it prints out the same one twice.
 */
        for(int i = 0; i < songsList.size(); ++i){
            for(int j = 0; j < songsList.size(); ++j){
                if(songsList.get(i).equalsIgnoreCase(songsList.get(j)) && i != j && i<j){
                    System.out.println("This song is already on your playlist: " + songsList.get(i));
                }
            }
        }

    }

}
