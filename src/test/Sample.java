package test;

public class Sample extends AbstractTest implements Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Sample().execute("hello");
	}

}

interface Test {
	public default void execute(String str) {
		System.out.println("A");
	}
}

abstract class AbstractTest {
	private void execute(String str) {
		System.out.println("B");
	}
}