
public class Player {
    private String playerName;
    private String sportName;

    Player(String playerName,String sport){
        this.playerName = playerName;
        this.sportName = sport;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void setSportName(String sportName){
        this.sportName = sportName;
    }
    public String getSportName(){
        return sportName;
    }
}
