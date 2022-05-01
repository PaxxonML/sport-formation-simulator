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

    public boolean playerChange(){

    }


}
