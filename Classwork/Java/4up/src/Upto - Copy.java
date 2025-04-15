import java.util.Scanner;

public class Upto {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); 

    int runtime = -1;
   
     for (int Number = 0; Number < 101;runtime = runtime + 1) {

        System.out.print("Enter a number:");
       
        Number = Number + input.nextInt();

    }

     System.out.println("You entered " + runtime + " values before the total was greater than 100.");

    input.close();
    System.exit(0);
}

}