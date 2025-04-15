import java.util.List;

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        
                Scanner scanner = new Scanner(System.in);
                
                System.out.print("Enter an integer: ");
                
                int number = scanner.nextInt();
                
                double sum = 0;
                
                int count = 0;
                
                /*
                 * This takes the integer number and outputs the sum of all the digits and the the number of the digits in the integer
                 */
                while (number != 0) {
                    
                    int digit = number % 10;
                    
                    sum += digit;
                    
                    count++;
                    
                    number /= 10;
                }
                
                /*
                This is what actually averages and prints out the integer, it does this by pulling the sum and count variables and dividing them, then printing out the average variable with some text
                */
                double average = sum / count;
                
                System.out.println("Average of the digits: " + average);
           
                System.exit(0);
            
            }
        









    }
