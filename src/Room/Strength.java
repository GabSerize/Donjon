package Room;

import Character.Player;

/**
 * Potion of Strength
 * @author Gabrielle
 *
 */
public class Strength  extends Item{
	int qqt;
	public Strength(int qqt) {
		super("Strength");
		this.qqt=qqt;
	}
	
	public void effect(Player player) {
		if(qqt==0) {
			System.out.println("This strength's potion is empty");
		}
		else {
			System.out.println("You gained "+qqt+" Strength");
			player.addStrength(qqt);
			qqt=0;
		}
	}
}
