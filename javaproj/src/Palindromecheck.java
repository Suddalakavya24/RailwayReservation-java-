import java.util.Scanner;
public class Palindromecheck {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the string\n");
		String S=scan.next();
		String rev="";
		int length=S.length();
		for(int i=length-1;i>=0;i--) {
			rev=rev+S.charAt(i);
		}
		if(S.equalsIgnoreCase(rev)) {
			System.out.println("It is a palindrome\n");
		}
		else {
			System.out.println("Not a palindrome\n");
		}

	}

}
