package test.threads;

//3-10
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Single {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		ExecutorService exec2 = Executors.newSingleThreadExecutor(); //1つのスレッド
//		ExecutorService exec2 = Executors.newFixedThreadPool(3); //複数（固定数）のスレッドを使いまわす
//		ExecutorService exec2 = Executors.newCashedThreadPool(); //複数のスレッドを使いまわす（60秒で使われていない分は消える）
		
		
		
		// 戻り値がない場合、Runnableインターフェース
		exec2.submit(() -> {
			System.out.println("タスク2完了");
			System.out.println(Thread.currentThread().getId());
		});
//		Callable<Boolean> task = new Callable<Boolean>() {
//			@Override
//			public Boolean call() {
//				return new Random().nextInt() % 2 == 0;
//			}
//		};
		/*
		 * Futureインターフェースを使うと、get()によって mainメソッドを実行するスレッドから
		 * 新しく作ったスレッドの結果を知ることができ、それに応じた処理が書ける
		 */
		List<Future<Boolean>> futures = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
//			futures.add(exec.submit(task));
			// 戻り値がある場合、Callableインターフェース
			futures.add(exec.submit(() -> {
				System.out.println(Thread.currentThread().getId());	
				return new Random().nextInt() % 2 == 0;
			}));
			
		}

		int total = 0;
		for (Future<Boolean> future : futures) {
			// InterruptedException, ExecutionException発生可能性あり
			Boolean result = future.get();
			System.out.println(result);
			
			if (result) {
				total++;
			}
		}
		System.out.println(total);
		System.out.println("タスク1完了");   
	}
}
