public class PrimeThread extends Thread{
    public int count = 0;
    private int i;
    private int b;
    public PrimeThread(double i, double b){
        this.i = (int)i;
        this.b = (int)b;
    }
    public void run(){
        while(i<b){
            if(isPrime(i) == true){
                count++;
            }
            i++;
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0)return false;
        for (int i=5; i*i <= n; i= i+6)
            if (n % i == 0 || n % (i+2) == 0)
            return false;
        return true;
    }

}
