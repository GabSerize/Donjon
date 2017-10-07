package Action;

import Character.Player;
import Room.Room;

/**
 * Interface Actions
 * @author Gabrielle
 *
 */
public interface Actions {

	/**
	 * Make action
	 * 
	 * @param room 
	 * @param player
	 */
	public void act(Room room, Player player);
	
	public String toString();
	
}
