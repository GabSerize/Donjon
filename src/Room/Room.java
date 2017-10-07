package Room;

import java.util.ArrayList;
import java.util.List;

import Action.Actions;
import Action.Attack;
import Action.Exit;
import Action.Info;
import Action.Look;
import Action.Move;
import Action.Take;
import Character.Monster;
import Play.Direction;
import Play.ScannerInt;

/**
 * Define of room
 * @author Gabrielle
 *
 */
public class Room {
	private ArrayList<Item> listItem;
	private ArrayList<Monster> listMonster;
	private ArrayList<Direction> listDirection;
	private ArrayList<Actions> listAct;
	private boolean exit=false;
	private int[] coord;

	public Room(int coordx, int coordy) {
		listItem=new ArrayList<Item>();
		listMonster=new ArrayList<Monster>();
		listDirection=new ArrayList<Direction>();
		listAct= new ArrayList<Actions>();
		listAct.add(new Look());
		listAct.add(new Info());
		coord= new int[2];
		coord[0]=coordx;
		coord[1]=coordx;
	}

	public void setExit() {
		listAct.add(new Exit());
		this.exit=true;
	}
	public boolean isExit() {
		return exit;
	}

	public void addItem(Item item) {
		if(listItem.isEmpty()) {
			listAct.add(new Take());
		}
		listItem.add(item);
	}
	
	public void removeItem(Item item) {
		listItem.remove(listItem.indexOf(item));
		if(listItem.isEmpty()) {
			listAct.remove(new Take());
		}
	}

	public Item getItem(int i) {
		return listItem.get(i);
	}

	public void addMonster(Monster monster) {
		if(listMonster.isEmpty()) {
			listAct.add(new Attack());
		}
		listMonster.add(monster);
	}
	public void removeMonster(Monster monster) {
		listMonster.remove(listMonster.indexOf(monster));
		if(listMonster.isEmpty()) {
			listAct.remove(new Attack());
		}
	}

	public Monster getMonster(int i) {
		return listMonster.size()==0? null :listMonster.get(i);
	}
	
	public void addDirection(Direction direction) {
		if(listDirection.isEmpty()) {
			listAct.add(new Move());
		}
		listDirection.add(direction);
	}

	public Direction getDirection(int i) {
		return listDirection.get(i);
	}
	
	public ArrayList<Actions> getListAct(){
		return listAct;
	}
	
	public int[] getCoord() {
		return coord;
	}
	
	public <T> T startChose(String mes, String type) {
		if(type.equals("Item")) {
			return (T) chose(mes, listItem);
		}else if(type.equals("Monster")) {
			return (T) chose(mes, listMonster);
		}else if(type.equals("Direction")) {
			return (T) chose(mes, listDirection);
		}
		
		return null;
	}
	private <T> T chose (String mes, List<T> liste) {
		System.out.println(mes);
		for (T t : liste) {
			System.out.println(t);	
		}
		int choisi;
		return (choisi=(ScannerInt.readInt(liste.size()+1)))==0 ? null: liste.get(choisi-1);
	}
	public String toString() {
		String text="This room contains :\n"+listItem.size()+" Item(s):\n";
		for (Item item : listItem) {
			text+=item.toString()+"\n";
		}
		text+="and "+listMonster.size()+" Monster(s):\n";
		for (Monster monster : listMonster) {
			text+=monster.toString()+"\n";
		}
		text+="You can move to:\n";
		for (Direction direction : listDirection) {
			text+=direction.toString()+"\n";
		}
		if(exit)
			text+="And this is room is one of the exit";
		return text;
	}
}
