public abstract class SportTeam {
    protected String teamName;
    protected String nameInitials;
    protected int numberOfPlayers;
    protected Player[] players;
    protected Player[] activePlayers;

    public SportTeam(String teamName, String nameInitials, int numberOfPlayers, Player[] players, Player[] activePlayers) {
        this.teamName = teamName;
        this.nameInitials = nameInitials.length() > 3 ?
                nameInitials.substring(0,3).toUpperCase() :
                nameInitials.toUpperCase();
        this.numberOfPlayers = numberOfPlayers;
        this.players = players;
        this.activePlayers = activePlayers;
    }

    public boolean playerChange(int p1_num, int p2_num){
        int p1_index, p2_index;
        p1_index = Player.indexOfInstanceInArray(players, p1_num);
        p2_index = Player.indexOfInstanceInArray(players, p2_num);

        if (p1_index == -1 || p2_index == -1) return false;

        Player p1, p2;
        p1 = players[p1_index];
        p2 = players[p2_index];
        return p1.playerChanging(p2);
    }


}
