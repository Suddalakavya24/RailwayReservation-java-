package javaproj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.print.attribute.HashAttributeSet;
class railrev
{
	static int trainno;
	static byte fileno,pass;
	HashMap<Integer,ArrayList<Integer>> hm1=new HashMap<Integer,ArrayList<Integer>>();
	HashMap<Integer,ArrayList<Integer>> hm2=new HashMap<Integer,ArrayList<Integer>>();
	ArrayList<Queue> aq=new ArrayList<Queue>();
	private railrev(){
		hm1.put(1001,new ArrayList<Integer>(Collections.nCopies(0, 0)));
		hm1.put(1002,new ArrayList<Integer>(Collections.nCopies(0, 0)));
		hm1.put(1003,new ArrayList<Integer>(Collections.nCopies(0, 0)));
		hm2.put(1001,new ArrayList<Integer>(Collections.nCopies(0, 0)));
		hm2.put(1002,new ArrayList<Integer>(Collections.nCopies(0, 0)));
		hm2.put(1003,new ArrayList<Integer>(Collections.nCopies(0, 0)));
		aq.add(new PriorityQueue<Integer>());
		aq.add(new PriorityQueue<Integer>());
		aq.add(new PriorityQueue<Integer>());
		aq.add(new PriorityQueue<Integer>());
		aq.add(new PriorityQueue<Integer>());
		aq.add(new PriorityQueue<Integer>());
	}
	private static railrev ref1=null;
	public static railrev getInstance() {//singleton class as only one reference of theater is required for all the users
		 if(ref1==null) {
			 ref1=new railrev();
			 return ref1;
		 }
		 else  return ref1;
		}
	public int[] book(int trainno,int fileno,int pass) {
		 int[] arr=new int[pass];
		if(fileno==0) {
			if(hm1.containsKey(trainno)){
				int k=0,iter;
				int index=hm1.get(trainno).size();
				for(iter=index;iter<index+arr.length;iter++) {
						if(hm1.get(trainno).size()>4) {
							if(!this.aq.get(trainno-1001).isEmpty()) {
							int tempseat=(int) this.aq.get(trainno-1001).poll();
							hm1.get(trainno).set(tempseat, 1);
							arr[k]=tempseat;
							}
							else {
								System.out.println("Sorry.....insufficient number of seats....please choose another train if possible");
								break;
							}
						}
						else {
						hm1.get(trainno).add(1);
						arr[k]=iter;
						}
						k++;
				}
			}
		}
		else if(fileno==1) {
				if(hm2.containsKey(trainno)){
					int k=0,iter;
					int index=hm2.get(trainno).size();
					for(iter=index;iter<index+arr.length;iter++) {
						if(hm2.get(trainno).size()>4) {
							if(!this.aq.get(trainno-1001+3).isEmpty()) {
							int tempseat=(int) this.aq.get(trainno-1001).poll();
							hm1.get(trainno).set(tempseat, 1);
							arr[k]=tempseat;
							}
						}
							else {
							hm2.get(trainno).add(1);
							arr[k]=iter;
							}
							k++;
					}
			}
		}
		return arr;
	}
}