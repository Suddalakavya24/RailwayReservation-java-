import java.util.Scanner;

public class Stringimmutability {
	static String reverse(String S) {
		String rev="";
		int length=S.length();
		for(int i=length-1;i>=0;i--) {
			rev=rev+S.charAt(i);
		}
		return rev;
	}
	static void compare(String s1,String s2) {
		if(s1==s2) {
			System.out.println("Two objects refernce is equal\n");
		}
		if(s1.contentEquals(s2)) {
			System.out.println("Two objects contents are equal(case sensitive)\n");
		}
		else if(s1.equalsIgnoreCase(s2)) {
			System.out.println("Two objects contents are equal(case ignored)\n");
         }
		else {
			System.out.println("Objects contents are not equal");
		}
		
	}
	static String replace(String s,char original,char newchar) {
		return s.replace(original,newchar);//replace original char with new one
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="NewStringCreated";
		String s2="NewStringCreated";
		if(s1==s2) {
			System.out.println("S1 and S2 are pointing to same object\n");
		}
	
		//here s1 and s2 points to the same object in pool
		//you cant modify a string,if u modify a new string is created
		s1=s1+"Appended";
		if(s1==s2) {
			System.out.println("Modified S1 and S2 pointing to same object\n");
		}
		else {
			System.out.println("Modified S1 and S2 are not pointing to same object\n");
		}
		//appending some content to s1
		//New object is created,old object is not modified.
		//String objects created using new is also immutable
		String flower=new String("Rose");
		System.out.println("Flower: "+flower);
		String Modifiedflower=flower.concat(" Jasmine");
		System.out.println("Flower: "+flower);//It prints only rose
		System.out.println("Flowers: "+Modifiedflower);//It prints a new string ,new object
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the string to reverse\n");
		String S=scan.next();
		String rev=reverse(S);
		System.out.println("The reversed string is: "+rev);
		
		System.out.println("Enter string 1:\n");
		String string1=scan.next();
		System.out.println("Enter string 2:\n");
		String string2=scan.next();
		compare(string1,string2);
		System.out.println("The string after replacement is: "+replace("HelloWorld",'H','J'));
		
		

	}

}
