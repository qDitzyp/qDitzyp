import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
public class MainWindow extends JFrame{

    private GridLayout layout;
    private Button nextButton;
    private JPanel nPanel;
    private JPanel sPanel;
    public static JLabel label = new JLabel("Player 1's turn");
    private BorderLayout mainLayout;

    /**This is the constructor for the window uses x and y to set the size of the window
     * @param x
     * @param y
     */
    public MainWindow(int x, int y){
        this.setSize(x,y);
        this.setTitle("ButtonBox");
        nPanel = new JPanel();
        sPanel = new JPanel();
        mainLayout = new BorderLayout();
        layout = new GridLayout(3,3);
        for(int j = 0; j < 9; j++){
            nPanel.add(nextButton = new Button("" + j));
        }
        nPanel.setLayout(layout);
        sPanel.setLayout(new BorderLayout());
        sPanel.add(label, BorderLayout.WEST);
        this.add(nPanel, BorderLayout.CENTER);
        this.add(sPanel, BorderLayout.SOUTH);
        this.setLocation(300,300);
        this.setVisible(true);
    }
}