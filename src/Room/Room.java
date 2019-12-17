package Room;

import java.util.ArrayList;

import Character.Monster;
import Play.Direction;

/**
 * Define of room
 * @author Gabrielle
 *
 */
public class Room {
	private ArrayList<Item> listItem;
	private ArrayList<Monster> listMonster;
	private ArrayList<Direction> listDirection;
	private boolean exit=false;
	private int[] coord;

	public Room(int coordx, int coordy) {
		listItem=new ArrayList<Item>();
		listMonster=new ArrayList<Monster>();
		listDirection=new ArrayList<Direction>();
		coord= new int[2];
		coord[0]=coordx;
		coord[1]=coordx;
	}

	public void setExit() {
		this.exit=true;
	}
	public boolean isExit() {
		return exit;
	}

	public void addItem(Item item) {
		listItem.add(item);
	}
	
	public void removeItem(int i) {
		listItem.remove(i);
	}

	public int getItemSize() {
		return listItem.size();
	}
	
	public Item getItem(int i) {
		return listItem.isEmpty()? null: listItem.size()>=i? null: listItem.get(i);
	}

	public void addMonster(Monster monster) {
		listMonster.add(monster);
	}
	public void removeMonster(int i) {
		listMonster.remove(i);
	}

	public int getMonsterSize() {
		return listMonster.size();
	}
	
	public Monster getMonster(int i) {
		return listMonster.isEmpty()? null : listMonster.size()>=i? null :listMonster.get(i);
	}

	
	public void addDirection(Direction direction) {
		listDirection.add(direction);
	}

	public int getDirectionSize() {
		return listDirection.size();
	}
	
	public Direction getDirection(int i) {
		return listDirection.isEmpty()? null:listDirection.get(i);
	}

	
	public int[] getCoord() {
		return coord;
	}
	
}
