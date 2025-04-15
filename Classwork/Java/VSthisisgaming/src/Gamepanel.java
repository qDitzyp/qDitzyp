import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Gamepanel extends JPanel implements Runnable{
    private int tileSize = 32;
    public int scale = 2;
    public int finalTileSize = tileSize * scale;
    private int tileColumns = 14;
    private int tileRows = 12;
    public int width = finalTileSize * tileColumns;
    public int length = finalTileSize * tileRows;
    Thread gameLoader;
    Movement move = new Movement();
    static int playerPosX = 100;
    static int playerPosY = 100;
    static int speed = 5;
    Player player = new Player(this, move);
    public int fruitCounter = 0;
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    public Gamepanel(){
        this.setPreferredSize(new Dimension(width, length));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
        this.startGame();
    }

    public void startGame(){
        gameLoader = new Thread(this);
        gameLoader.start();
    }

    //This is what calls the game to update and repaint, it does this at 60 FPS
    @Override
    public void run() {
        double timeTil = 1000000000/60;
        double timeTo = System.nanoTime() + timeTil;
        while(gameLoader != null){
            update();
            repaint();
            try{
                double newTime = timeTo - System.nanoTime();
                newTime = newTime/1000000;
                if(newTime < 0 ){
                    newTime = 0;
                }
                Thread.sleep((long)newTime);
                timeTo = timeTo + timeTil;
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    /**
     * This is the what calls the player to update, this also adds new fruits about every second and a half
     */
    public void update(){
        player.update();
        fruitCounter++;
        if(fruitCounter > 100){
            fruits.add(new Fruit(this));
            fruitCounter = 0;
        }
    }
    //this is calls the fruits and player to be painted, it also paints the counter for how many fruit the player has 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.drawString("Fruits Collected: " + player.fruits, 360, 20);
        player.draw(g2);
        for(int i = 0; i<fruits.size(); i++){
            fruits.get(i).draw(g2);
        }
        g2.dispose();
    }
}
