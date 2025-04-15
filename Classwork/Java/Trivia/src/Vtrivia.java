import java.util.Scanner;


public class Vtrivia {
    public static void main(String[] args) throws Exception {
        
        int right = 0;

        Boolean one;
        
        Double two;

        String three;

        String four;

        int five;

        Scanner input = new Scanner(System.in);

        System.out.print("The sky is purple.(True/False)");

        one = input.nextBoolean();
    
         if (one == false){

            right = right + 1;

            System.out.println("You got it correct! :3");

        }else{

            System.out.println("That is incorrect >:(");

        }
        
        System.out.print("What is 11/4?");

        two = input.nextDouble();

         if (two.equals(2.75)){

            right = right + 1;
            
            System.out.println("You got it correct! :3");

        }else{

            System.out.println("That is incorrect >:(");

        }
        
        System.out.print("Who is the main character of one piece?");

        three = input.next();

        three = three.toLowerCase();

        if (three.equals ("luffy")){

            right = right + 1;

            System.out.println("You got it correct! :3");

        }else{

            System.out.println("That is incorrect >:(");

        }
        
        System.out.print("What is the first letter of my name?");

        four = input.next();

        four = four.toLowerCase();

        if (four.equals("v")){

            right = right + 1;

            System.out.println("You got it correct! :3");

        }else{

            System.out.println("That is incorrect >:(");

        }
        
        System.out.print("What is 30 + 26?");

        five = input.nextInt();

       if (five == 56){

            right = right + 1;

            System.out.println("You got it correct! :3");

        }else{

            System.out.println("That is incorrect >:(");

        }

        System.out.println("You got " + right + " out of 5 questions correct! :3");
  
        input.close();

        }
}
