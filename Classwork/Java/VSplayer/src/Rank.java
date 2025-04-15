public class Rank<E extends Comparable<E>>  implements Comparable<E>{
    
    private E data;
    
    public E getData() {
        return data;
    }

    public Rank(E data){
        this.data = data;
    }

    @Override
    public int compareTo(E e) {
        return data.compareTo(e);

    }

    @Override
    public String toString() {
        return ("" + data);
    }
}