package Action;

import Character.Player;
import Room.Room;

/**
 * Exit
 * @author Gabrielle
 *
 */
public class Exit implements Actions{

	public String toString() {
		return "Exit";
	}

	public void act(Room room, Player player,int i) {
		player.exit();
		System.out.println("You Win");
	}
	
}