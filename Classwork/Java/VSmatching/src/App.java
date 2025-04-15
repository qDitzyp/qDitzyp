public class App {
    
    public static void countDown(int start, int stop){
        if(stop >= start){
            
        }else if(start-1 > stop){
            System.out.print(start + " ");
            countDown(start-1, stop);
        }else{
            System.out.print(start + " " +stop);
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        System.out.println("Counting down from " + 10 + " to " + 3 + ":");
        countDown(10, 3);
        System.out.print("\n");
        System.out.println("Counting down from " + 4 + " to " + 5 + ":");
        countDown(4, 5);
        System.out.println("Counting down from " + -2 + " to " + -6 + ":");
        countDown(-2, -6);
        System.out.print("\n");
        System.out.println(Matching.nestParen("()"));
        System.out.println(Matching.nestParen("(x)"));
        System.out.println(Matching.nestParen("(())"));
        System.out.println(Matching.nestParen(""));
        System.out.println(Matching.nestParen("())"));
    }
}
