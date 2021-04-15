import java.util.Scanner;
class Theatre{
	void Sandhya70mm() {
	 System.out.println("--------- Sandhya theatre!------------\n");
	 System.out.println("Movie: Syra\n");
	 System.out.println("Show timings:11 AM\t2 PM\t5 PM\t8PM\n");
	 System.out.println("Price:100\n");
	}
	void INOXMaheshwariParameshwari() {
	System.out.println("----------INOXMaheshwariParameshwari-----------\n");
	System.out.println("Movie: Saho");
	System.out.println("Show timings:2 PM\t5 PM\n");
	System.out.println("Price:200\n");

	}
}
class UserInfo extends Theatre{
	String name;
	long Phnnum;
	int tickets;
	String Moviename;
	String Theatrename;
	byte shownum;
	final int Totaltheatres=2;
	final byte shows=4;
	void setname(String name) {
		this.name=name;
	}
	String getname() {
		return name;
	}
	void setphn(long phnnum) {
		this.Phnnum=phnnum;
	}
	long getphn() {
		return Phnnum;
	}
	void settheatre(String theatrename) {
		this.Theatrename=theatrename;
	}
	String gettheatrename() {
		return Theatrename;
	}
	void setshownum(byte shownum) {
		this.shownum=shownum;
	}
	byte getshoownum() {
		return shownum;
	}
	void settickets(int tickets) {
		this.tickets=tickets;
	}
	int gettickets() {
		return tickets;
	}
	
}

class Payment{float amt;
	void payment(int seats,String theatre) {
		if(theatre.contentEquals("Sandhya")) {
			 amt=seats*100;
		}
		else {
			amt=seats*200;
		}
		System.out.println("Please pay Rs."+amt);
	}
}

class ReservationinSandhya{
	Payment ref=new Payment();
	static int Totalseats1=100;
	static int Totalseats2=100;
	static int Totalseats3=100;
	static int Totalseats4=100;
	static int Totalseats;
	int array1[][]=new int[10][10];
	int array2[][]=new int[10][10];
	int array3[][]=new int[10][10];
	int array4[][]=new int[10][10];
	
	static void seatsdisplay(int[][] array) {//displaying seating arrangement
		System.out.println("---------------------------------------");
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(array[i][j]+" | ");
			}
			System.out.println("\n---------------------------------------");
		}
	} 
	
	void reserveseat(int show,int seatsrequested) {
	if(show==1) Totalseats=Totalseats1;
	else if(show==2) Totalseats=Totalseats2;
	else if(show==3) Totalseats=Totalseats3;
	else if(show==4) Totalseats=Totalseats4;
		
	Scanner scan=new Scanner(System.in);
	String name=Thread.currentThread().getName();
	System.out.println("\n"+name+" - Proceed to book your seats in Sandhya Theatre"+" show-"+show);
	System.out.println("Available seats: "+Totalseats+"\n"+"Requested seats: "+seatsrequested);
	System.out.println("Choose your preferred seat numbers(1-100)\n");
	
	if(show==1) seatsdisplay(array1);
	else if(show==2) seatsdisplay(array2);
	else if(show==3) seatsdisplay(array3);
	else if(show==4) seatsdisplay(array4);
	
	boolean reserved=false;
	int counter1=0,counter2=0,counter3=0,counter4=0;
	for(int i=0;i<seatsrequested;i++) {
		int p=scan.nextInt();
		if(show==1) {
		       if(array1[p/10][p%10-1]!=1)
		       array1[p/10][p%10-1]=1;
		       else
		        {reserved=true;
		         counter1=counter1+1;
	            }           
		             }
	   else if(show==2) {
			if(array2[p/10][p%10-1]!=1)
				array2[p/10][p%10-1]=1;
			else
			{reserved=true;
					counter2=counter2+1;
			}
		}
	   else if(show==3) {
			if(array3[p/10][p%10-1]!=1)
				array3[p/10][p%10-1]=1;
			else
			{reserved=true;
					counter3=counter3+1;
			}
		}
	   else if(show==4) {
			if(array4[p/10][p%10-1]!=1)
				array4[p/10][p%10-1]=1;
			else
			{reserved=true;
					counter4=counter4+1;
			}
		}
	}
	
	if(show==1) seatsdisplay(array1);
	else if(show==2)seatsdisplay(array2);
	else if(show==3)seatsdisplay(array3);
	else if(show==4)seatsdisplay(array4);
	if(Totalseats>=seatsrequested) {
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		if(show==1) {
		System.out.println(seatsrequested-counter1+" seats reserved successfully!!");
		if(counter1>0) 
			{System.out.println(counter1+" seats denied as already booked!\n");
		               }
		Totalseats1=Totalseats1-seatsrequested;
		ref.payment(seatsrequested-counter1, "Sandhya");
	     }
		else if(show==2) {
			System.out.println(seatsrequested-counter2+" seats reserved successfully!!");
			if(counter2>0) {
				System.out.println(counter2+" seats denied as already booked!\n");
			}
			Totalseats2=Totalseats2-seatsrequested;	
			ref.payment(seatsrequested-counter2, "Sandhya");
		}
		else if(show==3) {
			System.out.println(seatsrequested-counter3+" seats reserved successfully!!");
			if(counter3>0) {
				System.out.println(counter3+" seats denied as already booked!\n");
			}
			Totalseats3=Totalseats3-seatsrequested;	
			ref.payment(seatsrequested-counter3, "Sandhya");
		}
		else if(show==4) {
			System.out.println(seatsrequested-counter4+" seats reserved successfully!!");
			if(counter4>0) {
				System.out.println(counter4+" seats denied as already booked!\n");
			}
			Totalseats4=Totalseats4-seatsrequested;
			ref.payment(seatsrequested-counter4, "Sandhya");
		}
		
		}
	else {
		System.out.println("Sorry!Requested seats are not available\n");
	}
	}
}
class Reservationininox{
	Payment ref=new Payment();
	static int Totalseats1=100;
	static int Totalseats2=100;
	static int Totalseats;
	int array1[][]=new int[10][10];
	int array2[][]=new int[10][10];
	static void seatsdisplay(int[][] array) {
		System.out.println("---------------------------------------");
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(array[i][j]+" | ");
			}
			System.out.println("\n---------------------------------------");
		}
	}
	synchronized void reserveseat(int show,int seatsrequested) {
	if (show==1) Totalseats=Totalseats1;
	else if(show==2) Totalseats=Totalseats2;
	Scanner scan=new Scanner(System.in);
	String name=Thread.currentThread().getName();
	System.out.println(name+" - Proceed to book your seats in Inox\n");
	System.out.println("Available seats: "+Totalseats+"\n"+"Requested seats: "+seatsrequested);
	System.out.println("Choose your preferred seat numbers(1-100)\n");
	if(show==1) seatsdisplay(array1);
	else if(show==2) seatsdisplay(array2);
	boolean reserved=false;
	int counter1=0,counter2=0;
	for(int i=0;i<seatsrequested;i++) {
		int p=scan.nextInt();
		if(show==1) {
		       if(array1[p/10][p%10-1]!=1)
		       array1[p/10][p%10-1]=1;
		       else
		        {reserved=true;
		         counter1=counter1+1;
	            }           
		             }
	   else if(show==2) {
			if(array2[p/10][p%10-1]!=1)
				array2[p/10][p%10-1]=1;
			else
			{reserved=true;
					counter2=counter2+1;
			}
		}}
	  if(show==1) seatsdisplay(array1);
	  else if(show==2)seatsdisplay(array2);
      if(Totalseats>=seatsrequested) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			if(show==1) {
			System.out.println(seatsrequested-counter1+" seats reserved successfully!!");
			if(counter1>0) 
				{System.out.println(counter1+" seats denied as already booked!\n");
			               }
			Totalseats1=Totalseats1-seatsrequested;
			ref.payment(seatsrequested-counter1, "Sandhya");
		     }
			else if(show==2) {
				System.out.println(seatsrequested-counter2+" seats reserved successfully!!");
				if(counter2>0) {
					System.out.println(counter2+" seats denied as already booked!\n");
				}
				Totalseats2=Totalseats2-seatsrequested;	
				ref.payment(seatsrequested-counter2, "Sandhya");
			}
		}
		
	else {
		System.out.println("Sorry!Requested seats are not available\n");
	     }
	}
}


class Person extends Thread{
	ReservationinSandhya ref1;
	Reservationininox ref2;
	String theatrename;
	int seatsrequested;
	int show;
	public Person(int show,String theatrename,ReservationinSandhya ref1,int tickets) {
		this.ref1=ref1;
		seatsrequested=tickets;
		this.theatrename=theatrename;
		this.show=show;
	}
	public Person(int show,String theatrename,Reservationininox ref2,int tickets) {
		this.ref2=ref2;
		seatsrequested=tickets;
		this.theatrename=theatrename;
		this.show=show;
	}
	public void run() {
		if(theatrename.contentEquals("Sandhya")) {
			ref1.reserveseat(show,seatsrequested);
		}
		else {
			ref2.reserveseat(show,seatsrequested);
		}
	}

}
public class BookMyShow{
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
		UserInfo person[]=new UserInfo[100];
		ReservationinSandhya ref1=new ReservationinSandhya();
		Reservationininox ref2=new Reservationininox();
		//userinfo
		System.out.println("-----Welcome to BOOK MY SHOW-----\n");
		for(int i=0;i<2;i++) {
		person[i]=new UserInfo();
		 System.out.println("Please enter your Name:");
		 String name=scan.next();
		 person[i].setname(name);
		 System.out.println("Please enter your Phn Num:");
		 long phn=scan.nextLong();
		 person[i].setphn(phn);
		 System.out.println("Movies streaming in Theatres:");
		 person[i].Sandhya70mm();
		 person[i].INOXMaheshwariParameshwari();
		 System.out.println("Select the theatre:");
		 String theatrename=scan.next();
		 person[i].settheatre(theatrename);
		 System.out.println("Select show time:");
		 byte show=scan.nextByte();
		 person[i].setshownum(show);
		 System.out.println("Enter the number of tickets:");
		 int tickets=scan.nextInt();
		 person[i].settickets(tickets);
		}
		 for(int j=0;j<2;j++) {
			 if(person[j].Theatrename.contentEquals("Sandhya")) {
				 Person thread=new Person(person[j].shownum,person[j].Theatrename,ref1,person[j].tickets);
				 thread.setName(person[j].name);
				 thread.start();//thread1 got started
			 }
			 else {
				 Person thread=new Person(person[j].shownum,person[j].Theatrename,ref2,person[j].tickets);
				 try {
					Thread.currentThread().sleep(8000);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				 thread.setName(person[j].name);
			     thread.start();//thread2 got started
			 }
		 }
		 
	}
}
		

        

	


