import java.util.ArrayList;
import java.util.Random;
public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome>{
    private static Random rng;

    public Chromosome(){
    }

    /**This is the main constructor for  the Chromosome class. It uses an array list of items and copies them into itself, marking each of them as either true or false.
     * @param items
     */
    public Chromosome(ArrayList<Item> items){
        rng = new Random();
        for(int i = 0; i < items.size(); i ++){
            this.add(new Item(items.get(i)));
            if(rng.nextInt(10) > 4){
                this.get(i).setIncluded(true);
            }else{
                this.get(i).setIncluded(false);
            }
        }
    }
    
    /**This is what creates the children Chromosomes from the parent ones, it randomly chooses a truth value for each item from either parent 1 or parent 2
     * @param other
     * @return
     */
    public Chromosome crossover(Chromosome other){
        rng = new Random();
        Chromosome child = new Chromosome();
        for(int i = 0; i < this.size(); i ++){
            if(rng.nextInt(10) > 4){
                child.add(new Item(this.get(i)));
            }else{
                child.add(new Item(other.get(i)));
            }
        }
        return child;
    }

    /**
     * This is what "mutates" the randomly chosen Chromosomes, it randomly chooses whether or not to swap the truth value for each item
     */
    public void mutate(){
        for(int i = 0; i < this.size(); i ++){
            if(rng.nextInt(10) > 4){
                if(this.get(i).isIncluded() == true){
                    this.get(i).setIncluded(false);
                }else if(this.get(i).isIncluded() == false){
                    this.get(i).setIncluded(true);
                }   
            }
        }
    }
    public int getFitness(){
        int fitness = 0;
        double weight = 0;
        for(int i = 0; i < this.size(); i++ ){
            if(this.get(i).isIncluded() == true){
                fitness = fitness + this.get(i).getValue();
                weight = weight + this.get(i).getWeight();
            }
        }
        if(weight > 10){
            return 0;
        }else{
            return fitness;
        }
    }

    public int compareTo(Chromosome other){
        if(this.getFitness() == other.getFitness()){
            return 0;
        }else if(this.getFitness() > other.getFitness()){
            return -1;
        }else{
            return 1;
        }
    }
    
    public String toString(){
        String name = "";
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).isIncluded() == true){
                name = name + (this.get(i).toString() + ", ");
            }
        }
        return name;
    }
}

