package Room;

import Character.Player;

/**
 * Potion of health
 * @author Gabrielle
 *
 */
public class Health extends Item{
	int qqt;
	public Health(int qqt) {
		super("Health");
		this.qqt=qqt;
	}
	
	public void effect(Player player) {
		if(qqt==0) {
			System.out.println("This health's potion is empty");
		}
		else {
			System.out.println("You gained "+qqt+" life point");
			player.heal(qqt);
			qqt=0;
		}
	}
}
