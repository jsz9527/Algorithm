package multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class Third {
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
			CountDownLatch countDownLatch = new CountDownLatch(3);
			FutureTask<Integer> futureTask1 = new FutureTask<>(
				() -> {
					int i = AService.get();
					countDownLatch.countDown();
					return i;
				}
			);
			FutureTask<Integer> futureTask2 = new FutureTask<>(
				() -> {
					int i = BService.get();
					countDownLatch.countDown();
					return i;
				}
			);
			FutureTask<Integer> futureTask3 = new FutureTask<>(
				() -> {
					int i = CService.get();
					countDownLatch.countDown();
					return i;
				}
			);
			new Thread(futureTask1).start();
			new Thread(futureTask2).start();
			new Thread(futureTask3).start();
			countDownLatch.await();
			total = futureTask1.get() + futureTask2.get() + futureTask3.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}

class AService{
	static int get(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}
}

class BService{
	static int get(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 2;
	}
}

class CService{
	static int get(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 3;
	}
}
