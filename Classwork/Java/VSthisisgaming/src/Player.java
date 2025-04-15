import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;
import javax.imageio.ImageIO;

public class Player{
    public int x;
    public int y;
    public int speed;
    Gamepanel panel;
    Movement move;
    public BufferedImage standing;
    public BufferedImage up1;
    public BufferedImage up2;
    public BufferedImage down1;
    public BufferedImage down2;
    public BufferedImage left1;
    public BufferedImage left2;
    public BufferedImage right1;
    public BufferedImage right2;
    public String direction;
    public int num = 1;
    public int count = 0;
    public Rectangle hitBox = new Rectangle();
    public int fruits = 0;

    /** this is the constructor for the player, it pulls in the panel class and move class
     * @param panel
     * @param move
     */
    public Player(Gamepanel panel, Movement move){
        this.panel = panel;
        this.move = move;
        this.defaultV();
        this.getImage();
        this.hitBox.x = x;
        this.hitBox.y = y;
        this.hitBox.width = 64;
        this.hitBox.height = 64;
    }
    /**
     * this is what pulls in all of the images for the character for walking/standing
     */
    public void getImage(){
        try{
            standing = ImageIO.read(new File("standing.png"));
            up1 = ImageIO.read(new File("up1.png"));
            up2 = ImageIO.read(new File("up2.png"));
            down1 = ImageIO.read(new File("down1.png"));
            down2 = ImageIO.read(new File("down2.png"));
            left1 = ImageIO.read(new File("left1.png"));
            left2 = ImageIO.read(new File("left2.png"));
            right1 = ImageIO.read(new File("right1.png"));
            right2 = ImageIO.read(new File("right2.png"));
        }catch(IOException e){
        }
    }
    /**
     * this sets the default speed and position of the player
     */
    public void defaultV(){
        x = 100;
        y = 100;
        speed = 5;
    }
    /**
     * this is pretty much the main gameplay loop, it moves the characters position, counts how many fruit the player collects, and checks for collision with the walls and fruits
     */
    public void update(){
        if(move.up == true){
            y = y - speed;
            direction = "N";
        }else if(move.down == true){
            y = y + speed;
            direction = "S";
        }else if(move.left == true){
            x = x - speed;
            direction = "W";
        }else if(move.right == true){
            x = x + speed;
            direction = "E";
        }else{
            direction = "R";
        }
        if(x > panel.width - 32*panel.scale){
            x = panel.width - 32*panel.scale;
        }
        if(y > panel.length - 50*panel.scale){
            y = panel.length - 50*panel.scale;
        }
        if(x < 0-20){
            x = 0-20;
        }
        if(y < 0){
            y = 0;
        }
        this.hitBox.y = y;
        this.hitBox.x = x;
        count++;
        if(count > 10){
            if(num ==1){
                num = 2;
            }else if(num == 2){
                num = 1;
            }
            count = 0;
        }
        for(int i = 0; i<panel.fruits.size(); i++){
            if(this.hitBox.intersects(panel.fruits.get(i).hitBox)){
                panel.fruits.remove(i);
                fruits++;
            }
        }
    }
    /** this is what draws the player, it pulls in the Graphics2D from the main Gamepanel
     * @param g2
     */
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        if(num == 1){
            switch(direction){
                case "N":
                image = up1;
                break;
                case "S":
                image = down1;
                break;
                case "W":
                image = left1;
                break;
                case "E":
                image = right1;
                break;
                case "R":
                image = standing;
                break;
            }
        }else if(num == 2){
            switch(direction){
                case "N":
                image = up2;
                break;
                case "S":
                image = down2;
                break;
                case "W":
                image = left2;
                break;
                case "E":
                image = right2;
                break;
                case "R":
                image = standing;
                break;
            }
        }
        g2.drawImage(image, x, y, panel.finalTileSize, panel.finalTileSize, null);
    }
}
