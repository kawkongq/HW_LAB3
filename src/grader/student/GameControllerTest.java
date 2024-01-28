package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import logic.ghost.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Villager;
import logic.game.GameController;
import logic.game.GameIO;
import logic.item.Item;
import logic.item.Leklai;

class GameControllerTest {
    @Test
    void testPlayNotDestroyedGhost() {
        Actor actor = new Villager();
        
        Ghost g1 = new PooYaGhost(8);
        Ghost g2 = new GaGhost();
        Ghost g3 = new PryGhost();
        
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        
        GameController.getInstance().play(actor);
        
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayDestroyedGhost() {
    	Actor actor = new GhostDoctor();
        
        Ghost g1,g2,g3;

        g1 = new GaGhost() ;
        g2 = new MaBongGhost() ;
        g3 = new PooYaGhost(999) ;

        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);

        GameController.getInstance().play(actor);

        assertEquals(g2, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayWithItem() {
    	Actor actor = new Villager();
        Item item = new Leklai();
        
        Ghost g1 = new GaGhost() ;
        Ghost g2 = new PryGhost() ;
        Ghost g3 = new PooYaGhost(999) ;

        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        GameController.getInstance().addNewItem(item);

        GameController.getInstance().play(actor);

        GameController.getInstance().getGhosts().get(1).decreaseHp(999);

        assertEquals(10 , GameController.getInstance().getGhosts().get(0).getHp());
    }
    @Test
    void testIsGameOver() {
        Actor voo = new Villager() ;
        Ghost kuy = new PongGhost(999) ;
        Ghost noob = new PongGhost(1) ;
        kuy.attack();
        assertTrue(GameController.getInstance().isGameOver());
        GameController.getInstance().setHp(10);
        noob.attack();
        assertTrue(GameController.getInstance().isGameOver());
        GameController.getInstance().addNewActor(voo);
        assertFalse(GameController.getInstance().isGameOver());
        kuy.attack();
        assertTrue(GameController.getInstance().isGameOver());
    }

}