package Character;

import java.util.List;

import Action.Actions;
import Action.Exit;
import Action.Move;
import Divers.ScannerInt;
import Play.AdventureGame;
import Play.Direction;
import Room.Room;

/**
 * Player
 * @author Gabrielle
 *
 */
public class Player extends Character{
	private AdventureGame game;
	private Room[][] donjon;
	private boolean isExit=false;

	public Player (int hp, int strength, int gold, Room currentRoom, AdventureGame game, Room[][] donjon) {
		super(hp, strength,gold,currentRoom);
		this.game=game;
		this.donjon=donjon;
	}

	public Player (int hp, int strength, int gold, AdventureGame game, Room[][] donjon) {
		super(hp, strength,gold);
		this.game=game;
		this.donjon=donjon;
	}

	public Room getRoom(int i, int j) {
		return donjon[i][j];
	}

	public void move(Direction d) {
		game.playerMoveTo(d);
	}

	public void exit() {
		isExit=true;
	}

	public boolean isExit() {
		return isExit;
	}

}

