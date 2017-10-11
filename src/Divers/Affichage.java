package Divers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Action.Attack;
import Action.Take;
import Character.Monster;
import Character.Player;
import Play.AdventureGame;
import Play.Direction;
import Room.Gold;
import Room.Health;
import Room.Item;
import Room.Room;
import Room.Strength;

public class Affichage {

	private JFrame f;
	private Player player;
	private JLabel pv, force, or;

	public Affichage() {
		create();
		demarer();
	}

	public void create() {
		f= new JFrame("Donjon");
		f.setPreferredSize(new Dimension(900, 650));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

	public void demarer() {
		PanelImage panelmenu= new PanelImage("ressources/PorteDJ.jpg");
		panelmenu.setLayout(null);
		JLabel perso = new JLabel( new ImageIcon( "ressources/Personnage.png"));
		JButton enter= new JButton("Entrer");
		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Room[][] donjon = remplirDonjon();
				Random rand =new Random();
				Room startingRoom= donjon[rand.nextInt(donjon.length)][rand.nextInt(donjon[0].length)];
				AdventureGame adventuregame= new AdventureGame(startingRoom);
				player = new Player(100, 10,0, startingRoom, adventuregame,donjon);
				//adventuregame.play(player);

				panelmenu.setVisible(false);
				affichageRoom();
			}
		});
		JButton regle= new JButton("Regle");
		JButton quitter= new JButton("Quitter");
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		panelmenu.add(perso);
		perso.setBounds(500, 300, 240, 350);
		panelmenu.add(enter);
		enter.setBounds(50, 250, 100, 50);
		panelmenu.add(regle);
		regle.setBounds(50, 300, 100, 50);
		panelmenu.add(quitter);
		quitter.setBounds(50, 350, 100, 50);
		f.setContentPane(panelmenu);
	}

	public void affichageRoom() {
		PanelImage panelroom= new PanelImage("ressources/SalleDJ.jpg");
		panelroom.setLayout(null);

		Room currentRoom= player.getCurrentRoom();

		JButton direction=afficherDirection(panelroom, currentRoom);

		if(currentRoom.getMonster(0)!=null) {
			afficherMonster(panelroom, currentRoom, direction);
		}

		if(currentRoom.getItem(0)!=null) {
			afficherItem(panelroom, currentRoom);
		}		

		JLabel perso = new JLabel( new ImageIcon( "ressources/Personnage.png"));
		pv= new JLabel("Life Points :"+player.gethp());
		pv.setForeground(Color.WHITE);
		panelroom.add(pv);
		pv.setBounds(0,0,100,50);
		force= new JLabel("Strength :"+player.getstren());
		force.setForeground(Color.WHITE);
		panelroom.add(force);
		force.setBounds(0,50,100,50);
		or= new JLabel("Gold :"+player.getgold());
		or.setForeground(Color.WHITE);
		panelroom.add(or);
		or.setBounds(0,100,100,50);
		panelroom.add(perso);
		perso.setBounds(500, 300, 240, 350);
		f.setContentPane(panelroom);
	}

	public JButton afficherMonster(PanelImage panelroom, Room currentRoom, JButton move) {
		Random r = new Random();
		ArrayList<JLabel> monster= new ArrayList<>();
		for (int i = 0; i < currentRoom.getMonsterSize(); i++) {
			monster.add(new JLabel(new ImageIcon(currentRoom.getMonster(i).image())));
			panelroom.add(monster.get(i));
			int[] tailleImage=currentRoom.getMonster(i).tailleImage();
			int[] place= new int[] {r.nextInt(900-tailleImage[0]),r.nextInt(600-tailleImage[1])};
			while (place[0]>500 && place[0]<600 && place[1]>400) {
				place[0]=r.nextInt(900-tailleImage[0]);
				place[1]=r.nextInt(600-tailleImage[1]);
			}
			monster.get(i).setBounds(place[0],place[1],tailleImage[0],tailleImage[1]);
		}
		JButton attack= new JButton("Attack");
		attack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Monster> vectmonster= new Vector<>();
				for (int i = 0; i < currentRoom.getMonsterSize(); i++) {
					vectmonster.add(currentRoom.getMonster(i));
				}
				JList<Monster> listMonster= new JList<>(vectmonster);
				panelroom.add(listMonster);
				listMonster.setBounds(900-150,0, 150, 100);
				listMonster.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (listMonster.isVisible()) {
							int idx=listMonster.getSelectedIndex();
							new Attack().act(currentRoom, player, idx);
							listMonster.setVisible(false);
							if(currentRoom.getMonster(listMonster.getSelectedIndex()).isDead()) {
								monster.get(idx).setVisible(false);							
								monster.remove(idx);
								currentRoom.removeMonster(idx);
								listMonster.setSelectedIndex(0);
								if(currentRoom.getMonster(0)== null) {
									attack.setVisible(false);
									move.setVisible(true);
								}
								or.setText("Gold :"+player.getgold());
							}
							pv.setText("Life Points :"+player.gethp());
						}
					}
				});
			}
		});

		panelroom.add(attack);
		attack.setBounds(570, 450, 100, 50);
		return attack;
	}

	public JButton afficherItem(PanelImage panelroom, Room currentRoom) {
		Random r = new Random();
		ArrayList<JLabel> item= new ArrayList<>();
		for (int i = 0; i < currentRoom.getItemSize(); i++) {
			item.add(new JLabel(new ImageIcon(currentRoom.getItem(i).image())));
			panelroom.add(item.get(i));
			int[] tailleImage=currentRoom.getItem(i).tailleImage();
			int[] place= new int[] {r.nextInt(900-tailleImage[0]),r.nextInt(50)+550-tailleImage[1]};
			while (place[0]>500 && place[0]<740) {
				place[0]=r.nextInt(900-tailleImage[0]);
				place[1]=r.nextInt(r.nextInt(50)+550-tailleImage[1]);
			}
			item.get(i).setBounds(place[0],place[1],tailleImage[0],tailleImage[1]);
		}
		JButton take= new JButton("Take");
		take.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<Item> vectitem= new Vector<>();
				for (int i = 0; i < currentRoom.getItemSize(); i++) {
					vectitem.add(currentRoom.getItem(i));
				}
				JList<Item> listItem= new JList<>(vectitem);
				panelroom.add(listItem);
				listItem.setBounds(900-150,0, 150, 100);
				listItem.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (listItem.isVisible()) {
							int idx=listItem.getSelectedIndex();
							new Take().act(currentRoom, player, idx);
							listItem.setVisible(false);
							item.get(idx).setVisible(false);							
							item.remove(idx);
							currentRoom.removeItem(idx);
							listItem.setSelectedIndex(0);
							if(currentRoom.getItem(0)== null) {
								take.setVisible(false);

							}
							pv.setText("Life Points :"+player.gethp());
							force.setText("Strength :"+player.getstren());
							or.setText("Gold :"+player.getgold());
						}
					}
				});
			}
		});

		panelroom.add(take);
		take.setBounds(570, 500, 100, 50);
		return take;
	}

	public JButton afficherDirection(PanelImage panelroom, Room currentRoom) {
		JButton direction= new JButton("Move");
		direction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		if (currentRoom.getMonster(0)!=null){
			direction.setVisible(false);
		}

		panelroom.add(direction);
		direction.setBounds(570, 550, 100, 50);
		return direction;
	}

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

	public static void main(String args[]){

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Affichage();
			}
		});
	}

}

class PanelImage extends JPanel {

	private Image image;

	public PanelImage(String path) {
		image=new ImageIcon(path).getImage();
	}
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,null);
	} 

}
