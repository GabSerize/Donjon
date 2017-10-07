package Action;

import Character.Monster;
import Character.Player;
import Room.Room;

/**
 * Attack player versus monster
 * @author Gabrielle
 *
 */
public class Attack implements Actions{

	public String toString() {
		return "Attack";
	}

	public void act(Room room,Player player) {
		Monster m = room.startChose("What Monster would you attack?", "Monster");
		m.domage(player.getStrength());
		if (m.isDead()) {
			room.removeMonster(m);
			System.out.println("This monster is dead");
		}else {
			player.domage(m.getStrength());
		}
	}
}
