package wisniowa.tc.players.projectiles;

public class Arrow extends Projectile {
    public Arrow(int x, int y, String direction, int parentId) {
        super(x, y, direction, "archer/" + direction + "Arrow.png", parentId);
    }
}
