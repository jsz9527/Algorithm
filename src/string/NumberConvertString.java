package string;


import java.util.Scanner;

public class NumberConvertString {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 数字转换为字符串
     * @param intValue int整型 需要转换的数字
     * @return string字符串
     */
    public String numToString (int intValue) {
		String result = "";
		if(intValue >= 0) {
			int a = intValue / 36;
			int b = intValue % 36;
			if (b <= 9) {
				result += (a * 10 + b);
			} else {
				result += (char) (b - 9 + 64);
			}
			return result;
		}else {
			int intValue2 = (0 - intValue) - 1;
			int c = intValue2 / 36;
			int d = intValue2 % 36;

			if (d <= 25) {
				result += (char) (d + 65);
			} else {
				result +=  (0-(c * 10 + (d-25)));
			}
			return result;
		}
    }

	public static void main(String[] args) {
		char A = 'A';
		int result = A;
		System.out.println(result);

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			int intValue = scanner.nextInt();
			System.out.println(new NumberConvertString().numToString(intValue));
		}
	}
}