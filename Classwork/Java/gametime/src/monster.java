public class monster {

    String name;
    int monsterHealth;
    int monsterVert;
    int monsterHorz;
    boolean mAlive;
    
    /** This is the class for the monsters it has their health, position, name, and status
    * @param monsterHealth this is the health of the moster
    * @param monsterVert this is the vertical position of the monster
    * @param monsterHorz this is the horizontal position of the monster
    * @param mAlive this is the status of the monster, basically showing whether it's alive or not
    * @param name this is the name of the monster
    */
    public monster(int monsterHealth,int monsterVert,int monsterHorz,boolean mAlive, String name) {
    
        this.monsterHealth = monsterHealth;
        this.monsterVert = monsterVert;
        this.monsterHorz = monsterHorz;
        this.mAlive = mAlive;
        this.name = name;
        
        
    }
    void death(){
        this.mAlive = false;
    }

    void setHealth(int heroDamage){
        this.monsterHealth = monsterHealth - heroDamage;
    }
    
    int gethp(){
        return this.monsterHealth;
    }
        
    String getName(){
        return this.name;
    }
        
    boolean getlife(){
        return this.mAlive;
    }
    
    int gety(){
        return this.monsterVert;
    }
    
    int getx(){
        return this.monsterHorz;
    }
    @Override
    public String toString() {
        return name;
    }

}
