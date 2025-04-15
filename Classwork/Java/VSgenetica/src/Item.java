public class Item {
    private final String name;
    private final double weight;
    private final int value;
    private boolean included;

    /**This is the main constructor for the item class
     * @param name
     * @param weight
     * @param value
     */
    public Item(String name, double weight, int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.included = false;
    }
    /**This essentially creates a copy of another item
     * @param other
     */
    public Item(Item other){
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
        this.included = false;
    }

    public double getWeight(){
        return weight;
    }

    public int getValue(){
        return value;
    }

    public boolean isIncluded(){
        return included;
    }

    public void setIncluded(boolean included){
        this.included = included;
    }
    public String toString(){
        return (name + " (" + weight + " lbs, $" + value +")");
    }
}
