import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;
public class App {
    public static void main(String[] args) throws Exception {
        MainWindow mainWin = new MainWindow();
        mainWin.setSize(400, 125);
        mainWin.setLocation(300, 300);
        mainWin.setTitle("Temp Converter");
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainWin.setLocation((int)(screenSize.getWidth()/2 - mainWin.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - mainWin.getSize().getWidth()/2));
    }
}
