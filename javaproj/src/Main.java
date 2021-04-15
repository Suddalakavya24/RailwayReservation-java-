
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demonstrate obj1=new Demonstrate();
		Product obj2=new Product(1,2,3,4);
		System.out.println(obj2.product());
		System.out.println(obj1.product());
		obj1=obj2;
		System.out.println(obj1.product());//runtime polymorphism
		System.out.println(obj2.addition());
	}

}
