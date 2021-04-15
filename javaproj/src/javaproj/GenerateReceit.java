package javaproj;

import java.io.*;
import java.util.Properties;
import java.util.*;
import javax.sound.midi.MetaMessage;

import com.sun.jdi.connect.Transport;

public class GenerateReceit {
	void receit(byte age[],String[] pname,String[] pgen,int passengers,float fee,String cname,int seats[],int tno,int fno,String dat) throws IOException, ClassNotFoundException {
		Calendar c=Calendar.getInstance();
		String route;
		System.out.println("\t\tRailay Reservation Payment");
		System.out.println("\t*No payment for the passengers under age 5*");
		System.out.println("========================================================");
		System.out.println("Name:"+cname+"\tNo.of passengers:"+age.length+"\tDate:"+c.get(Calendar.DATE)+"-"+c.get(Calendar.MONTH)
		+"-"+c.get(Calendar.YEAR));
		System.out.println("NAME\tAGE\tGENDER\tSEAT NO.");
		for(int iter=0;iter<pname.length;iter++) {
			System.out.println(pname[iter]+"\t"+age[iter]+"\t"+pgen[iter]+"\t"+seats[iter]);
		}
		System.out.println("========================================================");
		System.out.println("\t\tTotal Amount:"+fee);
		FileInputStream fin=new FileInputStream("E:/TrainsInfo.txt");
		ObjectInputStream ois=new ObjectInputStream(fin);
		int iter=0;
		TrainFiles t=null;
		while(iter<=fno) {
			t=(TrainFiles)(ois.readObject());
			iter++;
		}
		if(t.hm.containsKey(tno)) {
			if(fno==0) {
				route="Hyderabad-Mumbai";
				System.out.println(route+"\t"+t.hm.get(tno)[0]+"\tDEP:"+t.hm.get(tno)[1]+" ARR:"+t.hm.get(tno)[2]+" "+dat);
			}
			else if(fno==1) {
				route="Mysore-Delhi";
				System.out.println(route+"\t"+t.hm.get(tno)[0]+"\tDEP:"+t.hm.get(tno)[1]+" ARR:"+t.hm.get(tno)[2]+" "+dat);
			}
		}
		System.out.println("\t\tHAVE A SAFE TRIP:)");
	}
}

