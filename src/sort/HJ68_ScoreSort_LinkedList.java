package sort;

import java.util.LinkedList;
import java.util.Scanner;

//思路：使用链表排序，找出最小值，移到链表最前面，不改变其他元素顺序

//输入姓名、成绩，按成绩排序
//因为可能会有多个名字或者成绩相同的学生，所以用 map 或者 set 接口都不太合适
//成绩相同，要保证按 输入顺序排序
public class HJ68_ScoreSort_LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//录入的学生人数
        int type = sc.nextInt();//排列方式
		LinkedList<NameAndScore> linkedList = new LinkedList<NameAndScore>();
        for (int i = 0; i < n; i++) {
			NameAndScore nameAndScores = new NameAndScore();
			nameAndScores.setName( sc.next() );//录入学生姓名
			nameAndScores.setScore( sc.nextInt() );//录入与每个学生名字相对应的成绩
			linkedList.add(nameAndScores);
        }

		int tempScore = 0;
		int tempIndex = 0;
		for ( int i = 0 ; i < n - 1 ; i++){
			tempScore = linkedList.get(i).getScore();
			tempIndex = i;
			for ( int j = i+1 ; j < n ; j++) {
				if (type == 1) {//升序
					if (linkedList.get(j).getScore() < tempScore) {
						tempScore = linkedList.get(j).getScore();
						tempIndex = j;
					}
				} else {//降序
					if (linkedList.get(j).getScore() > tempScore) {
						tempScore = linkedList.get(j).getScore();
						tempIndex = j;
					}
				}
			}
			NameAndScore tempNameAndScore = linkedList.get(tempIndex);
			linkedList.remove(tempIndex);
			linkedList.add(i, tempNameAndScore);
		}

		//输出
		for(NameAndScore nameAndScore : linkedList){
			System.out.println(nameAndScore.getName() + " " + nameAndScore.getScore());
		}
    }


	public static class NameAndScore{
		String name;
		int score;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
	}

}