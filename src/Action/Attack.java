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

	public void act(Room room,Player player, int i) {
		Monster m = room.getMonster(i);
		m.domage(player.getStrength());
		if (!m.isDead()) {
			player.domage(m.getStrength());
		}else {
			player.addGold(m.getgold());
		}
	}
}
