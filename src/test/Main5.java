package test;

//1-13
interface A1 {
	//暗黙的にpublic
	default void test() {
		System.out.println("A1");
	}
}

class B1 {
	//デフォルトメソッドよりも厳しい制限（public以外）だとコンパイルエラー
	public void test() {
		System.out.println("B1");
	}
}

public class Main5 extends B1 implements A1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Main5 a = new Main5();
		a.test(); // 「B1」
	}

}
