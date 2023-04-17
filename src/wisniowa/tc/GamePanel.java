package wisniowa.tc;

import wisniowa.tc.monsters.Monster;
import wisniowa.tc.players.*;
import wisniowa.tc.players.projectiles.Arrow;
import wisniowa.tc.players.projectiles.Projectile;
import wisniowa.tc.players.projectiles.Spell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.String.valueOf;

public class GamePanel extends JPanel {

    static ArrayList<Player> players;
    static ArrayList<Monster> monsters;
    public static ArrayList<Projectile> projectiles;


    public GamePanel(Team team) {
        this.players = team.getTeamMembers();
        this.monsters = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        setFocusable(true);
        addKeyListener(new HeroesKeyListener2());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Projectile Renderer
        Iterator<Projectile> projectileIterator = projectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            if (projectile.getX() > Constants.MAX_RIGHT_PLACE || projectile.getX() < 0) {
                projectileIterator.remove();
                continue;
            }
            if (projectile.getDirection().equals("left")) {
                boolean projectileHit = false;
                for (Player player : players) {
                    if (player.getX() == (projectile.getX() - 1) && player.getY() == projectile.getY()) {
                        player.setHealth(player.getHealth() - 20);
                        System.out.println(player.getName() + "'s health: " + player.getHealth());
                        if (player.getHealth() <= 0) {
                            removePlayer(player);
                            System.out.println("Player " + player.getName() + " was defeated!");
                        } else {
                            System.out.println("Left projectile hit " + player.getName());
                        }
                        projectileHit = true;
                        break;
                    }
                }
                for (Monster monster : monsters) {
                    if (monster.getX() == (projectile.getX() - 1) && monster.getY() == projectile.getY()) {
                        monster.setHealth(monster.getHealth() - 20);
                        System.out.println("Monster's health: " + monster.getHealth());
                        if (monster.getHealth() <= 0) {
                            removeMonster(monster);
                            System.out.println("A monster was defeated!");
                            //Iterate through all players and find one that's id = projectile's parrent's id and add them 1 killpoint
                            //Napisz do tego oddzielną funkcję
                            for(Player player : players) {
                                if (player.id == projectile.parentId){
                                    player.setKillCounter(player.getKillCounter()+1);
                                    player.setHealth(player.getHealth()+5);
                                }
                            }
                        } else {
                            System.out.println("Left projectile hit a monster");
                        }
                        projectileHit = true;
                        break;
                    }
                }
                if (projectileHit) {
                    System.out.println("ala");
                    projectileIterator.remove();
                    repaint();
                    break;
                } else {
                    projectile.setX(projectile.getDirection());
                }
            } else if (projectile.getDirection().equals("right")) {
                boolean projectileHit = false;
                for (Player player : players) {
                    if (player.getX() == (projectile.getX() + 1) && player.getY() == projectile.getY()) {
                        player.setHealth(player.getHealth() - 20);
                        System.out.println(player.getName() + "'s health: " + player.getHealth());
                        if (player.getHealth() <= 0) {
                            removePlayer(player);
                            System.out.println("Player " + player.getName() + " was defeated!");
                        } else {
                            System.out.println("Right projectile hit " + player.getName());
                        }
                        projectileHit = true;
                        break;
                    }
                }
                for (Monster monster : monsters) {
                    if (monster.getX() == (projectile.getX() + 1) && monster.getY() == projectile.getY()) {
                        monster.setHealth(monster.getHealth() - 20);
                        System.out.println("Monster's health: " + monster.getHealth());
                        if (monster.getHealth() <= 0) {
                            removeMonster(monster);
                            System.out.println("A monster was defeated!");
                            for(Player player : players) {
                                if (player.id == projectile.parentId){
                                    player.setKillCounter(player.getKillCounter()+1);
                                    if(player.getHealth()<player.getMaxHP())
                                        player.setHealth(player.getHealth()+5);
                                }
                            }
                        } else {
                            System.out.println("Right projectile hit a monster");
                        }
                        projectileHit = true;
                        break;
                    }
                }
                if (projectileHit) {
                    System.out.println("ala");
                    projectileIterator.remove();
                    repaint();
                    break;
                } else {
                    projectile.setX(projectile.getDirection());
                }
            }
            g.drawImage(
                    projectile.getBaseImage(),
                    projectile.getX() * Constants.CHARACTER_IMG_WIDTH,
                    projectile.getY() * Constants.CHARACTER_IMG_HEIGHT,
                    this
            );
        }
        // Render monsters and players
        for (Monster monster : monsters) {
            monster.attack(players, g);
            g.drawImage(
                    monster.getBaseImage(),
                    monster.getX() * Constants.CHARACTER_IMG_WIDTH,
                    monster.getY() * Constants.CHARACTER_IMG_HEIGHT,
                    this
            );
            g.drawString(valueOf("HP: "+monster.getHealth()),monster.getX()*Constants.CHARACTER_IMG_WIDTH+2, monster.getY()*Constants.CHARACTER_IMG_HEIGHT+30);
        }
        for (Player player : players) {
            g.drawImage(
                    player.getBaseImage(),
                    player.getX() * Constants.CHARACTER_IMG_WIDTH,
                    player.getY() * Constants.CHARACTER_IMG_HEIGHT,
                    this
            );
            g.drawString(valueOf("HP: "+player.getHealth()),player.getX()*Constants.CHARACTER_IMG_WIDTH, player.getY()*Constants.CHARACTER_IMG_HEIGHT+20);
        }
    }

    public class HeroesKeyListener2 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            for (Player player : players) {
                if (player.getGoLeftKey() == key) {
                    player.tryGoLeft();
                }
                if (player.getGoRightKey() == key) {
                    player.tryGoRight();
                }
                if (player.getGoUpKey() == key) {
                    player.tryGoUp();
                }
                if (player.getGoDownKey() == key) {
                    player.tryGoDown();
                }
                if (player.getAttackLeftKey() == key) {
                    player.tryAttackLeft();
                }
                if (player.getAttackRightKey() == key) {
                    player.tryAttackRight();
                }
            }
            if (monsters.size() < 3) {
                Monster goot = new Monster(0, 0).spawn();
                monsters.add(goot);
            }
            for (boolean[]rows : Player.getOccupatedPlaces()) {
                for (boolean occupPlace : rows) {
                    System.out.print(occupPlace + " ");
                }
                System.out.println();
            }
            System.out.println();
            repaint();
        }
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public static void removePlayer(Player player) {
        Player.setOccupatedPlaces(player.getX(), player.getY(), false);
        players.remove(player);
    }

    public static void removeMonster(Monster monster) {
        Player.setOccupatedPlaces(monster.getX(), monster.getY(), false);
        monsters.remove(monster);
    }
    public static void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
    }
}
