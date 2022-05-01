public abstract class Sport {
    protected int numberOfPositions;
    protected int[] madeChanges;
    protected int maxChanges;
    protected boolean isCountingChanges;
    protected SportTeam[] teams;

    public Sport(int numberOfPositions, int maxChanges, boolean isCountingChanges, SportTeam team1, SportTeam team2){
        this.numberOfPositions = numberOfPositions;
        this.maxChanges = maxChanges;
        this.isCountingChanges = isCountingChanges;
        teams = new SportTeam[] {team1, team2};
        this.madeChanges = new int[teams.length];
    }

    public Sport(int numberOfPositions, int maxChanges, boolean isCountingChanges, SportTeam team){
        this.numberOfPositions = numberOfPositions;
        this.maxChanges = maxChanges;
        this.isCountingChanges = isCountingChanges;
        teams = new SportTeam[] {team};
        this.madeChanges = new int[teams.length];
    }
    
    public boolean playerChange(int teamNum, int p1_num, int p2_num){
        if (!isPlayerChangeAllowedByNumOfChanges(teamNum)) return false;
        if (!teams[teamNum].playerChange(p1_num,p2_num)) {
            if (isCountingChanges) madeChanges[teamNum] -= 1;
            return false;
        }
        return true;
    }

    public boolean playerChange(int p1_num, int p2_num){
        if (!isPlayerChangeAllowedByNumOfChanges(0)) return false;
        if (!teams[0].playerChange(p1_num,p2_num)) {
            if (isCountingChanges) madeChanges[0] -= 1;
            return false;
        }
        return true;
    }
    
    public boolean isPlayerChangeAllowedByNumOfChanges(int teamNum){
        if(!isCountingChanges) return true;
        madeChanges[teamNum] += 1;
        if(madeChanges[teamNum] > maxChanges){
            madeChanges[teamNum] -= 1;
            return false;
        }
        return true;
    }
    
    public void resetChangeCounter(){
        madeChanges = new int[teams.length];
    }

}
