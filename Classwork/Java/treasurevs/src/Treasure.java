import java.util.Random;
import java.util.Arrays;
public class Treasure {
    
    /** This is what locates the + on the map, it does this by checking each individual space until it finds the +
     * @param map
     */
    public static void getCoordinates(char[][] map){
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == '+'){
                    System.out.println("Start digging in row " + (i+1) + ", column " + (j+1));
                    return;
                }
               
            }
        }    
    }
  
    public static void main(String[] args) throws Exception {
        char[][] map = new char[10][10];
        for(int i = 0; i < map.length; i++) {
         for(int j = 0; j < map[0].length; j++) {
             map[i][j] = '-';
            }
         }    
         Random rand = new Random();
        map[rand.nextInt(10)][rand.nextInt(10)] = '+'; 
        System.out.print(" "+ Arrays.deepToString(map).replace("],","\n").replace("[", "").replace("]]", "").replace(",","")+ "\n");
         getCoordinates(map);
    }
}
