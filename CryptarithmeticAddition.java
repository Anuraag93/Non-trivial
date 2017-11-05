package zzzzzzzz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CryptarithmeticAddition {
	static Random r = new Random();
	static int rand;

	public static Integer randomValue(int j,HashSet<Integer> num ) {
		
		rand = r.nextInt(10);

		if (j == 0 && rand == 0) {
			return randomValue(j,num);
		}

		boolean checkExist = num.add(rand);
//		System.out.println(rand + " : " + checkExist + " : " + num.size());
		if (!(checkExist) && num.size() < 10) {
			return randomValue(j,num);

		}
		if (num.size() >= 10) {
			return -1;
		}

		return rand;

	}

	public static void displayHashMap(HashMap<Character, Integer> map) {
		for (Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		/*
		 * S E N D + M O R E == M O N E Y
		 */
		Scanner sc = new Scanner(System.in);
//		String[] ar1 = { "SEND", "MORE", "MONEY" };
		String [] ar1= new String[3];
		for (int i = 0; i < ar1.length; i++) {
			System.out.println("Enter the String at "+i+" position");
			ar1[i]=sc.next();
		}
		while (true) {
			HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
			HashSet<Integer> num = new HashSet<>();
			HashSet<Character> ch = new HashSet<>();
			for (int i = 0; i < ar1.length; i++) {
				for (int j = 0; j < ar1[i].length(); j++) {

					char alpha = ar1[i].charAt(j);

					if ((ch.add(alpha))) {
						letters.put(alpha, randomValue(j,num));

					}
				}
			}

//			displayHashMap(letters);
			// converting into number
			int[] i1 = new int[ar1.length];
			int index2 = 0;
			for (int i = 0; i < ar1.length; i++) {
				for (int j = 0; j < ar1[i].length(); j++) {
					i1[index2] = i1[index2] * 10 + letters.get(ar1[i].charAt(j));
				}
//				System.out.println("sum[" + index2 + "] = " + i1[index2]);

				index2++;
			}
			// logic
			// i1[0]+i1[1]=i1[2]
			if ((i1[0] + i1[1]) == i1[2]) {
				System.out.println("Problem Solved");
				displayHashMap(letters);
				
				System.out.println(" "+ar1[0]+"   "+i1[0]);
				System.out.println("+"+ar1[1]+"  +"+i1[1]);
				System.out.println(ar1[2]+"  "+i1[2]);
				break;
			}

			/*System.out.println("do wanna continue ?");
			if (sc.next() == "n") {
				break;
			}*/
		}
	}

}
