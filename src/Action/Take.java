package Action;

import Character.Player;
import Room.Item;
import Room.Room;

/**
 * Take Item 
 * @author Gabrielle
 *
 */
public class Take implements Actions{

	
	public String toString() {
		return "Take";
	}

	public void act(Room room, Player player) {
		Item i = room.startChose("What Item would you take?", "Item");
		i.effect(player);
	}
	
}
