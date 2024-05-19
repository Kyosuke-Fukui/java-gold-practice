package test.threads;

public class LiveLock {
	public static void main(String... args) {
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		Resource r = new Resource();
		r.owner = w1;
		new Thread(() -> w1.work(w2, r)).start();
		new Thread(() -> w2.work(w1, r)).start();
	}
}

class Resource {
	public Worker owner;
}

class Worker {
	private boolean ready = true;

	public synchronized boolean isReady() {
		return ready;
	}

	public synchronized void work(Worker other, Resource resource) {
		while (ready) {
			while (resource.owner != this) {
				try {
					wait(10); //ownerはw1なのでw2はここで待機
				} catch (InterruptedException e) {
				}
			}
			if (other.isReady()) {
				//スレッド2でw2にロックかかってるのでw1はここで待機
				resource.owner = other; 
			} else {
				ready = false;
				resource.owner = other;
			}
		}
	}
}

/*
このコードはライブロック（live lock）を引き起こす可能性があります。
ライブロックは、スレッドが相手を待ち続けることで、プログラムが進行不可能な状態に陥る問題です。
以下のように、状況が永遠に変わらない可能性があるため、ライブロックが発生します。

1. スレッド1（w1）は、リソースの所有者が自分であるかどうかを確認します。
2. スレッド2（w2）は、リソースの所有者が自分であるかどうかを確認します。
3. 両方のスレッドがリソースの所有者でないことを確認した場合、スレッド1はリソースの所有権をスレッド2に移します。
4. しかし、スレッド2も同じようにリソースの所有権をスレッド1に移すことを試みます。
5. この操作が繰り返され、両方のスレッドが互いに所有権を移し合うことになります。その結果、両方のスレッドが永久に待ち続け、プログラムは進行不可能な状態に陥ります。

このような問題を避けるために、ロックの取り合いを避けるように設計を見直す必要があります。具体的には、ロックの取得順序を一貫して保つか、タイムアウト付きの待機を実装するなどの方法があります。
*/