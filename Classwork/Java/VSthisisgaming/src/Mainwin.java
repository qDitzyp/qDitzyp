import javax.swing.JFrame;

public class Mainwin extends JFrame{

    /**
     * This is window you play in, not much else here
     */
    public Mainwin(){
        Gamepanel panel = new Gamepanel();
        this.add(panel);
        this.setSize(panel.getPreferredSize());
    }

}
