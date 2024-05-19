package nest;

//1-4

public class Outer {
	private static int num = 2; //staticないとline14でエラー
	public void hoge() {
		Inner test = new Inner();
		test.data = 100;
		test.execute();
	}
	
	private static class Inner {
		private int data;
		void execute() {
			System.out.println(num * data); //staticから非staticへの参照不可
		}
	}
	
	public static void main(String[] args){
		new Outer().hoge();
		new Inner().execute();
	}
}
