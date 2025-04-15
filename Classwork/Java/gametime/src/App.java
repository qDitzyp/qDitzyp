import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {

    /**
    * this is the smelling mechanic, it checks for monsters in the tiles surrounding the hero and then stores the amount of nearby monsters in monsterNear
    * @param player
    * @param monsterNear
    * @param map
    * @param mapSize
    * @return this returns the value of monsterNear, which shows how many monsters are nearby in the form of an integer
    */
    public static int outHereSniffin(hero player, int monsterNear, int[][] map, int mapSize){
    
        monsterNear = 0;

        if(player.gety() != mapSize-1){if(map[player.gety() + 1][player.getx()] != 0 && map[player.gety() + 1][player.getx()] != 20 && map[player.gety() + 1][player.getx()] != 40){
            monsterNear = monsterNear + 1;
        }}
        if(player.gety() != 0){if(map[player.gety() - 1][player.getx()] != 0 && map[player.gety() - 1][player.getx()] != 20 && map[player.gety() - 1][player.getx()] != 40){
            monsterNear = monsterNear + 1;
        }}   
        if(player.getx() != mapSize-1){if(map[player.gety()][player.getx()+1] != 0 && map[player.gety()][player.getx()+1] != 20 && map[player.gety()][player.getx()+1] != 40){
            monsterNear = monsterNear + 1;
        }}   
        if(player.getx() != 0){if(map[player.gety()][player.getx()-1] != 0 && map[player.gety()][player.getx()-1] != 20 && map[player.gety()][player.getx()-1] != 40){
            monsterNear = monsterNear + 1;
        }}
        return monsterNear;
    }

    /** 
    * This is the combat, it basically just works as a loop of hitting until one of the actors hits 0 hp
    * @param player
    * @param monsters
    * @param map
    * @param rand
    * @return This returns the player hp amount after the battle. 
    */
    public static int combat(hero player, ArrayList<monster> monsters, int map[][], Random rand){

        if(player.gethp() > 0){    
            monster monsterFight = monsters.get((map[player.gety()][player.getx()])-1);      
            int heroDamage = 0;
            int healthChange = 0;   
            while(monsterFight.gethp() > 0 && player.gethp() > 0){
                if(player.getSword() == true){
                    heroDamage = rand.nextInt(21);
                    healthChange = rand.nextInt(6);
                }else{
                    heroDamage = rand.nextInt(11);
                    healthChange = rand.nextInt(6);
                }
                System.out.println("You hit for " + heroDamage);    
                System.out.println("You got hit for " + healthChange);
                player.setHealth(healthChange);    
                monsterFight.setHealth(heroDamage);
            }
        }
        return player.gethp();
    }
    
    public static void main(String[] args) throws Exception {        
        boolean responsecheck;
        String heroName;
        String response;
        Random rand = new Random();       
        Scanner input = new Scanner(System.in);        
        int monsterNear = 0;
        int mapSize = 0;       
        int monsterNumber;
        int monsterVert;
        int monsterHorz;        
        int swordVert;
        int swordHorz;
        ArrayList<monster> monsters = new ArrayList<monster>();        
        System.out.print("What is your name, heroic adventurer?");
        heroName = input.next();   
        hero player = new hero(100, 0, 0,true,false,heroName);
        while(mapSize < 5 || mapSize > 10){       
            System.out.print("How wide of a catacomb do you want to face (5-10)?");            
            mapSize = input.nextInt();
            if(mapSize < 5 || mapSize > 10 ){
                System.out.println("That is not a valid catacomb size!");
            }
        
        }           
        monsterNumber = Math.round((mapSize*mapSize)/6);      
        int[][] map = new int[mapSize][mapSize];
        for(int i = 0; i < map.length; i++) {
        for(int j = 0; j < map[0].length; j++) {
            map[i][j] = 0;
            }
        }        
        for(int n = 1; n < monsterNumber; n++){
            monsterVert = rand.nextInt(mapSize);
            monsterHorz = rand.nextInt(mapSize);
            while(map[monsterVert][monsterHorz] != 0 || monsterHorz == 0 && monsterVert == 0 ){
                monsterHorz = rand.nextInt(mapSize);
                monsterVert = rand.nextInt(mapSize);
            }
            map[monsterVert][monsterHorz] = n;        
            String mName = "monster " + n;          
            monster monster = new monster(25,monsterVert,monsterHorz,true,mName);
            monsters.add(monster);        
            }            
            map[mapSize - 1][mapSize - 1] = 20;
            for(int n = 0; n < 1; n++){
            swordVert = rand.nextInt(mapSize);
            swordHorz = rand.nextInt(mapSize);
            while(map[swordVert][swordHorz] != 0){
                swordHorz = rand.nextInt(mapSize);
                swordVert = rand.nextInt(mapSize);
            }
            map[swordVert][swordHorz] = 40;        
        }
        /*
        * This is the actual gameplay loop. this is where you'll find any prompts to move, calls to methods, or anything that has to do with combat
        */
        while(player.getlife() == true && map[player.gety()][player.getx()] != 20){
            System.out.println(player.getName() + " at " + (player.gety() + 1) + " , " + (player.getx() + 1) + " with " + player.gethp() + " health");
            monsterNear = outHereSniffin(player, monsterNear, map, mapSize);            
            System.out.println("You Smell " + monsterNear + " monsters nearby.");       
            System.out.print("Which way do you want to go (north, south, east, west)?");        
            response = input.next();            
            response = response.toLowerCase();            
            responsecheck = false;
            if(response.equals("east") && player.getx() != mapSize -1){
                player.moveright();
            }else if(response.equals("west") && player.getx() != 0){ 
                player.moveleft();
            }else if(response.equals("north" )&& player.gety() != 0){
                player.moveup();
            }else if(response.equals("south") && player.gety() != mapSize-1){
                player.movedown();
            }else{
                responsecheck = false;
                while(responsecheck == false){                    
                    System.out.println("You can't move that way!");
                    System.out.print("Which way do you want to go (north, south, east, west)?");       
                    response = input.next();           
                    response = response.toLowerCase();
                    if(response.equals("east") && player.getx() != mapSize-1){
                        responsecheck = true; 
                        player.moveright();
                    }else if(response.equals("west") && player.getx() != 0){ 
                        responsecheck = true;
                        player.moveleft();
                    }else if(response.equals("north" )&& player.gety() != 0){
                        responsecheck = true; 
                        player.moveup();
                    }else if(response.equals("south") && player.gety() !=mapSize-1){
                        responsecheck = true;  
                        player.movedown();
                    }
                }
            }               
            if(map[player.gety()][player.getx()] == 40){
                System.out.println("You got a sword! your damaged has increased. :3");
                player.swordTime();
                map[player.gety()][player.getx()] = 0;
            }else if(map[player.gety()][player.getx()] == 20){
                System.out.println("You have escaped the catacomb! :3");
                System.exit(0);
            }else if(map[player.gety()][player.getx()] != 0){
                combat(player,monsters,map,rand);
                if(player.gethp() <= 0){
                    System.out.println("You have died! >:(");
                    input.close();
                    System.exit(0);
                }else{
                    map[player.gety()][player.getx()] = 0;
                }
            }               
            if(player.gethp()<=0){
                System.out.println("You have died! >:(");
                input.close();
                System.exit(0);
            }                               
        }        
    }
}
