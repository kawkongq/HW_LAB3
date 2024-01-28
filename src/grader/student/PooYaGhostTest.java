package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import logic.ghost.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.PooYaGhost;
import utils.Config;

class PooYaGhostTest {

    PooYaGhost pooYaGhost;

    @BeforeEach
    void setUp() {
        pooYaGhost = new PooYaGhost(2); 
    }
    
    @Test
    void testIsDestroyedFalse() {
        assertFalse(pooYaGhost.isDestroyed()); 
    }

    @Test
    void testIsDestroyedTrue() {
        pooYaGhost.decreaseHp(10);
        assertTrue(pooYaGhost.isDestroyed());
    }

    @Test
    void testGetHp() {
        assertEquals(10, pooYaGhost.getHp()); 
    }

    @Test
    void testDecreaseHp() {
        pooYaGhost.decreaseHp(3);
        assertEquals(7, pooYaGhost.getHp()); 
    }

    @Test
    void testDecreaseHpBelowZero() {
        pooYaGhost.decreaseHp(15);
        assertEquals(0, pooYaGhost.getHp());
    }


    @Test
    void testAttack() {
        GameController.getInstance().setHp(20); 
        GameController.getInstance().setScore(15); 
        pooYaGhost.attack();
        assertEquals(18, GameController.getInstance().getHp());
        assertEquals(13, GameController.getInstance().getScore()); 
    }
    
   
    @Test
    void testToString() {
        assertEquals("PooYaGhost [HP: 10 , Power: 2]", pooYaGhost.toString()); 
    }

    @Test
    void testDamage() {
        Ghost g1 = new GaGhost() ;
        Ghost g2 = new MaBongGhost() ;
        Ghost g3 = new PooYaGhost(999) ;

        g1.decreaseHp(2);
        g2.decreaseHp(2);
        g3.decreaseHp(2);

        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);

        pooYaGhost.damange();
        assertEquals(Config.LowGhostHp , GameController.getInstance().getGhosts().get(0).getHp());
        assertEquals(Config.LowGhostHp , GameController.getInstance().getGhosts().get(1).getHp());
        assertEquals(Config.HighGhostHp , GameController.getInstance().getGhosts().get(2).getHp());
    }

}