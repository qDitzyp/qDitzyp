import java.text.Format;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.print("What is the temperature in Fahrenheit?");
    
        double celc = (input.nextDouble() - 32) * 5/9;

        System.out.printf("The Celcius temperature is: %.2f", celc);

        input.close();

        System.exit(0);

    }
}
