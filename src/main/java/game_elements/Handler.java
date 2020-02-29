package game_elements;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    public static List<Player> allPlayers = new ArrayList<Player>();
    public static int playersQuantity = 0;

    public void addNewPlayer(Player newPl){
        allPlayers.add(newPl);
        playersQuantity++;
    }
}
