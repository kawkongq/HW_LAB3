package logic.actor;

import logic.game.GameController;
import logic.game.GameIO;
import logic.ghost.GaGhost;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Item;
import org.ietf.jgss.GSSManager;
import utils.Config;

public class Villager extends Actor{
    public Villager() {
    }

    @Override
    public int getLevel() {
        return Config.VillagerLevel;
    }

    @Override
    public void attack() {
        if(GameController.getInstance().getGhosts().get(0) instanceof LowGhost) {
            int a = 0 ;
            for(int i = 0 ; i < GameController.getInstance().getItems().size() ; i++) {
                if(GameController.getInstance().getItems().get(i) instanceof Amulet) {
                    a = 1 ;
                    break;
                }
            }
            if(a == 1){
                GameController.getInstance().getGhosts().get(0).decreaseHp(getLevel()+1);
            }
            else {
                GameController.getInstance().getGhosts().get(0).decreaseHp(getLevel());
            }
        }
    }

    @Override
    public String toString() {
        return "Villager";
    }
}