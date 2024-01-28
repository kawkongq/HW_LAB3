package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PongGhost extends HighGhost{
	private int power ;

    public PongGhost() {
        this.power = Config.PongGhostPower ;
    }

    public PongGhost(int power) {
        this.power = power;
    }

    @Override
    public int getLevel() {
        return Config.PongGhostLevel;
    }

    @Override
    public String toString() {
        return "PongGhost [HP: " + Config.HighGhostHp + " , Power: " + this.power + ']' ;
    }

    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp() - this.power);
    }

    @Override
    public void damange() {
        for(int i = 0 ; i < GameController.getInstance().getGhosts().size() ; i++) {
            if(GameController.getInstance().getGhosts().get(i).getClass() != getClass()) {
                GameController.getInstance().getGhosts().get(i).decreaseHp(-1*this.power);
            }
        }
    }
}
