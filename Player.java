public abstract class Player {
    protected String completeName;
    protected String shortName;
    protected int number;   // Unique identifier for a player in a team
                            // ** numbers consisting of only zeros are not taken into account
    protected boolean isPlaying; // Signifies if the player is on the field
    protected boolean isActive; // Just to signify if player is or isn't able to play (ex. injury or expulsion mid-game)
    public Player(String completeName, String shortName, int number, boolean isPlaying) {
        this.completeName = completeName;
        this.shortName = shortName;
        this.number = number;
        this.isPlaying = isPlaying;
        this.isActive = true;
    }

    public boolean playerChanging(Player player){
        if (!this.isActive || !player.isActive) return false;
        if (this.isPlaying == player.isPlaying) return this.isPlaying;
        playerChangedFromBench();
        player.playerChangedFromBench();
        return true;
    }

    private void playerChangedFromBench(){
        isActive = !isActive;
    }

    public int indexOfInstanceInArray(Player[] array){
        Player player;
        for (int i = 0; i < array.length; i++) {
            player = array[i];
            if (equals(player)) return i;
        }
        return -1;
    }

    public static int indexOfInstanceInArray(Player[] array, int playerNum){
        Player player;
        for (int i = 0; i < array.length; i++) {
            player = array[i];
            if (player.number == playerNum) return i;
        }
        return -1;
    }


    //region Getters
    public String getCompleteName() {
        return completeName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getNumber() {
        return number;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public boolean isActive() {
        return isActive;
    }
    //endregion

    //region Setters
    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    //endregion

    @Override
    public boolean equals(Object o){
        if (o instanceof Player) return ((Player)o).number == this.number;
        return false;
        }

    @Override
    public String toString() {
        return "Player{" +
                "completeName='" + completeName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", number=" + number +
                ", isPlaying=" + isPlaying +
                ", isActive=" + isActive +
                '}';
    }
}
