import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.Rectangle;
import javax.imageio.ImageIO;

public class Fruit {
    public int x;
    public int y;
    Gamepanel panel;
    BufferedImage fruitImage;
    Random rand = new Random();
    public Rectangle hitBox = new Rectangle();

    /** This is the constructor for the collectable fruit in game, it pulls in the panel its in to use some of its variables
     * @param panel
     */
    public Fruit(Gamepanel panel){
        this.panel = panel;
        this.getImage();
        x = rand.nextInt(panel.width - 32*panel.scale);
        y = rand.nextInt(panel.length - 50*panel.scale);
        this.hitBox.x = x;
        this.hitBox.y = y;
        this.hitBox.width = 64;
        this.hitBox.height = 64;
    }
    /**
     * This is what gets the sprite for the fruit and puts it into fruit image
     */
    public void getImage(){
        try{
            fruitImage = ImageIO.read(new File("strawberry.png"));

        }catch(IOException e){
        }
    }

    /** This draws the fruit!
     * @param g2
     */
    public void draw(Graphics2D g2){
        g2.drawImage(fruitImage, x, y, panel.finalTileSize, panel.finalTileSize, null);

    }
}
