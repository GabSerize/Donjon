package Play;

public enum Direction {
	NORD("Nord",-1,0),
	SUD("Sud",1,0),
	EST("Est",0,1),
	OUEST("Ouest",0,-1);
	private String name;
	private int i, j;

	//Constructeur
	Direction(String name,int i, int j){
		this.name=name;
		this.i=i;
		this.j=j;
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
	public String toString() {
		return name;
	}
}
