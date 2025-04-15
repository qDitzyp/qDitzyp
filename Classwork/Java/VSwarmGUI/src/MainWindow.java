import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.InputMismatchException;
public class MainWindow extends JFrame {
    private MainPanel panel;
    private JButton convert;
    private JTextField fara;
    private JTextField celc;
    private JLabel fLabel;
    private JLabel cLabel;
    private ActionListener buttonDetect;

    MainWindow(){       
        this.add(panel = new MainPanel());
        panel.addHoro(fLabel = new JLabel("Fahrenheit"), fara = new JTextField(), convert = new JButton("Convert"));
        panel.addHoro(cLabel = new JLabel("Celcius"), celc = new JTextField());
        panel.addVert(fLabel, cLabel);
        panel.addVert(fara, celc);
        panel.addVert(convert);
        panel.setHoro();
        panel.setVert();
        panel.setGroups();
        convert.addActionListener(buttonDetect = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){;  
                double res = Double.parseDouble(fara.getText());
                res = ((res - 32)*(5.0/9.0));
                celc.setText(""+res);
            }
        });
        this.setVisible(true);
    }
}
