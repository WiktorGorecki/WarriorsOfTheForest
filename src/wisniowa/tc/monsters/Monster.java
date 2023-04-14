package wisniowa.tc.monsters;

import wisniowa.tc.GamePanel;
import wisniowa.tc.players.Player;
import wisniowa.tc.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.text.StyleConstants.getBackground;
import static wisniowa.tc.GamePanel.removePlayer;

public class Monster implements Monsters{
protected int x;
protected int y;
public int attackPhase=0;
public int attackX;
public int attackY;
protected Image baseImage;
protected int health;
    public Monster (int x, int y){
        this.x=x;
        this.y=y;
        baseImage = new ImageIcon(Constants.IMAGE_FOLDER + "monster/1.png").getImage();
        health=40;

    }
    @Override
    public Monster spawn() {
            int[] randomNumber = randomNumbers();
            int x = randomNumber[0];
            int y = randomNumber[1];
            Player.setOccupatedPlaces(x, y, true);
            Monster monster=new Monster(x,y);
            return monster;
    }

    private int[] randomNumbers() {
        int[] table = new int[2];
        int x = (int) Math.floor(Math.random() * (Constants.MAX_RIGHT_PLACE + 1));
        int y = (int) Math.floor(Math.random() * (Constants.MAX_DOWN_PLACE + 1));
        System.out.println("occ"+Player.isOccupiedPlace(x, y));
        if (!Player.isOccupiedPlace(x, y)) {
            table[0] = x;
            table[1] = y;
            System.out.println("ala");
            return table;
        } else {
            System.out.println("alan");
            return randomNumbers();
        }
    }

    @Override
    public void attack(ArrayList<Player> players, Graphics g) {
        switch (attackPhase) {
            case 0:
                for (Player player : players) {
                    // calculate distance between this monster and the player
                    int dx = player.getX() - getX();
                    int dy = player.getY() - getY();
                    // if the player is within attack range, change the monster's image
                    if ((Math.abs(dx) == 1 && dy == 0) || (dx == 0 && Math.abs(dy) == 1)) {
                        attackX = player.getX();
                        attackY = player.getY();
                        setBaseImage(new ImageIcon(Constants.IMAGE_FOLDER + "monster/2.png").getImage());
                        attackPhase++;
                        break; // stop checking for other players
                    }
                }
                break;
            case 1:
                setBaseImage(new ImageIcon(Constants.IMAGE_FOLDER + "monster/1.png").getImage());
                g.setColor(Color.red);
                g.fillRect(attackX * Constants.CHARACTER_IMG_WIDTH, attackY * Constants.CHARACTER_IMG_HEIGHT, Constants.CHARACTER_IMG_WIDTH, Constants.CHARACTER_IMG_HEIGHT);
                for (Player player : GamePanel.getPlayers()) {
                    if (player.getX() == attackX && player.getY() == attackY) {
                        player.setHealth(player.getHealth() - 20);
                        System.out.println(player.getName() + "'s health: " + player.getHealth());
                        if (player.getHealth() <= 0) {
                            removePlayer(player);
                            System.out.println("Player " + player.getName() + " was defeated!");
                        } else {
                            System.out.println("Monster hit " + player.getName());
                        }
                    }
                }
                attackPhase++;
                break;
            case 2:
                attackPhase = 0;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
