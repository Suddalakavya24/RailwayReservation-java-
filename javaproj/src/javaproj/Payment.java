package javaproj;

import java.util.*;
class InvalidCreditCardException extends Exception{
	String msg;
	InvalidCreditCardException(String msg){
		this.msg=msg;
	}
	public String toString() {
		return msg;
	}
}
public class Payment {
	String cardno,cvc;
	String expiry,cardname;
	float cost;
	float computeFee(int len) {
		int count=0;
		byte[] arr=new byte[len];
		for(byte var:arr) {
			if(var>5)
				count++;
		}
		this.cost=(arr.length-count)*750f;
		System.out.println("Your total amount is "+this.cost);
		return this.cost;
	}
	void payfee() {
		System.out.println("Please enter your credit card number:");
		Scanner scan=new Scanner(System.in);
		String cardno=scan.next();
		String regex="[1-9]{1}[0-9]{11}";
		System.out.println("Please enter the expiry month and year(MM/YY):");
		expiry=scan.next();
		System.out.println("Please enter the card holder's name:");
		cardname=scan.next();
		System.out.println("Please enter the CVC:");
		cvc=scan.next();
		String r="[1-9]{1}[0-9]{2}";
		if(!cardno.matches(regex)||!cvc.matches(r)){
			try {
				throw new InvalidCreditCardException("Invalid card number/cvc.....Please check your details");
			}
			catch(InvalidCreditCardException e) {
				System.out.println(e.toString());
				this.payfee();
			}
		}
		else
			System.out.println("Payment Successful!!!");
	}
}