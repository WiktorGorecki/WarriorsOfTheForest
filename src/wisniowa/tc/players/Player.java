package wisniowa.tc.players;

import wisniowa.tc.Constants;


import java.awt.*;

public abstract class Player{
    protected static boolean [][] occupatedPlaces =
            new boolean
                    [Constants.MAX_RIGHT_PLACE+1]
                    [Constants.MAX_DOWN_PLACE+1];
    protected String name;
    protected int x;
    protected int y;
    protected Image baseImage;
    protected String type;
    protected int health=100;
    int goLeftKey;
    int goRightKey;
    int goUpKey;
    int goDownKey;
    int attackLeftKey;
    int attackRightKey;
    int killCounter;
    public int id;
    private int maxHP;

    public Player(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey, int id) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.goLeftKey = goLeftKey;
        this.goRightKey = goRightKey;
        this.goUpKey = goUpKey;
        this.goDownKey = goDownKey;
        this.attackLeftKey = attackLeftKey;
        this.attackRightKey = attackRightKey;
        occupatedPlaces[x][y] = true;
        this.id = id;
    }

    public static boolean isOccupiedPlace(int x, int y) {
        return occupatedPlaces[x][y];
    }

    public static void setOccupatedPlaces(int x, int y, boolean is){
            occupatedPlaces[x][y] = is;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getGoLeftKey() {
        return goLeftKey;
    }

    public int getGoRightKey() {
        return goRightKey;
    }

    public int getGoUpKey() {
        return goUpKey;
    }

    public int getGoDownKey() {
        return goDownKey;
    }

    public int getAttackLeftKey() {
        return attackLeftKey;
    }

    public int getAttackRightKey() {
        return attackRightKey;
    }

    public void tryGoLeft() {
        if (x > 0 && occupatedPlaces[x - 1][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[--x][y] = true;
        }
    }

    public void tryGoRight() {
        if (x*Constants.CHARACTER_IMG_WIDTH < Constants.MAX_RIGHT_POSITION && occupatedPlaces[x+1][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[++x][y] = true;
        }
    }

    public void tryGoUp() {
        if (y > 0 && occupatedPlaces[x][y-1] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][--y] = true;
        }
    }

    public void tryGoDown() {
        if (y*Constants.CHARACTER_IMG_HEIGHT < Constants.MAX_DOWN_POSITION  && occupatedPlaces[x][y+1] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][++y] = true;
        }
    }

    public void attackLeft() {
        System.out.println("Attack left!");
    }

    public void attackRight() {
        System.out.println("Attack right!");
    }
    public void tryAttackLeft(){
        String className = this.getClass().getSimpleName();
        System.out.println("dziala left: "+className);
        attackLeft();

    }

    public void tryAttackRight(){
        String className = this.getClass().getSimpleName();
        System.out.println("dziala right: " +className);
        attackRight();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static boolean[][] getOccupatedPlaces() {
        return occupatedPlaces;
    }

    public String getName() {
        return name;
    }

    public int getKillCounter() {
        return killCounter;
    }

    public void setKillCounter(int killCounter) {
        this.killCounter = killCounter;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}
