package Character;

import java.util.List;

import Action.Actions;
import Action.Exit;
import Action.Move;
import Play.AdventureGame;
import Play.Direction;
import Play.ScannerInt;
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

	public void act() {
		chose("What do you want make?",getCurrentRoom().getListAct()).act(getCurrentRoom(),this);;		
	}

	/**
	 * chose action make
	 * @param mes
	 * @param liste
	 * @return
	 */
	public <T extends Actions> T chose (String mes, List<T> liste) {
		System.out.println(mes);
		int length=liste.size()+1;
		for (T t : liste) {
			if(getCurrentRoom().getMonster(0)!= null) {
				if(t instanceof Move || t instanceof Exit) {
					length-=1;
				}else {
					System.out.println(t);
				}
			}else {
				System.out.println(t);	
			}
		}
		int choisi;
		return (choisi=(ScannerInt.readInt(length)))==0 ? null: liste.get(choisi-1);
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

