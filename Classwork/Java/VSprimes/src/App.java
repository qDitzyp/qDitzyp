import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        int primes=0;
        ArrayList<PrimeThread> primeThreads = new ArrayList<PrimeThread>();
        Scanner input = new Scanner(System.in);
        System.out.println("How many Threads?");
        int threads = input.nextInt();
        System.out.println("Value of n?(Must be divisible by number of threads)");
        int n = input.nextInt();
        
        //this creates the threads and puts them in a list
        for(double i = 0; i< threads; i++){
            double first;
            double mutliplierFirst = i/threads;
            double mutliplierLast = (i+1)/threads;
            if(i == 0){
                first = 1;
            }else{
                first = (n*mutliplierFirst);
            }
            if((i+1)<threads){
            primeThreads.add(new PrimeThread(first, (n*mutliplierLast)));
            }else{
                primeThreads.add(new PrimeThread(first, n));
            }
        }
        
        //this starts them
        for(int i = 0; i<primeThreads.size(); i++){
            primeThreads.get(i).start();
        }
        
        //this makes sure that they all run
        for(int i = 0; i<primeThreads.size(); i++){
            primeThreads.get(i).join();
            primes = primes + primeThreads.get(i).count;
        }
        System.out.println(primes);
    }
}
