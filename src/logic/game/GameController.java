package logic.game;

import java.util.ArrayList;
import java.util.Iterator;

import logic.actor.Actor;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.GameUtils;

public class GameController {

	private int hp;
	private int score;
	private static GameController instance;
	private ArrayList <Actor> actors;
	private ArrayList <Ghost> ghosts;
	private ArrayList <Item> items;
	private void initGame() {
		this.setHp(10);
		this.setScore(0);
		for(int i = 0 ; i < this.ghosts.size() ; i++) {
			this.ghosts.add(this.ghosts.size() , GameUtils.getRandomGhost(false));
		}
	}


	public GameController() {

		this.actors = new ArrayList <Actor> ();
		this.ghosts = new ArrayList <Ghost> ();
		this.items = new ArrayList <Item> ();

		initGame();

	}

	public static GameController getInstance() {
		if(instance == null)
			instance = new GameController();
		return instance;
	}

	public void play(Actor selectedActor) {
		int a = 0 ;
		for(int i = 0 ; i < GameController.getInstance().getItems().size() ; i++) {
			GameController.getInstance().getItems().get(i).effect();
		}
		GameController.getInstance().getGhosts().get(0).attack();
		selectedActor.attack();
		for(int i = 0 ; i < GameController.getInstance().getGhosts().size() ; i++) {
			if(GameController.getInstance().getGhosts().get(i).isDestroyed()) {
				GameController.getInstance().setScore(GameController.getInstance().getGhosts().get(i).getLevel());
				GameController.getInstance().getGhosts().add(GameController.getInstance().getGhosts().size() , GameUtils.getRandomGhost(true));
				a++ ;
			}
		}
		Iterator<Ghost> iterator = GameController.getInstance().getGhosts().iterator();
		while (iterator.hasNext()) {
			Ghost ghost = iterator.next();
			if (ghost.isDestroyed()) {
				iterator.remove();
			}
		}
	}
	public void updateGameController() {
		GameIO.showGameState();
		GameIO.showCurrentGhost(ghosts);
		Actor selectedActor = GameIO.selectActor(this.actors);
		GameIO.showItemList(this.items);
		play(selectedActor);
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getScore() {
		return score;
	}
	public ArrayList<Ghost> getGhosts() {
		return ghosts;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void addNewActor(Actor actor) {
		this.actors.add(actor);
	}
	public void addNewItem(Item item) {
		this.items.add(item);
	}
	public void addNewGhost(Ghost ghost) {
		this.ghosts.add(ghost);
	}

	public boolean isGameOver() {
		if(this.actors.isEmpty() || this.getHp() <= 0) {
			return true ;
		}
		else {
			return false ;
		}
	}

}