class Common{
	int counter,n;
	boolean semaphore=false;//boolean var to implement interprocess comm
	synchronized public int get() {
		if(!semaphore) {
			try {
				wait();//wait for the producer to produce
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("The value taken by consumer "+n+" is : "+counter+"\n");
		semaphore=false;
		notifyAll();//notify the producers
		return counter;
	}
	synchronized public void put(int counter,int n) {
		if(semaphore) {
			try {
				wait();//wait for the consumers to notify
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.counter=counter;
		this.n=n;
		System.out.println("The value given by producer "+n+" is : "+counter+"\n");
		semaphore=true;
		notifyAll();//notify the consumers
	}
}
class Producer implements Runnable{
	Common c;
	int n;
	Producer(Common c,int n){
	this.c=c;
	this.n=n;
	new Thread(this,"Producer"+n).start();
	}
	public void run() {
		int i=0;
		while(i<5) {
			c.put(i,n);
			i=i+1;
		}
	}
	
}
/*class Producer2 implements Runnable{
	Common c;
	Producer2(Common c){
	this.c=c;
	new Thread(this,"Producer2").start();
	}
	public void run() {
		int i=0;
		while(i<5) {
			c.put(i,2);
			i=i+1;
		}
	}
}*/
	

class Consumer implements Runnable{
	Common c;
	Consumer(Common c,int n){
		this.c=c;
		new Thread(this,"Consumer"+n).start();
	}
	public void run()
	{ int j=0;
		while(j<5) {
		int p=c.get();
		
		j=j+1;}}
}
/*class Consumer2 implements Runnable{
	Common c;
	Consumer2(Common c){
		this.c=c;
		new Thread(this,"Consumer2").start();
	}
	public void  run() {
		int k=0;
		while(k<5) {
			int m=c.get();
			System.out.println("The value taken by consumer2 is : "+m+"\n");
			k=k+1;
		}
	}
}*/
public class ProdCons {

	public static void main(String[] args) {
	  
       Common c=new Common();
       Common c2=new Common();
        new Producer(c,1);
        new Consumer(c,1);
        new Producer(c2,2);
        new Consumer(c2,2);
	}

}
