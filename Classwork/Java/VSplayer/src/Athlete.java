public class Athlete implements Comparable<Athlete>{

    private String fName;
    private String lName;
    String sport;
    Rank<Integer> rank;

    public Athlete(String fName, String lName, String sport, Rank<Integer> rank){
        this.fName = fName;
        this.lName = lName;
        this.sport = sport;
        this.rank = rank;
    }

    @Override
    public int compareTo(Athlete o) {
        if(sport.equalsIgnoreCase(o.sport)){
            if(fName.equalsIgnoreCase(o.fName)){
                return lName.compareToIgnoreCase(o.lName);
            }else{
                return fName.compareTo(o.fName);
            }
        }else{
            return sport.compareToIgnoreCase(o.sport);
        }
    }
    
    public String toString(){
        return (fName + ", " + lName + " (" + sport + " - " +  rank +")");
    }
}
