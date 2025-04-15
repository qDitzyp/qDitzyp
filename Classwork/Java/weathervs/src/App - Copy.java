import java.util.Scanner;

import java.util.ArrayList;

public class App {
   
    /**
     *  Averages all of the numbers in the array as well as prints out the averages
     * @param list
     * @param days
     * @return 0
     */
    public static int findAverage(ArrayList<Integer> list, int days){

    int averagem = 0;

    int averageno = 0;

    int averageni = 0;
    
    int averaged;
   
    ArrayList<Integer> daverage = new ArrayList<Integer>();

    for(int counter = 0; counter <= (days - 1); counter ++){

        averaged = list.get((3*counter));

        averaged = averaged + list.get((3*counter) + 1);

        averaged = averaged + list.get((3*counter) + 2);

        averaged = averaged / 3;

        daverage.add(averaged);
   
 }

    for(int counter = 0; counter <= (days - 1); counter ++){

        averagem = averagem + list.get(counter*3);

    }

    averagem = averagem / days;

    for(int counter = 0; counter <= (days - 1); counter ++){

        averageno = averageno + list.get((counter*3) + 1);

    }

    averageno = averageno / days;

    for(int counter = 0; counter <= (days - 1); counter ++){

        averageni = averageni + list.get((counter*3) + 2);

    }

    averageni = averageni / days;

   System.out.println("---Average Report---");
   
    for(int counter = 1; counter <= days; counter ++){

        System.out.println("Day " + counter + " average is: " + daverage.get(counter- 1));

    }
    
    System.out.println("Morning average for all days: " + averagem);
    
    System.out.println("Noon average for all days: " + averageno);

    System.out.println("Night average for all days: " + averageni);
    
    return 0;
   
    }
      
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int days; 

        ArrayList<Integer> list = new ArrayList<Integer>();

        System.out.print("How many days of data?");

        days = input.nextInt();

        for(int counter = 1; counter <= days; counter ++){

            System.out.print("Day " + counter + "\nEnter morning temp:");

            list.add(input.nextInt());
        
            System.out.print("Enter noon temp:");

            list.add(input.nextInt());

            System.out.print("Enter night temp:");

            list.add(input.nextInt());

        }

        findAverage(list, days);

    }
}
