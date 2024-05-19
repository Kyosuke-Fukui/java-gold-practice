package test.threads;

public class Starvation extends Thread {
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " - execution starts");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "- execution completes");
	}

	public static void main(String... args) throws InterruptedException {
		Starvation thread1 = new Starvation();
		thread1.setPriority(Thread.MAX_PRIORITY);
		Starvation thread2 = new Starvation();
		thread2.setPriority(Thread.MAX_PRIORITY);
		Starvation thread3 = new Starvation();
		thread3.setPriority(Thread.NORM_PRIORITY);
		Starvation thread4 = new Starvation();
		thread4.setPriority(Thread.NORM_PRIORITY);
		Starvation thread5 = new Starvation();
		thread5.setPriority(Thread.MIN_PRIORITY);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

}