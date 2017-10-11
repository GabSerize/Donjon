package Room;

import Character.Player;

/**
 * All type of Item
 * @author Gabrielle
 *
 */
public abstract class Item {
	private static int id=0;
	private String name;
	
	public Item (String name){
		this.name=name;
	}
	
	/**
	 * effect of the object
	 * @param player
	 */
	public abstract void effect(Player player);
	
	public String toString() {
		return name;
	}
	
	public String image() {
		return "ressources/coffre.png";
	}
	
	public int[] tailleImage() {
		return new int[]{68,50};
	}
}