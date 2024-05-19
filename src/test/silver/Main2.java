package test.silver;

import java.util.function.Supplier;

public class Main2{
	public static void main(String[] args){
		final int i = 0;
		Supplier<Integer> foo = () -> i;
//		i++;
		System.out.println(foo.get());
	}
}
