package test.silver;

class A{
	public String str = "A";
	
	public void sample() {
		System.out.println("A");
	}
}

class B extends A{
	public String str = "B";
	
	public void sample() {
		System.out.println("B");
	}
}

public class Main3{
	public static void main(String[] args){
		A a = new B();
		B b = new B();
		a.sample();
		b.sample();
		System.out.println(a.str);
		System.out.println(b.str);
		
	}
}