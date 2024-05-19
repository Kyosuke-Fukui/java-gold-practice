package test.threads;

class MyThread extends Thread {
	public boolean running = true;
	public void run() {
		while(running) {
			System.out.print("*");
		}
		System.out.println("runメソッドを終了します");
	}
}

public class ThreadStopExample {
	public static void main(String[] args) {
		MyThread t = new MyThread();		
		t.start();
		
		try {
			Thread.sleep(5);
		} catch(InterruptedException e) {
			System.out.println(e);
		}
		
		t.running = false;
	}
}
