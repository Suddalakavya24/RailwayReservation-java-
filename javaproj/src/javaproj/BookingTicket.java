package javaproj;

import java.util.Calendar;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.*;
public class BookingTicket
{
	int yy,mm,dd;	String date;
	static byte fileno;	static int trainno;
	int selectDate(int trainno,byte fileno) throws IOException, ClassNotFoundException {
		this.trainno=trainno;	this.fileno=fileno;
		System.out.println("Enter your preffered day(dd-mm-yyyy):");
		Scanner scan=new Scanner(System.in);
		date=scan.next();
		StringTokenizer token1=new StringTokenizer(date,"-");
		this.dd=Integer.parseInt(token1.nextToken());
		this.mm=Integer.parseInt(token1.nextToken());
		this.yy=Integer.parseInt(token1.nextToken());
		return check(date,this.trainno);
	}
	int check(String day,int trainno) throws IOException,ClassNotFoundException{
		FileInputStream fin=new FileInputStream("E:/TrainsInfo.txt");
		ObjectInputStream ois=new ObjectInputStream(fin);
		int iter=0;
		TrainFiles t=null;
		while(iter<=fileno) {
			t=(TrainFiles)(ois.readObject());
			iter++;
		}
		if(t.hm.containsKey(trainno)) {
			Calendar c=Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dateobj = new Date();
			//System.out.println(df.format(dateobj);
			int mmst=c.get(Calendar.MONTH)+1;
			int md=mm-mmst;
			int ddst=c.get(Calendar.DATE);
			int ddd=(dd-ddst)+md*30;
			Calendar calobj = Calendar.getInstance();
			if(ddd<=20&&ddd>0&&yy==c.get(Calendar.YEAR)) {
				System.out.println("OKK!! the trains are available for the chosen date");
				return 1;
			}
			else {
				System.out.println("Not possible to book before 20 days or 1 year.....invalid date");
				return 0;
			}
		}
		else {
			try {
				throw new TrainNotFoundException("There is no train with the given train id....Please enter a valid train id");
			}
			catch(TrainNotFoundException exc) {
				System.out.println(exc.toString());
				return 0;
			}
		}

	}
}