import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the square's side: ");
        do {
            if (input.hasNextDouble() == false) {
                try {
                    throw new Exception("Error: you must enter a number");
                } catch (Exception e) {
                    System.err.println(e);
                    input.nextLine();
                    System.out.print("Enter the length of the square's side:");
                }
            }   
        }while(input.hasNextDouble() == false);
        Square s1 = new Square(input.nextDouble());
        if(s1.getSide()<0){
            do{
                System.out.print("Enter the length of the square's side: ");
                do {
                    if (input.hasNextDouble() == false) {
                        try {
                        throw new Exception("Error: you must enter a number");
                        } catch (Exception e) {
                            System.err.println(e);
                            input.nextLine();
                            System.out.print("Enter the length of the square's side:");
                            input.nextLine();
                        }
                    }
                    
                }while(input.hasNextDouble() == false);
                s1.setSide(input.nextDouble());
            }while(s1.getSide()<0);
        }

        System.out.println(s1.toString());
        System.out.println("The perimeter of the square is " + s1.getPerimeter());
        System.out.println("The area of the square is " + s1.getArea());
    }
}
