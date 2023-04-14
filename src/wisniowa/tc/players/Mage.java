package wisniowa.tc.players;

import wisniowa.tc.Constants;
import wisniowa.tc.GamePanel;
import wisniowa.tc.players.projectiles.Spell;

import javax.swing.*;
import java.util.ArrayList;

public class Mage extends Player {
    public Mage(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
        type = "mage";
        baseImage =
                new ImageIcon(
                        Constants.IMAGE_FOLDER +
                                "mage/base.png"
                ).getImage();
    }

    @Override
    public void tryGoLeft() {
        if (x == 0 && occupatedPlaces[Constants.MAX_RIGHT_PLACE][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[Constants.MAX_RIGHT_PLACE][y] = true;
            x = Constants.MAX_RIGHT_PLACE;
        } else if (x > 0 && occupatedPlaces[x - 1][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[--x][y] = true;
        }
    }

    @Override
    public void tryGoRight() {
        if (x == Constants.MAX_RIGHT_PLACE && occupatedPlaces[0][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[0][y] = true;
            x = 0;
        } else if (x * Constants.CHARACTER_IMG_WIDTH < Constants.MAX_RIGHT_POSITION && occupatedPlaces[x + 1][y] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[++x][y] = true;
        }
    }

    @Override
    public void tryGoUp() {
        if (y == 0 && occupatedPlaces[x][Constants.MAX_DOWN_PLACE] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][Constants.MAX_DOWN_PLACE] = true;
            y = Constants.MAX_DOWN_PLACE;
        } else if (y > 0 && occupatedPlaces[x][y - 1] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][--y] = true;
        }
    }

    @Override
    public void tryGoDown() {
        if (y == Constants.MAX_DOWN_PLACE && occupatedPlaces[x][0] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][0] = true;
            y = 0;
        } else if (y * Constants.CHARACTER_IMG_HEIGHT < Constants.MAX_DOWN_POSITION && occupatedPlaces[x][y + 1] == false) {
            occupatedPlaces[x][y] = false;
            occupatedPlaces[x][++y] = true;
        }
    }

    @Override
    public void attackLeft() {
        int i = x;
        if (i > 0) {
            Spell spell = new Spell(x, y, "left");
            GamePanel.projectiles.add(spell);
            System.out.println("Left Mage missile");
        }
    }

    @Override
    public void attackRight() {
        int i = x;
        if (i < Constants.MAX_RIGHT_POSITION / Constants.CHARACTER_IMG_WIDTH) {
            Spell spell = new Spell(x , y, "right");
            GamePanel.projectiles.add(spell);
            System.out.println("Right Mage missile");
        }
    }

}


