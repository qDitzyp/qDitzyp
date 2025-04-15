import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;

public class BabyThread extends Thread{

    public static boolean done = false;
    private char[] letters;
    private ZipFile file;
    private int threadNum;
    private ThreadManager mine;
    private char[] wholeThing;

    /**This the constructor for the thread, goes ahead and copies the given file and sets the variables
     * @param tempFile this is the original file that will get copied for this to use
     * @param threadNum this is the number assigned to this thread
     * @param mine this is the manager for the thread
     * @param wholeThing this is the alphabet array just with a different name to make it easier to distinguish from the set of letters the thread has
     * @throws Exception I put this here cause it has a chance to throw an exception (I think it's a zipexception if I remember correctly but I wrote this like 2 days ago and haven't slept like at all since) and the try/catch didn't wanna work
     */
    public BabyThread(ZipFile tempFile, int threadNum, ThreadManager mine, char[] wholeThing) throws Exception{
        this.threadNum = threadNum;
        this.mine = mine;
        copyFile(tempFile);
        this.wholeThing = wholeThing;
    }

    /** This copies the zip file and assigns it to the file variable
     * @param file this is the temp file that gets copied
     * @throws Exception this is the same as the last one, sort of put these as placeholder
     */
    public void copyFile(ZipFile file)throws Exception{
        try {
            FileInputStream stream = new FileInputStream(file.getFile());
            ZipInputStream zipStream = new ZipInputStream(stream);
            ZipFile temp = new ZipFile("copy" + threadNum);
            Files.copy(stream, temp.getFile().toPath());
            this.file = temp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     *  This is just to clean up the copied files and contents, after which the thread will close
     */
    public void close(){
        try {
            Files.delete(file.getFile().toPath());
            Files.delete(Paths.get("contents" + threadNum + "/message.txt"));
            Files.delete(Paths.get("contents" + threadNum));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** This is what makes the passwords! mmmmmm recursion
     * @param list this is the list of passwords, starting off with a single letter
     * @return it returns either the newly created list, or throws it into another run of the method if its not long enough for the password
     */
    public String[] passMake(String[] list){
        String[] temp = new String[(list.length*26)];
        for(int i = 0; i<list.length; i++){
                for(int b = 0; b<wholeThing.length; b++){
                    temp[(i*26)+b] = list[i] + wholeThing[b];       
                }
            }
        if(temp[0].length() == 5){
            return temp;
        }else{
            return passMake(temp);
        }
    }

    /** This is what checks the passwords created against the file
     * @param passwords this is the list of passwords to check
     */
    public void passCheck(String[] passwords){
        for(int i = 0; i<passwords.length; i++){
            try {
                file.setPassword(passwords[i].toCharArray());
                file.extractAll("contents" + threadNum);
                mine.allDone(passwords[i]);
            } catch (ZipException e) {
            }
            if(done == true){
                return;
            }
        }
    }

    public void run(){
        letters = mine.getChars();
        for(int i = 0; i<letters.length; i++){
            String[] theOne = new String[1];
            theOne[0] = Character.toString(letters[i]);
            passCheck(passMake(theOne));
            if(done == true){
                close();
                return;
            }
            
        }

    }
}
