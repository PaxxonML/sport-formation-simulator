public class VolleyballTeam extends SportTeam{

    protected Rotation rotation;

    public VolleyballTeam(String teamName, String nameInitials, int numberOfPlayers, Player[] players, Player[] activePlayers, Rotation rotation) {
        super(teamName, nameInitials, numberOfPlayers, players, activePlayers);
        this.rotation = rotation;
    }

    public enum Rotation {
        P1,
        P2,
        P3,
        P4,
        P5,
        P6
    }

    public enum Actions {
        Serving,
        Receiving
    }
}
