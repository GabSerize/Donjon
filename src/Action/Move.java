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

	public void act(Room room, Player player,int i) {
		Direction d = room.getDirection(i);
		player.move(d);
	}
	
}
