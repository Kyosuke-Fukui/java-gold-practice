package test.silver;

public class Main{
	public static void main(String[] args){
		Child child = new Child();
		System.out.println(child.name);
	}
}

class Parent{
	String name = "name";
}

class Child extends Parent{
//	String getName() {
//		return super.name;
//	};
}
