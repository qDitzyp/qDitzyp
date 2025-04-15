import java.util.Comparator;
public class Sorter implements Comparator<Athlete>{

    @Override
    public int compare(Athlete o1, Athlete o2) {
        if(o1.sport.compareTo(o2.sport) == 0){
            return o1.rank.getData().compareTo(o2.rank.getData());
        }else{
            return o1.sport.compareTo(o2.sport);
        }

    }
    
}
