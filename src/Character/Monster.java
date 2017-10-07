package Character;

import Room.Room;

/**
 * Monster
 * @author Gabrielle
 *
 */
public class Monster extends Character{
	private static int id=0;

	public Monster(int hp, int strength, int gold) {
		super(hp, strength, gold);
		id++;
	}
	public Monster(int hp, int strength, int gold, Room currentRoom) {
		super(hp, strength, gold,currentRoom);
		id++;
	}
}
