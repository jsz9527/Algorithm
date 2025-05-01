package string;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ92_MaximunNumberSubString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String sourceString = scanner.nextLine();
			int max = 0;
			int temp = 0;
			ArrayList<String> list = new ArrayList<>();
			String tempString = "";
			//确保最后一次循环为 非数字
			sourceString += "a";
			char[] chars = sourceString.toCharArray();
			for (char c : chars) {
				if ("0123456789".indexOf(c + "") == -1) {
					if (temp > max) {
						max = temp;
						list.clear();
						list.add(tempString);
					} else if (temp == max) {
						list.add(tempString);
					}
					temp = 0;
					tempString = "";
				} else {
					temp += 1;
					tempString += c;
				}
			}
			String result = "";
			for (String a : list) {
				result += a;
			}
			System.out.println(result + "," + max);

		}
	}
}
