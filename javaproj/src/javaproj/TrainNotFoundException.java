package javaproj;


public class TrainNotFoundException extends Exception{
	String exception;
	public TrainNotFoundException(String exception) {
		// TODO Auto-generated constructor stub
		this.exception=exception;
	}
	public String toString() {
		return exception;
	}
}

