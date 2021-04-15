class Player implements Runnable{
	String name;
	Race race;
	public Player(String name,Race race) {
		this.name=name;
		this.race=race;
	}
	public void run() {
		race.playerstatus(name);
	}
}
class Race{String racename;
	public Race(String racename) {
		this.racename=racename;
	}
	public void playerstatus(String name) {
		System.out.println(name+" started!\n");
	}
}
public class Relayrace {
  public static void main(String[] args) {
		Race r1=new Race("Race1");
		Race r2=new Race("Race2");
		Thread p1=new Thread(new Player("Player1",r1));
		Thread p2=new Thread(new Player("Player2",r1));
		Thread p3=new Thread(new Player("Player3",r1));
		Thread p4=new Thread(new Player("Player4",r1));
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}
