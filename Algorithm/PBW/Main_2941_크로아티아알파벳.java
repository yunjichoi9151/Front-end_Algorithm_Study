package algo;

import java.util.Scanner;

public class Main_2941_크로아티아알파벳 {
	// boj Silver5
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String croa [] = new String [] {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		for (int i = 0; i < croa.length; i++) {
			str = str.replace(croa[i], "a");
		}
//		System.out.println(str);
		System.out.println(str.length());
	}
}
