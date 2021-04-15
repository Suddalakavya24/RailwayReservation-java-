package javaproj;
import java.io.*;
class CredentialsMismatchException extends Exception{
	String exc;
	CredentialsMismatchException(String exc){
		this.exc=exc;
	}
	public String toString() {
		return exc;
	}
}
public class Verification {
	boolean verify(String uname,String pw,short pnr) throws IOException, ClassNotFoundException {
		FileInputStream fin=new FileInputStream("E:/TravellersList/traveller"+(pnr)+".txt");
		ObjectInputStream ois=new ObjectInputStream(fin);
		LoginSignup user1=(LoginSignup)(ois.readObject());
		if(user1.username.equals(uname)&&user1.password.equals(pw))
			return true;
		else {
			try {
				throw new CredentialsMismatchException("Invalid username/password...Please try again");
			}
			catch(CredentialsMismatchException e) {
				System.out.println(e.toString());
			}
		}
		return false;
	}
}