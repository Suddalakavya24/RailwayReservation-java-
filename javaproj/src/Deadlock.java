class Route1{
	
	synchronized public void school1(Route2 r2) {
	
	System.out.println("Iam "+Thread.currentThread().getName()+"\nIam in school 1\n"+"Iam trying to refer to college 2\n");
	r2.college2();
	//cannot access the r2 because it is been locked by person2 thread
	//dead lock occured
	}
	synchronized  public void college1() {
	System.out.println("This is college1");	
	}
	
}
class Route2{
	synchronized public void school2(Route1 r1) {
		System.out.println("Iam "+Thread.currentThread().getName()+"\nIam in school2\nIam trying to refer college 1\n");
		r1.college1();
	//cannot access r1 as it is been locked by person1 main thread.
	//dead lock has occured
	//can be handled if thereis no synchronous keyword but we need it for ordered execution.
	//wait and notify methds can be used /time out process/kill one process inorder to execute other process
	}
	synchronized public void college2() {
		System.out.println("This is college2\n");
	}
	
}
class Lock implements Runnable{
	Route1 r1=new Route1();
	Route2 r2=new Route2();
      Lock(){
		Thread.currentThread().setName("person 1");
	Thread t=new Thread(this,"person 2");
	t.start();
	r1.school1(r2);
	}
	
    public void run() {
	     r2.school2(r1);
       }

}
public class Deadlock  {

	public static void main(String[] args) {
		Lock ref=new Lock();
		
}
}
