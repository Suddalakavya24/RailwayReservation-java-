class Commonclass{
	static int click=0;
	synchronized void display(String message) {//synchronized method
	        try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<5;i++) {
			click++;
			System.out.println("click got incremented by "+message);
		}}
	  void print(String message) {
		  synchronized(Thread.currentThread()) {//synchronous block
		  try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("The current value of click in thread "+message+" is : "+click);
	  }}

	}

class Example implements Runnable{
	String message;
	static int click=0;
	Thread t;
	Commonclass ref;
	 Example(String msg,Commonclass ref ){
		this.message=msg;
		this.ref=ref;
		t=new Thread(this,msg);
		t.start();
	}
	 public void run() {
		 ref.display(message);
		 ref.print(message);
	}
}
public class Threadmain {

	public static void main(String[] args) {
	  Commonclass ref=new Commonclass();
        Example ref1=new Example("one",ref);
        Example ref2=new Example("two",ref);
        Example ref3=new Example("three",ref);
        
        System.out.println(ref1.t.isAlive());//prints true if thread is alive
        System.out.println(ref2.t.isAlive());
        System.out.println(ref3.t.isAlive());
        
        try {
        
			ref1.t.join();//ensures that thread finished its execution and joined main thread
			ref2.t.join();
			ref3.t.join();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Interruption");
		}
        System.out.println(ref1.t.isAlive());//prints false if thread finished its execution
        System.out.println(ref2.t.isAlive());
        System.out.println(ref3.t.isAlive());
        
       
	}

}
