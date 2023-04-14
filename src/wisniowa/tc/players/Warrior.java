package wisniowa.tc.players;

import wisniowa.tc.Constants;
import wisniowa.tc.GamePanel;
import wisniowa.tc.monsters.Monster;

import javax.swing.*;

public class Warrior extends Player{

    public Warrior(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
        type = "warrior";
        baseImage =
                new ImageIcon(
                        Constants.IMAGE_FOLDER +
                                "warrior/base.png"
                ).getImage();
    }

    @Override
    public void attackLeft() {
        int i = x;
        if (i > 0) {
            for (Player player : GamePanel.getPlayers()) {
                if (player.getX() == i-1 && player.getY() == y) {
                    player.setHealth(player.getHealth()-20);
                    System.out.println(player.getName()+"'s health: "+player.getHealth());
                    if (player.getHealth() <= 0) {
                        GamePanel.removePlayer(player);
                        System.out.println("Player " + player.getName() + " was defeated!");
                    } else {
                        System.out.println("Left attack of Warrior hit " + player.getName());
                    }
                    return;
                }
            }
            for (Monster monster : GamePanel.getMonsters()) {
                if (monster.getX() == i-1 && monster.getY() == y) {
                    monster.setHealth(monster.getHealth()-20);
                    System.out.println("Monster's health: "+monster.getHealth());
                    if (monster.getHealth() <= 0) {
                        GamePanel.removeMonster(monster);
                        System.out.println("A monster was defeated!");
                    } else {
                        System.out.println("Left attack of Warrior hit a monster");
                    }
                    return;
                }
            }
            System.out.println("Left attack of Warrior miss");
        }
    }

    @Override
    public void attackRight() {
        int i = x;
        if (i < Constants.MAX_RIGHT_POSITION) {
            for (Player player : GamePanel.getPlayers()) {
                if (player.getX() == i+1 && player.getY() == y) {
                    player.setHealth(player.getHealth()-20);
                    System.out.println(player.getName()+"'s health: "+player.getHealth());
                    if (player.getHealth() <= 0) {
                        GamePanel.removePlayer(player);
                        System.out.println("Player " + player.getName() + " was defeated!");
                    } else {
                        System.out.println("Right attack of Warrior hit " + player.getName());
                    }
                    return;
                }
            }
            for (Monster monster : GamePanel.getMonsters()) {
                if (monster.getX() == i+1 && monster.getY() == y) {
                    monster.setHealth(monster.getHealth()-20);
                    System.out.println("Monster's health: "+monster.getHealth());
                    if (monster.getHealth() <= 0) {
                        GamePanel.removeMonster(monster);
                        System.out.println("A monster was defeated!");
                    } else {
                        System.out.println("Right attack of Warrior hit a monster");
                    }
                    return;
                }
            }
            System.out.println("Right attack of Warrior miss");
        }
    }
}