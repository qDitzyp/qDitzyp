public class Events implements Comparable<Events>{

    public Double eventTime;
    private String eventText;
    
    /**this is the way I stored events, they are stored with eventTime and the text for the event
     * @param eventTime this is the time of the event
     * @param eventText this is the text for the event
     */
    public Events(double eventTime, String eventText){
        this.eventText = eventText;
        this.eventTime = eventTime;
    }

    /**this takes in a variable so I could reuse this same class for multiple formats of events
     * @param i this is just an integer to tell the difference between use cases
     * @return returns the Event in a string format
     */
    public String toString(int i){
        if(i == 1){
            return (eventTime + eventText);
        }else{
            return (eventText + eventTime + " minutes");
        }
    }
    
    
    
    @Override
    public int compareTo(Events o) {
        return this.eventTime.compareTo(o.eventTime);
    }
    
}
