package nest;

//1-5
//解説ではstaticでない内部クラスにstaticフィールドを定義できないとあるが、
//SE15以降コンパイル通る。
public class Outer2 {
	void test() {
		Inner.message = "Hello World"; // 非staticからstaticへの参照可
	}

	class Inner {
		private static String message;

		public void test() {
			System.out.println(message);
		}
	}

	public static void main(String[] args) {
		new Outer2().test();

		new Outer2().new Inner().test();
//		new Outer2.Inner().test(); //staticインナークラスを利用する場合の書き方
	}
}

//Innerクラスが非staticの場合のSE11でのエラー文
//Exception in thread "main" java.lang.IncompatibleClassChangeError: 
//Type Outer2$Inner is not a nest member of Outer2: 
//current type is not listed as a nest member