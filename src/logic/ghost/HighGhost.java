package logic.ghost;

import utils.Config;

public abstract class HighGhost extends Ghost{
    public HighGhost() {
        super(Config.HighGhostHp);
    }

    abstract public void damange() ;
}

