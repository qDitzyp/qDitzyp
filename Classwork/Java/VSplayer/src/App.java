import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Athlete> athletes = new ArrayList<Athlete>();
        athletes.add(new Athlete("Vee", "Strunks", "climbing", new Rank<Integer>(1)));
        athletes.add(new Athlete("Vee", "Trust", "climbing", new Rank<Integer>(1)));
        athletes.add(new Athlete("Joshua", "Shaffer", "baseball",new Rank<Integer>(2)));
        athletes.add(new Athlete("Jacob", "Pemberton", "soccer", new Rank<Integer>(3)));
        athletes.add(new Athlete("Collin", "Pemberton", "climbing", new Rank<Integer>(10)));
        System.out.println("Unsorted athletes: ");
        for(int i = 0; i < athletes.size(); i++){
            System.out.println(athletes.get(i).toString());
        }
        athletes.sort(null);
        System.out.println("Sorted Athletes (by sport then name): ");
        for(int i = 0; i < athletes.size(); i++){
            System.out.println(athletes.get(i).toString());
        }
        athletes.sort(new Sorter());
        System.out.println("Sorted Athletes (by sport then rank): ");
        for(int i = 0; i < athletes.size(); i++){
            System.out.println(athletes.get(i).toString());
        }
    }
}
