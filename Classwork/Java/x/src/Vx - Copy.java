import java.util.Scanner;


public class Vx {
    public static void main(String[] args) throws Exception {
   
        Scanner input = new Scanner(System.in);

        int n;
        
        int n2 = 0;
        
        System.out.print("What is the value of n?");
        
        n = input.nextInt();

        if (n >= 5 && n%2 ==1 ){

            for(int i = 0; i < (n-1)/2; i++){  
                
                for(int space = i; space > 0; space--){

                    System.out.print(" ");
                            
                  }


                System.out.print("*");

                for(int between = (n-2)-(i*2); between >0; between--){

                    System.out.print(" ");

                }
            
               System.out.print("* \n");
                    
              }

            for(int i2 = (n-1)/2; i2 > 0; i2--){

                System.out.print(" ");

             }
            
            System.out.print("*\n");
            
            for(int i3 = (n-1)/2; i3 > 0; i3--){
                
                for(int space = i3-1; space > 0; space--){

                    System.out.print(" ");
                            
                  }


                System.out.print("*");

                for(int between2 = 1+(n2*2) ; between2 >0; between2--){

                    System.out.print(" ");

                }
            
               System.out.print("* \n");
               
                n2++;

            }

        }else{

            System.out.println("Error: n must be an odd number greater than 3");

        }

        
    }
}
