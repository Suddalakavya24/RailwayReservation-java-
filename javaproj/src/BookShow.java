import java.util.Scanner;
class Theatres{
	void Sandhya70mm() {
	 System.out.println("\n--------- Sandhya theatre!------------\n");
	 System.out.println("Movie: Syra\n");
	 System.out.println("Show timings:11 AM\t2 PM\t5 PM\t8PM\n");
	 System.out.println("Price:100\n");
	}
	void INOXMaheshwariParameshwari() {
	System.out.println("----------INOXMaheshwariParameshwari-----------\n");
	System.out.println("Movie: Saho");
	System.out.println("Show timings:2 PM\t5 PM\n");
	System.out.println("Price:200\n");}
}
class info extends Theatres{
	String name;
	long Phnnum;
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
	}
class Seating{
	 private static Seating ref1=null;
	 private Seating(){}
	 public static Seating getInstance() {//singleton class as only one reference of theater is required for all the users
		 if(ref1==null) {
			 ref1=new Seating();
			 return ref1;
		 }
		 else  return ref1;
		}
    String Theatre;
    byte show;
    int a[];
	 int array1[][]=new int[5][100];//arrays to display seating arrangement
     int array2[][]=new int[5][100];
     int array[][]=new int[5][100];
	public void Seatingpos(String theatrename,byte show,int[] a){
		Theatre=theatrename;
		this.show=show;
		this.a=a;
		if(theatrename.contentEquals("Sandhya")) array=array1;
		else array=array2;//assignment of array based on theatre number
		}
	public void displayseats(String theatrename,int show) {
		Scanner scan=new Scanner(System.in);//displaying seats array[show number][seat number]
		if(theatrename.contentEquals("Sandhya")) {
			System.out.print("---------------------------------------\n");
			for(int i=0;i<100;i++) {
				    System.out.print(array1[show][i]+" | ");
					if((i+1)%10==0) System.out.print("\n---------------------------------------\n");
				}}
		else {
			for(int i=0;i<100;i++) {
			    System.out.print(array2[show][i]+" ");
				if((i+1)%10==0) System.out.println("\n");
			}}
	}
	synchronized boolean check() {int counter=0;
    for(int i:a) {//checking whether seat is vacant or not
    	if (array[show][i]!=0) counter++;
    	else array[show][i]=1;//if seat is vacant make it 1 and return true
    	}
    if(counter!=0) return false;
    else return true;
    }
}
class User implements Runnable{
	Scanner scan=new Scanner(System.in);
	String theatrename;
	int seatsrequested;
	int show;
	public User() {
	 }
	synchronized public void run() {
		 info pref=new info();
		 //taking userinfo
		 System.out.println("\n-----Welcome to BOOK MY SHOW-----\n");
	     System.out.println("Movies streaming in Theatres:");
		 pref.Sandhya70mm();
		 pref.INOXMaheshwariParameshwari();
		 TakeUserinfo info=new TakeUserinfo();
		 System.out.println("Select the theatre:(Sandhya/Inox)");
		 String theatrename=scan.next();
		
		 System.out.println("Select show time:(1/2/3/4)");
		 byte show=scan.nextByte();
		 System.out.println("Enter the number of tickets:");
		 int tickets=scan.nextInt();
		 Seating ref=Seating.getInstance();
		 ref.displayseats(theatrename,show);
		 System.out.println("Please enter the ticket numbers(0-100)\n");
		 int a[]=new int[tickets];
		 for(int i=0;i<tickets;i++) {
			 a[i]=scan.nextInt();
		 }
		ref.Seatingpos(theatrename, show, a);
		boolean availability= ref.check();//true if there is vacancy or returns false
		if(!availability) { System.out.println("Booking is denied!Try again!\n");}
		else {System.out.println("Booked successfully!\n");
		System.out.println("Please enter your details to proceed for payment\n");
		  info.takeinfo(); 
		  info.makepayment(theatrename, tickets);
		  System.out.println("Thankyou:-)))");}
			}
}
class TakeUserinfo {
	void takeinfo() {
		Scanner scan=new Scanner(System.in);
	     info person=new info();
		 System.out.println("Please enter your Name:");
		 String name=scan.next();
		 person.setname(name);
		 System.out.println("Please enter your Phn Num:");
		 long phn=scan.nextLong();
		 person.setphn(phn);
	}
	void makepayment(String theatrename,int tickets) {float amt;
		if(theatrename.contentEquals("Sandhya")) amt=tickets*100;
		else amt=tickets*200;
		System.out.println("Please pay Rs."+amt);
	}
	}
public class BookShow {
public static void main(String[] args) {
    int i=0;
    User ref=new User();
    while(i<3) {
	 Thread t=new Thread(ref);
	 t.start();//thread got started,run method in User class starts
	 i++;
    }}
}
