package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PooYaGhost extends HighGhost{
	private int power ;

    public PooYaGhost(int power) {
        this.power = power;
    }

    @Override
    public int getLevel() {
        return Config.PooYaGhostLevel;
    }

    @Override
    public String toString() {
        return "PooYaGhost [HP: " + Config.HighGhostHp + " , Power: " + power + ']' ;
    }

    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp() - this.power);
        GameController.getInstance().setScore(GameController.getInstance().getScore() - this.power);
    }

    @Override
    public void damange() {
        for(int i = 0 ; i < GameController.getInstance().getGhosts().size() ; i++) {
            GameController.getInstance().getGhosts().get(i).decreaseHp(-1*this.power);
        }
    }
}
