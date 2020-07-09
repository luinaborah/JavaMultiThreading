package playground;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;

	public Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Strarted:: " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed:: " + id);

	}
}

public class ThreadPoolExample1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("all tasks are submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("all tasks are completed");

	}

}
