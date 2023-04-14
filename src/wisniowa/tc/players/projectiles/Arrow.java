package wisniowa.tc.players.projectiles;

public class Arrow extends Projectile {
    public Arrow(int x, int y, String direction) {
        super(x, y, direction, "archer/" + direction + "Arrow.png");
    }
}
