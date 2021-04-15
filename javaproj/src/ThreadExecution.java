class Trainclass implements Runnable{
	trackclass t;
	String trainname;
	public Trainclass(trackclass t,String trainname) {
		this.t=t;
		this.trainname=trainname;
	}
	public void run() {
		t.arrive(trainname);
		t.waiting(trainname);
		t.depart(trainname);
	}
}
class trackclass{
	Trainclass train;
	String name;
	boolean semaphore=false;
	public trackclass(String name) {
		this.name=name;
	}
	synchronized public void arrive(String trainname) {
		if(semaphore) {
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		semaphore=true;
		System.out.println("Arrived: "+trainname+" on "+name);
	  //  notify();
	}
	synchronized public void waiting(String trainname) {
		System.out.println("waiting: "+trainname+" on "+name);
	}
	synchronized public void depart(String trainname) {
		if(!semaphore) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		semaphore=false;
		System.out.println("depart: "+trainname+" on "+name);
		notify();
	}	
}
public class ThreadExecution{
	public static void main(String[] args) {
		trackclass t1=new trackclass("ONE");
		trackclass t2=new trackclass("TWO");
		trackclass t3=new trackclass("THREE");
		Thread train1=new Thread(new Trainclass(t1,"train1"));
		Thread train2=new Thread(new Trainclass(t1,"train2"));
		Thread train3=new Thread(new Trainclass(t1,"train3"));
		train1.start();
		train2.start();
		train3.start();
		
	}
}
