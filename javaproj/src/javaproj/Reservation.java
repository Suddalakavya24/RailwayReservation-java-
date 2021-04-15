package javaproj;

import java.util.*;
import java.io.*;
class TrainFiles implements Serializable{
	HashMap<Integer ,String[]> hm=new HashMap<Integer,String[]>();

	void Trainslist(String[][] s1) throws IOException {
		ArrayList<String[]> str=new ArrayList<String[]>();
		Date d1=new Date();
		this.hm.put(1001,s1[0]);
		this.hm.put(1002, s1[1]);
		this.hm.put(1003, s1[2]);
		File f=new File("E:/TrainsList");
		int length=f.list().length;
		FileWriter fr=new FileWriter("E:/TrainsList/railway"+(length)+".txt");
		BufferedWriter bw=new BufferedWriter(fr);
		bw.write("TrainNo TrainName  DepartureTime  ArrivalTime");
		bw.newLine();
		bw.write("----------------------------------------------");
		bw.newLine();
		for(Map.Entry mapElement:hm.entrySet()) {
			String temp="";
			temp+=(Integer.toString((int) mapElement.getKey()))+"   ";
			String[] te=(String[]) mapElement.getValue();
			for(int i=0;i<te.length;i++) {
				temp+=te[i]+"\t";
			}
			bw.write(temp);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
public class Reservation {
	public static void main(String args[]) throws IOException, InterruptedException, ClassNotFoundException {
		String[][] s1= {{"MumbaiExpress","19:20","8:00"},{"DevagiriExpress","12:30","4:15"},{"ShivajiExpress","18:30","9:15"}};
		TrainFiles tf=new TrainFiles();
		tf.Trainslist(s1);
		String[][] s2= {{"NDLSExpress","11:20","5:00"},{"DurontoExpress","17:30","7:30"},{"RajdhaniExpress","15:30","7:15"}};
		TrainFiles tf1=new TrainFiles(); 
		tf1.Trainslist(s2); 
		FileOutputStream fout=new FileOutputStream("E:/TrainsInfo.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fout);
		oos.writeObject(tf);
		oos.writeObject(tf1);
		Thread t;
		int iter=0;
		while(iter<8) {
			t=new Thread(new Runnable() {public void run() {
				LoginSignup user=null;
				try {
					user=new LoginSignup();
					try {
						user.Signup();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}});
			t.start();
			t.join();
			iter++;
		}
	}
}