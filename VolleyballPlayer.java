public class VolleyballPlayer extends Player{

    private Position[] positions;

    public VolleyballPlayer(String completeName, String shortName, int number, boolean isPlaying, Position[] positions) {
        super(completeName, shortName, number, isPlaying);
        this.positions = positions;
    }

    public boolean playerChanging(Player otherPlayer, Position position){
        if (!(otherPlayer instanceof VolleyballPlayer)) return false;
        VolleyballPlayer volleyballPlayer = ((VolleyballPlayer) otherPlayer);
        if (!this.hasPosition(position) || !volleyballPlayer.hasPosition(position)) return false;
        return super.playerChanging(otherPlayer);
    }

    private boolean hasPosition(Position position){
        for (Position indexedPos :
                positions) {
            if (indexedPos == position) return true;
        }
        return false;
    }

    public enum Position{
        SETTER,
        HITTER,
        OPPOSITE,
        CENTER,
        LIBERO,
        NOT_YET_CHOSEN
    }
}
