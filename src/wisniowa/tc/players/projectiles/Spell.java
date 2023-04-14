package wisniowa.tc.players.projectiles;

public class Spell extends Projectile {
    public Spell(int x, int y, String direction) {
        super(x, y, direction, "mage/" + direction + "Spell.png");
    }
}
