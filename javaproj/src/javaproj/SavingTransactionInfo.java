package javaproj;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.LongStream;
public class SavingTransactionInfo {
	HashMap<Integer,List<Object>> hm=new HashMap<Integer,List<Object>>();
	private static SavingTransactionInfo ref=null;
	private SavingTransactionInfo() {};
	public static SavingTransactionInfo getInstance() {
		if(ref==null) {
			ref=new SavingTransactionInfo();
			return ref;
		}
		else
			return ref;	
	}
	void saveTransInfo(int pnrno,List<Object> lst,int tno,int fno) {
		if(hm.containsKey(pnrno)) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Are you sure that you really want to cancel?");
			String confirm=scan.next();
			if(confirm.equals("Yes")) {
				this.cancel(pnrno, tno, fno);
				System.out.println("The tickets of the user with pnr no "+pnrno+" are successfully cancelled....Please pay the cancellation charges asap.");
			}
		}
		else {
			hm.put(pnrno, lst);
		}
	}
	void cancel(int pnrno,int trainno,int fileno) {
		ArrayList<Object> temparr=(ArrayList<Object>) hm.get(pnrno);
		int[] arr=new int[(int) temparr.get(0)];
		arr=(int[]) temparr.get(2);
		railrev obj=railrev.getInstance();
		if(fileno==0) {
			for(int var:arr) {
				obj.hm1.get(trainno).set(var, 0);
				obj.aq.get(trainno-1001).add(var);
			}
			hm.remove(pnrno);
		}
		else if(fileno==1) {
			for(int var:arr) {
				obj.hm2.get(trainno).set(var, 0);
				obj.aq.get(trainno-1001+3).add(var);
			}
			hm.remove(pnrno);
		}
	}
}
