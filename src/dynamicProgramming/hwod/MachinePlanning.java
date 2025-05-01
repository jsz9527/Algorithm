package dynamicProgramming.hwod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//机器 配置时间 运行时间
public class MachinePlanning {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int taskGroupNum = in.nextInt();
		int[] machineNumArray = new int[taskGroupNum];
		ArrayList<Machine>[] machineListArray = new ArrayList[taskGroupNum];
		int maxLength = 0;
		for (int i = 0; i < taskGroupNum; i++) {
			machineNumArray[i] = in.nextInt();
			machineListArray[i] = new ArrayList<>();
			for (int j = 0; j < machineNumArray[i]; j++) {
				Machine machine = new Machine();
				machine.setB(in.nextInt());
				machine.setJ(in.nextInt());
				machineListArray[i].add(machine);
			}
			if (machineListArray[i].size() > maxLength) {
				maxLength = machineListArray[i].size();
			}
//			machineListArray[i].sort(
//				new Comparator<Machine>() {
//					@Override
//					public int compare(Machine o1, Machine o2) {
//						return o2.getJ() - o1.getJ();
//					}
//				}
//			);
			machineListArray[i].sort(Comparator.comparing(Machine::getJ, Comparator.reverseOrder()));
		}


		int[][] result = new int[taskGroupNum][maxLength];
		int[][] last = new int[taskGroupNum][1];
		int[][] total = new int[taskGroupNum][1];
		for (int i = 0; i < taskGroupNum; i++) {
			last[i][0] = 0;
			total[i][0] = 0;
			for (int j = 0; j < machineListArray[i].size(); j++) {
				last[i][0] = last[i][0] + machineListArray[i].get(j).getB();
				if(j == 0){
					result[i][j] = machineListArray[i].get(j).getB() + machineListArray[i].get(j).getJ();
				}else {
					result[i][j] = Math.max(result[i][j-1], last[i][0] + machineListArray[i].get(j).getJ());
				}
				total[i][0] = Math.max(total[i][0], result[i][j]);
			}
			System.out.println(total[i][0]);
		}
	}

	public static class Machine{
		int b;
		int j;

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}
	}

}
