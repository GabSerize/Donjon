package Action;

import Character.Player;
import Room.Room;

/**
 * Information Room
 * @author Gabrielle
 *
 */
public class Look implements Actions{

	public void act(Room room, Player player ) {
		System.out.println(room);
	}
	
	public String toString() {
		return "Look";
	}
}
