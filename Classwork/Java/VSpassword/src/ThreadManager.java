public class ThreadManager {

    private char[] alphabet;
    private int amount;
    private int remainder = 0;
    private int counter = 0;
    private long timer;

    /** This is my constructor for the manager, makes an array of the alphabet and calculates how many letters each thread will have as well as the remainder for the last thread if there is one
     * @param numThreads this is the number of threads used
     * @param timer this is the starting time of the program, the only reason I use it as a parameter instead of making it here is so that I can get a more accurate read by calling it right at the start of the program
     */
    public ThreadManager(int numThreads, long timer){
        alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        remainder = alphabet.length%numThreads;
        amount = (alphabet.length-remainder)/numThreads;
        this.timer = timer;
    }
    
    /** This is what the threads call to get their letters assigned
     * @return the letters that will be assigned to the thread that called the method
     */
    synchronized public char[] getChars(){
        char[] letters = new char[amount];
        if(counter+remainder+1 == alphabet.length){
            for(int i = 0; i<remainder; i++){
                letters[i] = alphabet[counter];
                counter++;
            }
        }else{
            for(int i = 0; i<amount; i++){
                letters[i] = alphabet[counter];
                counter++;
            }
        }
        return letters;
    }
	
    /**This is what goes ahead and ends the program when the password is found, it does this by changing the done boolean in BabyThread, signaling to all the threads that it's time to stop
     * @param password this is the password that the threads found
     */
    public void allDone(String password){
        BabyThread.done = true;
        long finalTime = System.currentTimeMillis() - timer;
        System.out.println("Password is: " + password);
        System.out.println("Finished in: " + finalTime + " ms");

	}

    /** Gets the alphabet
     * @return it returns the alphabet array
     */
    public char[] getAlphabet() {
        return alphabet;
    }
}
