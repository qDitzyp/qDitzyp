import java.util.Scanner;

public class Multtbl {
    /*
     * This method prints out a table then ends
     * @param n- the input of the user that the table is made with
     * @return - it doesn't actually return anything - N/A
     */
   public static void printTable(int n) {
       int a;

       int b;
    for (a = 1; a <= n; a++){
        for(b = 1; b <= n; b++){

            System.out.printf("%4d", (a*b));
    
        }

        System.out.println();
    
    } 
    
    return;

   }
   /*
    *This method check whether or not n is between 0 and 50 
    *@param n - the input of the user, what this method checks
    *@return - true or false depending on the n value
    */

    public static boolean verifyNum(int n){

        boolean tf;

        if (n < 50 && n > 0){

            tf = true;

        }else{

            tf = false;

        }

        
        
        return tf;

    }    
   public static void main(String[] args) throws Exception {
       
        Scanner input = new Scanner(System.in);
       
        int n;
       
       System.out.print("What is the value of n?");
       
        n = input.nextInt();
        
        
        if(verifyNum(n) == true){

            printTable(n);

        }else{

            System.out.println("Error: n must be between 0 and 50");

            
            System.exit(0);

        

        }
    
        input.close();

     }
}
