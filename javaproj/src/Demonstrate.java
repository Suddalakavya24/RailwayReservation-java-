public class Demonstrate {
	int x;
	int y;//super class
	int z;
	Demonstrate(){
		x=1;//default constructor
		y=1;
		z=1;
	}
	Demonstrate(int x,int y){
		this.x=x;
		this.y=y;
	}
	Demonstrate(int x,int y,int z){
		this.x=x;
		this.y=y;//parametrized constructor
		this.z=z;
		}
	public int product() {
		return x*y*z;
	}
	static void fun1() {
		System.out.println("Successful static method creation");//method
	}


}

