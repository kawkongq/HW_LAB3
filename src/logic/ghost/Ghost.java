package logic.ghost;

import java.lang.reflect.Type;

public abstract class Ghost {
    private int hp ;

    public Ghost(int hp) {
        this.hp = hp ;
    }

    public boolean isDestroyed() {
        if(this.hp <= 0) {
            return true ;
        }
        else {
            return false ;
        }
    }

    public void decreaseHp(int amount) {
        this.hp = this.hp - amount ;
        if(this.hp < 0) {
            this.hp = 0 ;
        }
    }

    public int getHp() {
        return hp ;
    }

    abstract public int getLevel() ;
    abstract public void attack() ;
}
