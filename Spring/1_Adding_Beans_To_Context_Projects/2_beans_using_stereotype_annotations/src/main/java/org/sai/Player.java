package org.sai;
import org.springframework.stereotype.Component;

@Component
public class Player {
    private String playerName;
    public String getName(){
        return playerName;
    }
    public void setName(String playerName){
        this.playerName = playerName;
    }
}
