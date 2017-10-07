package Action;

import Character.Player;
import Room.Room;

/**
 * Information Player
 * @author Gabrielle
 *
 */
public class Info implements Actions{

	public void act(Room room, Player player ) {
		System.out.println(player);
	}
	
	public String toString() {
		return "Information Player";
	}
}