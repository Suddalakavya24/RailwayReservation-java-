
public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String obj1="kavya";
		String obj2="kavya";
		String obj7=obj1;
		System.out.println(obj7);
		if(obj7==obj1) {
			System.out.println("true");
		}
		if(obj1.contentEquals(obj2)) {//checks content
			System.out.println("yes");
		}
		String obj3=new String("java");
		String obj4=new String("java");
		if(obj3==obj4) {//checks reference
			System.out.println("yes");
		}
		else System.out.println("no");
		obj1=obj1+"sree";
	if(obj1==obj7) {
		System.out.println("yes1");
	}
	else
	System.out.println("no");
		
	}

}
