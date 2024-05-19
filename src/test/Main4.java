package test;

//1.12
interface AA {
	default void test() {
		System.out.println("AA");
	}
}

class B {
	public void test() {
		System.out.println("B");
	}
}

class C extends B implements AA {
//	@Override
//	public void test() {
//		System.out.println("C");
//	}
}

public class Main4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		AA a = new C();
		a.test(); // 「B」（インターフェースよりもスーパークラスのメソッドが優先）
		/*
		 * ただし、Cクラスでtest()をオーバーライドした場合はポリモーフィズムで「C]
		 */
	}

}
