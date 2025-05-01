package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//2进制、10进制、16进制相互转换
public class HJ30_Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1  = sc.nextLine();
        String str = str1.replaceAll(" ", "");
        String[] array = str.split("");

        String[] sortArray = paixu(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortArray.length; i++) {
            // ->10->2->10->16
            if (sortArray[i].matches("[0-9]")) {
                StringBuilder sbBin = new StringBuilder(Integer.toBinaryString(Integer.parseInt(sortArray[i])));
                int len = sbBin.length();
                if (len < 4) {
                    StringBuilder sb0 = new StringBuilder();
                    for (int j = 0; j < 4-len; j++) {
                        sb0.append(0);
                    }
                    sbBin = sb0.append(sbBin);
                }
                int tenNum = Integer.parseInt(sbBin.reverse().toString(), 2);
                sb.append(Integer.toHexString(tenNum).toUpperCase());
            } else if (sortArray[i].matches("[a-fA-F]")){
                int tenNum = Integer.parseInt(sortArray[i], 16);
                StringBuilder sbBin = new StringBuilder(Integer.toBinaryString(tenNum));
                int tenNum2 = Integer.parseInt(sbBin.reverse().toString(), 2);
                sb.append(Integer.toHexString(tenNum2).toUpperCase());
            } else {
                sb.append(sortArray[i]);
            }
        }
        System.out.println(sb.toString());
        }
    }

    public static String[] paixu(String[] array) {
        List<String> lstO = new ArrayList<>();
        List<String> lstJ = new ArrayList<>();
        for (int i = 0; i< array.length; i++) {
            if ((i+1)%2 == 0) {
                lstO.add(array[i]);
            } else {
                lstJ.add(array[i]);
            }
        }
        List<String> newLstO = lstO.stream().sorted().collect(Collectors.toList());
        List<String> newLstJ = lstJ.stream().sorted().collect(Collectors.toList());
        for (int i = newLstO.size()-1; i >=0; i--) {
            if (i+1 >= newLstJ.size()) {
                newLstJ.add(newLstO.get(i));
            } else {
                newLstJ.add(i+1, newLstO.get(i));
            }
        }
        return String.join("", newLstJ).split("");
    }
}
