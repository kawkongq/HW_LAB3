package logic.ghost;

import utils.Config;

public abstract class LowGhost extends Ghost{
    @Override
    public int getLevel() {
        return Config.LowGhostLevel;
    }

    public LowGhost() {
        super(Config.LowGhostHp);
    }

    @Override
    public void attack() {
        return;
    }
}
