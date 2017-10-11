package Room;

import Character.Player;

/**
 * Gold
 * @author Gabrielle
 *
 */
public class Gold extends Item{
	int qqt;
	public Gold(int qqt) {
		super("Gold");
		this.qqt=qqt;
	}

	public void effect(Player player) {
		if(qqt==0) {
			System.out.println("This purse is empty");
		}
		else {
			player.addGold(qqt);
			qqt=0;
		}
	}
}
