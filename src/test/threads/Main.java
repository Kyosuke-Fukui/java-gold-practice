package test.threads;
//セミナー例題9
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
	public static void main(String... args) {
		var c = new CopyOnWriteArrayList<>(List.of("a", "b", "c", "d"));
		Runnable runnable = () -> {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
			}
			int i = 0;
			for (var s : c)
				c.set(i++, s.toUpperCase());
			System.out.print(c + " ");
		};
		Thread thread = new Thread(runnable);
		thread.start();
		for (var s : c) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			System.out.print(s + " ");
		}
	}
}