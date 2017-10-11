package Play;

import Character.Monster;
import Character.Player;
import Room.Item;
import Room.Room;

/**
 * The Game 
 * @author Gabrielle
 *
 */
public class AdventureGame 
{
	
	private Room currentRoom;
	private Player player;
    
	public AdventureGame(Room startingRoom) {
		currentRoom=startingRoom;
	}
	
	public Room currentRoom() {
		return currentRoom;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player p) {
		player=p;
	}
	
	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
		monster.setCurrentRoom(room);
	}
	
	public void addItem(Item item, Room room) {
		room.addItem(item);
	}
	
	/**
	 * is Finished if a player is dead or exit
	 * @return
	 */
	public boolean ifFinished() {
		return player.isDead() || player.isExit();
	}
	
	public void playerMoveTo(Direction direction) {
		currentRoom=player.getRoom(currentRoom.getCoord()[0]+direction.getI(), currentRoom.getCoord()[1]+direction.getJ());
		player.setCurrentRoom(currentRoom);
	}
}
