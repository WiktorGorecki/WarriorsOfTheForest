package wisniowa.tc;

import wisniowa.tc.players.Archer;
import wisniowa.tc.players.Mage;
import wisniowa.tc.players.Player;
import wisniowa.tc.players.Warrior;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> teamMembers;

    public Team(ArrayList<Player> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public ArrayList<Player> getTeamMembers() {
        return teamMembers;
    }
}
