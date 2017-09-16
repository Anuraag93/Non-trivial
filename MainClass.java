package zzzzzzzz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MainClass {

//	static int[] a=new int[11];

	static Random r=new Random();

	public static int random10(HashSet<Integer> h1){
		int count;
		while (true) {
			Integer num=r.nextInt(10);
			if(h1.contains(num)==false) {
				count=num;
				h1.add(num);
				break;
			}

		}
		/*if(h1.contains(num));
		{

			random10();
		}
		h1.add(num);
*/

		System.out.print(count+", ");


		return count;

	}

	public static void displayLink(Map link) {
		//get a set of the entries
				Set set = link.entrySet();

				//get an iterator
				Iterator i=set.iterator();

				//display
				while(i.hasNext()) {
					Map.Entry me = (Map.Entry)i.next();
					System.out.print(me.getKey() +" : ");
					System.out.println(me.getValue());
				}
				System.out.println();

	}

	public static LinkedHashMap setRandomValues(String [] ar) {
		HashSet<Integer> h1= new HashSet();
		LinkedHashMap<Character, Integer> link= new LinkedHashMap<>();


		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length(); j++) {
				if(link.get(ar[i].charAt(j))==null)
				{
					link.put(ar[i].charAt(j), random10(h1));

				}
			}
		}

		return link;
	}
	public static void main(String[] args) {
		/* 	S E N D
	    +  	M O R E
	   	 ------------
	   	  M O N E Y
	    ------------*/
		Scanner sc = new Scanner(System.in);


		String [] ar= {"SEND","MORE","MONEY"};
		/*String [] ar= new String[3];
		for (int i = 0; i < ar.length; i++) {
			System.out.println("Enter the String at "+i+" position");
			ar[i]=sc.next();
		}*/

		while(true) {

			//setting the values
			LinkedHashMap<Character, Integer> link=setRandomValues(ar);
			System.out.println();

			//display
			displayLink(link);

			int [] i1=new int[ar.length];

			//value initialization
			for (int i = 0; i < ar.length; i++) {

				int sum = link.get(ar[i].charAt(0));
				for (int j = 0; j < ar[i].length()-1; j++) {

					sum = sum * 10 + link.get(ar[i].charAt(j+1));
				}
				i1[i]=sum;
				System.out.println("sum["+i+"] = "+i1[i]);

			}

			//logic
			//i1[0]+i1[1]=i1[2]
			if((i1[0]+i1[1])==i1[2])
			{
				System.out.println("Problem Solved");

				System.out.println("do wanna continue ?");
				if(sc.next()=="no")
				{
					break;
				}
			}
		}
	}
}
