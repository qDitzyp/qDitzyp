public class Square {
    private double side;
    public Square(double side) throws Exception{    
        this.side = side;
        try {
            if(side<0){
                throw new Exception("Negative length: " + side);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public Square(){
        this.side = 0;
    }
    public void setSide(double side) {
        this.side = side;
        try {
            if(side<0){
                throw new Exception("Negative length: " + side);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public double getSide() {
    return side;
    }
    public double getPerimeter(){
        return side*4;
    }
    public double getArea(){
        return side*side;
        
    }
    public String toString(){
        return ("Square with side = " + side);
    }
}
