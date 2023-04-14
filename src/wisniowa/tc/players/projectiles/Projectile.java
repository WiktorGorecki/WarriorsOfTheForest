package wisniowa.tc.players.projectiles;

import wisniowa.tc.Constants;
import wisniowa.tc.GamePanel;
import wisniowa.tc.monsters.Monster;
import wisniowa.tc.players.Player;

import javax.swing.*;
import java.awt.*;
public abstract class Projectile {
    protected int x;
    protected int y;
    protected Image baseImage;
    protected String direction;
    public int parentId;

    public Projectile(int x, int y, String direction, String imagePath, int parentId) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        baseImage = new ImageIcon(Constants.IMAGE_FOLDER + imagePath).getImage();
        this.parentId = parentId;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(String direction) {
        if (direction.equals("left")) {
            x = x - 1;
        }
        if (direction.equals("right")) {
            x = x + 1;
        }
    }
    public Image getBaseImage() {
        return baseImage;
    }

}

