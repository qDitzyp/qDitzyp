
public class hero {

    int heroHealth;
    int heroVert;
    int heroHorz;
    boolean isAlive;
    boolean hasSword;
    String heroName;
    
    /** This is the class for the player, it has their health, position, name, and status
     * @param heroHealth this is the health of the hero
     * @param heroVert this is the vertical position of the hero
     * @param heroHorz this is the horizontal position of the hero
     * @param isAlive this is the status of the hero, basically showing the hero is alive
     * @param hasSword this is what stores whether or not the hero has the sword
     * @param heroName this is the name of the hero
     */
    public hero(int heroHealth,int heroVert,int heroHorz,boolean isAlive, boolean hasSword, String heroName) {

        this.heroHealth = heroHealth;
        this.heroVert = heroVert;
        this.heroHorz = heroHorz;
        this.isAlive = isAlive;
        this.hasSword = hasSword;
        this.heroName = heroName;
    
    }
    void death(){
        this.isAlive = false;
    }

    void setHealth(int healthChange){
        this.heroHealth = heroHealth - healthChange;
    }

    void moveup(){

        this.heroVert = heroVert - 1;
        this.heroHealth = heroHealth - 2;
    }
    void movedown(){

        this.heroVert = heroVert + 1;
        this.heroHealth = heroHealth - 2;
    }
    void moveright(){

        this.heroHorz = heroHorz + 1;
        this.heroHealth = heroHealth - 2;
    }
    void moveleft(){

        this.heroHorz = heroHorz - 1;
        this.heroHealth = heroHealth - 2;
    }

    int gethp(){
        return this.heroHealth;
    }
    
    boolean getlife(){
        return this.isAlive;
    }

    int gety(){
        return this.heroVert;
    }

    int getx(){
        return this.heroHorz;
    }

    void swordTime(){
        this.hasSword = true;
    }
    boolean getSword(){
        return this.hasSword;
    }
    String getName(){
        return this.heroName;    
    }
}
