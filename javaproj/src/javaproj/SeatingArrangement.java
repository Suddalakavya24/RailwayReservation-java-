package javaproj;

import java.util.*;
import java.io.*;
class SeatingArrangement
{
	int row,col;
	static int trainno;	static byte fileno;
	int passengers;
	String[] pname;		String[] pgen;
	byte[] p_age;
	public SeatingArrangement(int trainno, byte fileno) {
		this.trainno=trainno;
		this.fileno=fileno;
		// TODO Auto-generated constructor stub
	}
	private static SeatingArrangement ref1=null;
	public static SeatingArrangement getInstance() {//singleton class as only one reference of theater is required for all the users
		if(ref1==null) {
			ref1=new SeatingArrangement(trainno,fileno);
			return ref1;
		}
		else  return ref1;
	}
	void PassengersInfo(int trainno,int fileno) throws ClassNotFoundException, IOException {
		System.out.print("Enter number of passenger:");
		Scanner scan=new Scanner(System.in);
		this.passengers=scan.nextInt();
		pname=new String[this.passengers];
		p_age=new byte[this.passengers];
		pgen=new String[this.passengers];
		for(byte iter=0;iter<this.passengers;iter++) {
			System.out.print("Enter the name of passenger"+(iter+1)+":");
			String n=scan.next();
			pname[iter]=n;
			System.out.print("Enter the age of passenger"+(iter+1)+":");
			byte a=scan.nextByte();
			p_age[iter]=a;
			System.out.print("Enter the gender of passenger"+(iter+1)+":");
			String g=scan.next();
			String regex="[MF]";
			if(g.matches(regex))
			pgen[iter]=g;
			else {
				this.PassengersInfo(trainno, fileno);
				break;
			}
		}
	}
}