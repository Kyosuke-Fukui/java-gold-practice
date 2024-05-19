package test;

//1-9
interface A {
	default void sample() {
		System.out.println("default");
	}

	static void test() {
		System.out.println("A");
	}
}

public class D implements A {

	public static void main(String[] args) {
		A.test(); // Aのstaticメソッドの実行
//		A.super.sample(); デフォルトメソッドは直接staticメソッド内で使えない
		new D().method();
	}

	void method() {
		A.super.sample(); // デフォルトメソッドの実行
	}
}
