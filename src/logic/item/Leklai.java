package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import utils.Config;

public class Leklai extends Item{
    public Leklai() {
    }

    @Override
    public int getLevel() {
        return Config.LeklaiLevel;
    }

    @Override
    public void effect() {
        for(int i = 0 ; i < GameController.getInstance().getGhosts().size() ; i++) {
            if(GameController.getInstance().getGhosts().get(i).getLevel() <= getLevel()) {
                if(GameController.getInstance().getGhosts().get(i) instanceof LowGhost) {
                    GameController.getInstance().getGhosts().get(i).decreaseHp(5);
                }
                if(GameController.getInstance().getGhosts().get(i) instanceof HighGhost) {
                    GameController.getInstance().getGhosts().get(i).decreaseHp(4);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Leklai";
    }
}
