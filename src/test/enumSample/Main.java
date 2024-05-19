package test.enumSample;

class Main {
	public static void main(String[] args) {
		new Switch().execSwitch();
//		System.out.println(Foo.valueOf("A")); //A
//		System.out.println(Foo.A); //A
//		System.out.println(Foo.values()[0]); //A
	}
}

enum Foo {
	A(1), B(2), C(0);

	private int val;

	Foo(int val) {
		this.val = val;
	}
}

class Switch {
	public void execSwitch() {
		for (Foo f : Foo.values()) {
			switch (f) {
			case A:
				System.out.print("a");
				break;
			case B:
				System.out.print("b");
				break;
			default:
				System.out.print("c");
			}
		}
	}
}