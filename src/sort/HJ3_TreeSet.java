package sort;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author shkstart
 * @create 2023-06-01 13:21
 */
public class HJ3_TreeSet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		TreeSet<Integer> treeSet = new TreeSet<>(
			(o1, o2) -> {
				return (int)o1 - (int)o2 ;
			}
		);
		for (int i=0;i<N;i++){
			Integer a = new Integer(in.nextInt());
			treeSet.add(a);
		}

		for (Integer a : treeSet){
			System.out.println(a);
		}

	}
}