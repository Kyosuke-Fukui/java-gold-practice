package test.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test {
	private int num = 100;

	public int addTest() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return this.num++;
	}

	public int subTest() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return this.num--;
	}

	public int getTest() {
		return this.num;
	}
}

public class DeadLock {
	public static void main(String[] args) {
		Test test1 = new Test();
		Test test2 = new Test();

		ExecutorService exec = Executors.newFixedThreadPool(2);
		// スレッド1
		exec.submit(() -> {
			// 処理完了までtest1の操作はスレッド1のみ
			synchronized (test1) {
				System.out.println("sbmit1[test1=" + test1.getTest() + "]");
				test1.addTest(); // 加算
				System.out.println("sbmit1[test1=" + test1.getTest() + "]");
				// スレッド2でtest2がロックされているので実行できない
				synchronized (test2) {
					System.out.println("sbmit1[test2=" + test2.getTest() + "]");
					test2.subTest(); // 減算
					System.out.println("sbmit1[test2=" + test2.getTest() + "]");
				}
			}
			// 処理が完了できない
		});
//        // スレッド2
//        exec.submit(()-> {
//        	//処理完了までtest2の操作はスレッド2のみ
//            synchronized (test2){
//                System.out.println("sbmit2[test2="+test2.getTest() + "]");
//                test2.addTest();//加算
//                System.out.println("sbmit2[test2="+test2.getTest() + "]");
//                //スレッド1でtest1がロックされているので実行できない
//                synchronized (test1){
//                    System.out.println("sbmit2[test1="+test1.getTest() + "]");
//                    test1.subTest();//減算
//                    System.out.println("sbmit2[test1="+test1.getTest() + "]");
//                }
//            }
//          //処理が完了できない
//        });

		// スレッド2（デッドロック解消）
		exec.submit(() -> {
			synchronized (test1) {
				System.out.println("sbmit2[test1=" + test1.getTest() + "]");
				test1.subTest();// 減算
				System.out.println("sbmit2[test1=" + test1.getTest() + "]");
				synchronized (test2) {
					System.out.println("sbmit2[test2=" + test2.getTest() + "]");
					test2.addTest();// 加算
					System.out.println("sbmit2[test2=" + test2.getTest() + "]");
				}
			}
		});
	}
}