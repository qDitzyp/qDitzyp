import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;
import java.util.ArrayList;

public class Example {
	//I left this up here so it would be easier to find, it works with a max of 26 threads as each thread needs a minimum of one letter, although I find it runs best with about half of that
	private static int numThreads = 26;

	public static void main(String[] args) {
		int threadNum = 0;
		try {
			ZipFile zipFile = new ZipFile("protected5.zip");
			ThreadManager manager = new ThreadManager(numThreads, System.currentTimeMillis());
			ArrayList<BabyThread> threads = new ArrayList<>();
			for(int i = 0; i<numThreads; i++){
				threads.add(new BabyThread(zipFile, threadNum, manager, manager.getAlphabet()));
				threads.get(i).start();
				threadNum++;
			}
		} catch (ZipException ze) {
			System.out.println("Nuh uh");
		} catch (Exception e){
			e.printStackTrace();
		}

    }
}
