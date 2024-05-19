package test.threads;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//例題18
public class SampleBarrier {

	public static void main(String[] args) {
		final List<String> list = new CopyOnWriteArrayList<>();
		final AtomicInteger num = new AtomicInteger(0);
		final CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println(list));

		Runnable r = () -> {
			try {
				Thread.sleep(100 * num.incrementAndGet());
				list.add("x");
				barrier.await(10, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println("Exception");
			}
		};
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
	}

}
