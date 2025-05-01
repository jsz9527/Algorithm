package sort;

import java.util.Arrays;
import java.util.Scanner;

//思路：先对成绩排序，再按输入顺序，输出姓名

//输入姓名、成绩，按成绩排序
//因为可能会有多个名字或者成绩相同的学生，所以用 map 或者 set 接口都不太合适
//成绩相同，要保证按 输入顺序排序
public class HJ68_ScoreSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//录入的学生人数
        int m = sc.nextInt();//排列方式
        String [] str = new String[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();//录入学生姓名
            arr[i] = sc.nextInt();//录入与每个学生名字相对应的成绩
        }
        int[] arrClone = arr.clone();//复制一次学生成绩

		//将复制后的成绩按升序排列
        Arrays.sort(arrClone);

        if (m==1) {//题目要求升序时:
            for (int i = 0; i < n; i++) {//双重for循环,外循环是复制后的成绩,也就是升序排序的成绩
				if (i!=0 && arrClone[i]==arrClone[i-1]){//当有多个成绩一样时,跳过
					continue;
				}
				for (int j = 0; j < n; j++) {//内循环是原先输入的成绩,
                    if (arrClone[i] == arr[j]) {//升序排列后的成绩数组与原成绩数组相一致时
                        System.out.println(str[j] + " " + arrClone[i]);//输出该成绩和该学生的名字
                    }
                }
            }
        }else {//题目要求降序时:
            for (int i = n-1; i >=0; i--) {//降序同上
				if (i!=n-1 && arrClone[i]==arrClone[i+1]){
					continue;
				}
				for (int j = 0; j < n; j++) {
                    if (arrClone[i]==arr[j]){
                        System.out.println(str[j]+" "+arrClone[i]);
                    }
                }
            }
        }

    }

}