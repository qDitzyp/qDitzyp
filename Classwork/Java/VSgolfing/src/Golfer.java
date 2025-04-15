public class Golfer implements Comparable<Golfer>{
    private String firstName;
    private String lastName;
    private int score;
    private int thru;
    
    public Golfer(String firstName, String lastName, int score, int thru){
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.thru = thru;

    }
    
        public int compareTo(Golfer golfer){
            if(score==golfer.score){
                if(thru==golfer.thru){
                    if(lastName.equalsIgnoreCase(golfer.lastName)){
                        if(firstName.equalsIgnoreCase(golfer.firstName)){
                            return 0;
                        }else{
                            return firstName.compareToIgnoreCase(golfer.firstName);
                        }
                    }else{
                        return lastName.compareToIgnoreCase(golfer.lastName);
                    }
                }else if(thru>golfer.thru){
                    return -1;
                }else{
                    return 1;
                }
            }else if(score>golfer.score){
                return 1;
            }else{
                return -1;
            }
        }
    
    public String toString(){
        return (lastName + ", " + firstName + ": " + score + " through " + thru);
    }
}
