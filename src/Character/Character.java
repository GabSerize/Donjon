package Character;

import Room.Room;

/**
 * Defin all type of character
 * @author Gaby
 *
 */
public abstract class Character {
	protected int hp, strength, gold;
	private Room currentRoom;
	
	/**
	 * Constructor for define life point ,strength, gold and current Room
	 * 
	 * @param hp
	 * @param strength
	 * @param gold
	 * @param currentRoom
	 */
	public Character(int hp, int strength, int gold,Room currentRoom) {
		this.hp=hp;
		this.strength=strength;
		this.gold=gold;
		this.setCurrentRoom(currentRoom);
	}
	
	/**
	 * Constructor for define life point ,strength, gold
	 * 
	 * @param hp
	 * @param strength
	 * @param gold
	 */
	public Character(int hp, int strength, int gold) {
		this.hp=hp;
		this.strength=strength;
		this.gold=gold;
	}
	
	public int gethp() {
		return hp;
	}
	
	public int getgold() {
		return gold;
	}
	
	public int getstren() {
		return strength;
	}
	
	public void setCurrentRoom(Room room) {
		currentRoom=room;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void addGold(int gold) {
		this.gold+=gold;
	}
	
	public void heal(int lifepoint) {
		this.hp+=lifepoint;
	}
	
	public void addStrength(int strength) {
		this.strength+=strength;
	}
	
	public void domage(int lifepoint) {
		hp-=lifepoint;
	}
	
	public int getStrength() {
		return strength;
	}
}
