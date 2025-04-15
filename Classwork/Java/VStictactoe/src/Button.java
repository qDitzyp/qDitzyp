import javax.swing.*;
import java.awt.event.*;
public class Button extends JButton {
    
    private ActionListener forButton;
    private static int turn = 1;
    
    /**This is the constructor for the buttons in the game, brings in name for the text of the button
     * @param name
     */
    public Button(String name){
        this.setText(name);
        this.setName(name);
        this.addActionListener(forButton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(Button.this.getText().equals("X") || Button.this.getText().equals("O")){
                }else if(turn ==1){
                    Button.this.setText("X");
                    turn = 2;
                    MainWindow.label.setText("Player 2's turn");;
                }else if(turn ==2){
                    Button.this.setText("O");
                    turn = 1;
                    MainWindow.label.setText("Player 1's turn");;
                }
            }    
        });
    }
}
