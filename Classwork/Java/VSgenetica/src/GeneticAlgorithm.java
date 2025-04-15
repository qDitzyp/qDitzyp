import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Random;
public class GeneticAlgorithm {
    
    /** This is what reads in the file data and creates an arraylist of items out of it
     * @param filename
     * @return returns the items arraylist
     * @throws FileNotFoundException
     */
    public static ArrayList<Item> readData(String filename)throws FileNotFoundException{
        Scanner file = new Scanner(new FileInputStream(filename));
        ArrayList<Item> items = new ArrayList<Item>();
        while(file.hasNextLine()){
            String lines = file.nextLine();
            Scanner splitString = new Scanner(lines);
            splitString.useDelimiter(", ");
            String itemName = splitString.next();
            double itemWeight = splitString.nextDouble();
            int itemValue = splitString.nextInt();
            items.add(new Item(itemName, itemWeight, itemValue));
            splitString.close();
        }
        file.close();
        return items;
    }
    
    
    /** This makes the initial population and puts it into an array list
     * @param items
     * @param populationSize
     * @return returns the initial population arraylist
     */
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize){
        ArrayList<Chromosome> population = new ArrayList<Chromosome>();
        for(int i = 0; i < populationSize; i++){
            population.add(new Chromosome(items));
        }
        return population;
    }
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        String filename;
        ArrayList<Integer> chosen = new ArrayList<Integer>();
        int populationSize = 10;
        Scanner input = new Scanner(System.in);
        System.out.print("What is the filename?");
        filename = input.next();
        input.close();
        ArrayList<Item> items = readData(filename);
        ArrayList<Chromosome> initialPop = initializePopulation(items, populationSize);
        ArrayList<Chromosome> newPop = new ArrayList<Chromosome>();
        
        //This is the main loop which repeats 20 times
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < initialPop.size(); j++){
                newPop.add(initialPop.get(j));
            }
            Collections.shuffle(initialPop);
            for(int j = 0; j < initialPop.size(); j+=2){
                newPop.add(initialPop.get(j).crossover(initialPop.get(j+1)));
            }
            for(int j = 0; j <(newPop.size()*.1); j++){
                boolean isChosen = false;
                do{
                    int chosenNum = rand.nextInt(newPop.size());
                    if (chosen.contains(chosenNum)){
                        isChosen = true;
                    }else{
                        isChosen = false;
                        newPop.get(chosenNum).mutate();
                        chosen.add(chosenNum);
                    }
                }while(isChosen == true);
            }
            chosen.clear();
            newPop.sort(null);
            initialPop.clear();
            for(int j = 0; j < 10; j++){
                initialPop.add(newPop.get(j));
            }
            newPop.clear();
        }
        initialPop.sort(null);
        System.out.println(initialPop.get(0));
    }
}
