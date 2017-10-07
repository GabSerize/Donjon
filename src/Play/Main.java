package Play;

import java.util.Random;

import Character.Monster;
import Character.Player;
import Room.Gold;
import Room.Health;
import Room.Room;
import Room.Strength;

public class Main {

	public Room[][] remplirDonjon() {
		Room[][] donjon = new Room[5][5];
		Random rand =new Random();
		int r=0;
		boolean sortiexist= false;
		for (int i = 0; i < donjon.length; i++) {
			for (int j = 0; j < donjon[0].length; j++) {
				donjon[i][j]= new Room(i,j);
				r=rand.nextInt(2);
				for(int mob=0; mob <=r; mob++) {
					donjon[i][j].addMonster(new Monster(rand.nextInt(200)+1, rand.nextInt(15)+1, rand.nextInt(20)));
				}
				r=rand.nextInt(4);
				for(int item=0; item <=r; item++) {
					if (item==0) {
						donjon[i][j].addItem(new Gold(rand.nextInt(20)));
					}
					else if (item==1) {
						donjon[i][j].addItem(new Health(rand.nextInt(40)+10));
					}
					else if (item==2) {
						donjon[i][j].addItem(new Strength(rand.nextInt(3)+7));
					}
				}
				if(rand.nextInt(15)==0) {
					donjon[i][j].setExit();
					sortiexist=true;
				}
				if(i!=0) {
					donjon[i][j].addDirection(Direction.NORD);
				}
				if(i!=donjon.length-1) {
					donjon[i][j].addDirection(Direction.SUD);
				}
				if(j!=0) {
					donjon[i][j].addDirection(Direction.OUEST);
				}
				if(j!=donjon[0].length-1) {
					donjon[i][j].addDirection(Direction.EST);
				}
			}

		}
		if(! sortiexist) {
			donjon[donjon.length-1][donjon[0].length-1].setExit();
		}
		return donjon;
	}

	public static void main(String[] args) {	
		Main m=new Main();
		Room[][] donjon = m.remplirDonjon();
		Random rand =new Random();
		Room startingRoom= donjon[rand.nextInt(donjon.length)][rand.nextInt(donjon[0].length)];
		AdventureGame adventuregame= new AdventureGame(startingRoom);
		Player player = new Player(100, 10,0, startingRoom, adventuregame,donjon);
		adventuregame.play(player);
	}

}
