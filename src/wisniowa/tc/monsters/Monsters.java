package wisniowa.tc.monsters;

import wisniowa.tc.players.Player;

import java.awt.*;
import java.util.ArrayList;

public interface Monsters {

    Monster spawn();
    void attack(ArrayList<Player> players, Graphics g);
}
