class Seat{
	boolean selected1=false;
	boolean selected2=false;
	boolean selected3=false;
	boolean selected4=false;
	boolean selected5=false;
	void Seat1(){
		try {
		if(selected1)
		{Thread.currentThread().interrupt();}
		}
		catch(Exception e) {
			System.out.println("Booking of seat1 denied!\n");
		}
		
		System.out.println("Seat 1 is booked!");
		selected1=true;

	}
	void Seat2() {
		if(!selected2) {
			System.out.println("Seat 2 is booked!");
			selected2=true;
		}
	}
	void Seat3() {
		if(!selected3) {
			System.out.println("Seat 3 is booked!");
			selected3=true;
		}
	}
	void Seat4() {
		if(!selected4) {
			System.out.println("Seat 4 is booked!");
			selected4=true;
		}
	}
	void Seat5() {
		if(!selected5) {
			System.out.println("Seat 5 is booked!");
			selected5=true;
		}
	}
}
public class MovieBooking {
 public static void main(String[] args) {
	

	}

}
