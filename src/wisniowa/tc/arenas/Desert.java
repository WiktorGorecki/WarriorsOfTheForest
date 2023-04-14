package wisniowa.tc.arenas;

import wisniowa.tc.Team;

public class Desert implements IMap {
    private boolean isOpen = false;
    @Override
    public boolean open(Team team) {
        if (team.getTeamMembers().size() < 1) {
            System.out.println("Not enough party members!");
            isOpen = false;
        } else {
            System.out.println("Welcome!");
            isOpen = true;
        }
        return isOpen;
    }
}
