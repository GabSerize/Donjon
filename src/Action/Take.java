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

	public void act(Room room, Player player,int i) {
		Item item = room.getItem(i);
		item.effect(player);
	}
	
}
