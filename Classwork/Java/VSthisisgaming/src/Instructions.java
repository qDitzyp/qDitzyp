import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Instructions  extends JFrame{
    JTextArea instructions = new JTextArea("Use your arrow keys to move your character around and collect fruit! Collect as many as you can when they spawn!");
    
    /**
     * This is just the window that has the instructions in it
     */
    public Instructions(){
        this.setSize(390,100);
        this.add(instructions);
        instructions.setLineWrap(true);
        instructions.setEditable(false);
    }
}
