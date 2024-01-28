package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class MaBongGhost extends LowGhost{
	private int power ;
    private int speed ;

    public MaBongGhost() {
        this.power = Config.MaBongGhostPower ;
        this.speed = Config.MaBongGhostSpeed ;
    }

    public MaBongGhost(int power) {
        this.power = power;
        this.speed = Config.MaBongGhostSpeed ;
    }

    public MaBongGhost(int power, int speed) {
        this.power = power;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "MabongGhost " +
                "[HP: " + Config.LowGhostHp +
                " , Power: " + power +
                " , Speed: " + speed + ']' ;
    }

    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp() - (this.power*this.speed));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
