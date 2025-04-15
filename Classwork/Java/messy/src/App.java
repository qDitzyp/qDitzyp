public class App {
    public static String sayHello(String yourName){
        return("Hello " + yourName + "!");
    }
    
    
    public static void main(String[] args) throws Exception {
        String yourName = sayHello("john");
        System.out.println(yourName);
    }
}
