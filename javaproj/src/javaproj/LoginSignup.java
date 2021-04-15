package javaproj;

import java.io.BufferedReader;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
class LoginSignup implements Serializable{
	String name,email,address,username,password;
	String str1="",from,to,date;
	short regid;
	int trainid,routeid;
	String phoneNo;
	int pnrno;
	SavingTransactionInfo sti=null;
	void  takeUserInfo() throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.println(" Please enter your details");
		System.out.print("Enter your name:");
		String userName=scan.next();
		this.setName(userName);
		System.out.print("Enter your email:");
		String userEmail=scan.next();
		String regex="^(.+)@(.+)$";
		if(userEmail.matches(regex)) 
			this.setEmail(userEmail);
		else {
			System.out.println("Invalid mail....please type again");
			this.takeUserInfo();
		}
		System.out.print("Enter your address:");
		String userAddress=scan.next();
		this.setAddress(userAddress);
		System.out.print("Enter your phone number:");
		String userPhone=scan.next();
		String r="[6-9]{1}[0-9]{8}[1-9]{1}";
		if(userPhone.matches(r)) 
			this.setPhone(userPhone);
		else {
			System.out.println("Invalid phonenumber.....please type again");
			this.takeUserInfo();
		}
		System.out.println("Enter your username:");
		String uname=scan.next();
		this.setUname(uname);
		System.out.println("Enter your password:");
		String pwd=scan.next();
		String cpw="^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		if(pwd.matches(cpw)) {
			this.setPassword(pwd);
		}
		else {
			System.out.println("Invalid password");
			this.takeUserInfo();
		}
		this.saveInfo();
	}
	void saveInfo() throws IOException {
		File f=new File("E:/TravellersList");
		int length=f.list().length+1000;
		this.regid=(short) length;
		FileOutputStream fout=new FileOutputStream("E:/TravellersList/traveller"+length+".txt");
		ObjectOutputStream oos=new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.flush();
		oos.close();
	}
	void setUname(String s) {
		username=s;
	}
	void setPassword(String s) {
		password=s;
	}
	void setPhone(String userPhone){
		phoneNo=userPhone;
	}
	void setName(String s) {
		name=s;
	}
	void setEmail(String s) {
		email=s;
	}
	void setAddress(String s){
		address=s;
	}
	String getUname() {
		return username;
	}
	String getName() {
		return name;
	}
	String getEmail() {
		return email;
	}
	String getAddress() {
		return address;
	}
	String getPhone() {
		return phoneNo;
	}
	void Signup() throws IOException, ClassNotFoundException {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter your username:");
		String uname=scan.next();
		System.out.print("Enter your password:");
		String pw=scan.next();
		System.out.print("Enter your Registration ID:");
		short reg=scan.nextShort();
		File f=new File("E:/TravellersList");
		String list[]=f.list();
		boolean isthere=false;
		for(String file:list){
			if(file.equals("traveller"+(reg)+".txt")) {
				Verification ver=new Verification();
				if(ver.verify(uname, pw, (short)reg)) {
					this.choice();
					isthere=true;
				}
				else {
					this.Signup();
					isthere=true;
				}
				break;
			}
		}
		if(!isthere) {
			this.takeUserInfo();
			System.out.println("Your account is successfully registered!!!");
			System.out.println("Your registration id is "+this.regid);
		}
	}
	void displayList(byte fileno) throws IOException, ClassNotFoundException {
		FileReader fw=new FileReader("E:/TrainsList/railway"+(fileno)+".txt");
		BufferedReader bufr=new BufferedReader(fw);
		String temp;
		while((temp=bufr.readLine())!=null) {
			System.out.println(temp);
		}
		System.out.print("Enter the train id:");
		Scanner scan=new Scanner(System.in);
		int tno=scan.nextInt();
		BookingTicket bt=new BookingTicket();
		if(bt.selectDate(tno,(byte)fileno)==1) {
			this.trainid=tno;	this.date=bt.date;
			SeatingArrangement sa=SeatingArrangement.getInstance();
			sa.PassengersInfo(tno,(byte)fileno);
			railrev obj=railrev.getInstance();
			int pass[]=new int[sa.passengers];
			pass=obj.book(tno,(byte)fileno,sa.passengers);
			if(pass!=null) {
				System.out.print("Seats no. ");
				for(int iter=0;iter<pass.length-1;iter++) {
					System.out.print(pass[iter]+",");
				}
				System.out.print(pass[pass.length-1]+" are booked");
				System.out.println();
				Payment pay=new Payment();
				float fee=pay.computeFee(sa.p_age.length);
				pay.payfee();
				GenerateReceit gr=new GenerateReceit();
				gr.receit(sa.p_age,sa.pname,sa.pgen,sa.passengers,fee,pay.cardname,pass,bt.trainno,bt.fileno,this.date);
				System.out.println();
				Random rand=new Random();
				this.pnrno=rand.nextInt((10000-999)+1)+999;
				System.out.println("Your PNR NO. is "+this.pnrno);
				List<Object> l=new ArrayList<Object>();
				l.add(sa.passengers);	l.add(fee);		l.add(pass);
				sti=SavingTransactionInfo.getInstance();
				sti.saveTransInfo(this.pnrno,l,bt.trainno,bt.fileno);
			}
		}

	}
	void choice() throws IOException, ClassNotFoundException {
		byte option;
		do {
			System.out.println("1.BOOK A TICKET\n2.CANCEL TICKET\n3.LOGOUT");
			System.out.print("Choose any option:");
			Scanner scan=new Scanner(System.in);
			option=scan.nextByte();
			switch(option) {
			case 1:this.preference();
			break;
			case 2:System.out.println("**Only 50% of your amount will be refunded**");
			System.out.println("*Cancellation charges:950.00/-*");
			this.cancelTicket();
			break;
			case 3:System.out.println("Logging Out....");
			break;
			default:System.out.println("Invalid Choice");
			break;
			}
		}while(option!=3);
	}
	void cancelTicket() {
		System.out.println("Enter your pnr no:");
		Scanner scan=new Scanner(System.in);
		int pnr=scan.nextInt();
		System.out.print("Enter your start city:");
		this.from=scan.next();
		System.out.print("Enter your destination city:");
		this.to=scan.next();
		System.out.println("Enter your train no:");
		int tno=scan.nextInt();
		SeatingArrangement sa=SeatingArrangement.getInstance();
		Payment p=new Payment();
		int[] pass=new int[10];
		List<Object> l=new ArrayList<Object>();
		l.add(sa.passengers);	l.add(p.cost);		l.add(pass);
		int fileno;
		if(this.from.equals("Hyderabad")&&this.to.equals("Mumbai")) {
			fileno=0;
			sti=SavingTransactionInfo.getInstance();
			sti.saveTransInfo(pnr, l, tno, fileno);

		}
		else if(this.from.equals("Mysore")&&this.to.equals("Delhi")){
			fileno=1;
			sti=SavingTransactionInfo.getInstance();
			sti.saveTransInfo(pnr, l, tno, fileno);
		}
	}
	void preference() throws IOException, ClassNotFoundException {
		Scanner scan=new Scanner(System.in);
		System.out.println("ROUTE 1----->Hyderabad-Mumbai\nROUTE 2----->Mysore-Delhi");
		System.out.print("Enter your start city:");
		this.from=scan.next();
		System.out.print("Enter your destination city:");
		this.to=scan.next();
		if(this.from.equals("Hyderabad")&&this.to.equals("Mumbai")) {
			this.displayList((byte)0);
		}
		else if(this.from.equals("Mysore")&&this.to.equals("Delhi")){
			this.displayList((byte)1);
		}
	}
}