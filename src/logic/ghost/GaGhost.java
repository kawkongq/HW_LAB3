package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class GaGhost extends LowGhost{
	private int energy ;

    public GaGhost() {
        this.energy = Config.GaGhostEnergy ;
    }

    public GaGhost(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "GaGhost " +
                "[HP: " + Config.LowGhostHp +
                " , " + "Energy: " + this.energy + "]";
    }

    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp() - this.energy);
    }
}
