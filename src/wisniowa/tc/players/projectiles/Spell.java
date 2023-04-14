package wisniowa.tc.players.projectiles;

public class Spell extends Projectile {
    public Spell(int x, int y, String direction, int parentId) {
        super(x, y, direction, "mage/" + direction + "Spell.png", parentId);
    }
}
