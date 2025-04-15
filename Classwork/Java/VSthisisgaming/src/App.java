import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
public class App {
    public static void main(String[] args) throws Exception {
        Mainwin mainWindow = new Mainwin();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setTitle("Coin game :3");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainWindow.setLocation((int)screenSize.getWidth()/2-mainWindow.getWidth()/2, (int)screenSize.getHeight()/2-mainWindow.getHeight()/2);
        mainWindow.setVisible(true);
        Instructions instruct = new Instructions();
        instruct.setLocation((int)screenSize.getWidth()/2-instruct.getWidth()/2, (int)screenSize.getHeight()/2-instruct.getHeight()/2);
        instruct.setVisible(true);
    }
}
