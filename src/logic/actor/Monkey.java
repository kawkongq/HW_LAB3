package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class Monkey extends Actor{
    public Monkey() {
    }

    @Override
    public int getLevel() {
        return Config.MonkeyLevel;
    }

    @Override
    public void attack() {
        if(GameController.getInstance().getGhosts().get(0) instanceof LowGhost) {
            int a = 0 ;
            for(int i = 0 ; i < GameController.getInstance().getItems().size() ; i++) {
                if(GameController.getInstance().getItems().get(i) instanceof Banana) {
                    a = 1 ;
                    break;
                }
            }
            if(a == 1){
                GameController.getInstance().getGhosts().get(0).decreaseHp(999);
            }
            else {
                GameController.getInstance().getGhosts().get(0).decreaseHp(getLevel());
            }
        }
    }

    @Override
    public String toString() {
        return "Monkey";
    }
}