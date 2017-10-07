package Action;

import Character.Player;
import Play.Direction;
import Room.Room;

/**
 * Move to other room
 * @author Gabrielle
 *
 */
public class Move implements Actions{

	public String toString() {
		return "Move";
	}

	public void act(Room room, Player player) {
		Direction d = room.startChose("Where do you want to go?", "Direction");
		player.move(d);
	}
	
}
