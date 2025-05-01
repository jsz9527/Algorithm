package multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Third1 {
	static int total;

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		total = add();
		long end = System.currentTimeMillis();
		System.out.println(total);
		System.out.println( (end - begin) + "ms");
	}

	static int add(){
		try {
			List<CompletableFuture<Integer>> list = new ArrayList<>();
			list.add(
				CompletableFuture.supplyAsync(
					() -> AService1.get()
				)
			);
			list.add(
				CompletableFuture.supplyAsync(
					() -> BService1.get()
				)
			);
			list.add(
				CompletableFuture.supplyAsync(
					() -> CService1.get()
				)
			);
			//并行执行
			List<Integer> list1 = list.stream().map(CompletableFuture :: join).collect(Collectors.toList());
			for (Integer result : list1){
				total = total + result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}

class AService1{
	static int get(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}
}

class BService1{
	static int get(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 2;
	}
}

class CService1{
	static int get(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 3;
	}
}
