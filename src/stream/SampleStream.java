package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class SampleStream {

	public static void main(String[] args) {
//		int[] intArray = new int[] {0, 1, 2};
//		IntStream intStream = Arrays.stream(intArray); 

		String[] strArray = new String[] {"A", "B", "C"};
		Stream<String> strStream = Arrays.stream(strArray); //参照型の場合
		
		Stream<String> paraStream = Arrays.stream(strArray).parallel();
//		Stream<String> paraStream = strStream.parallel(); //これだとストリームを2本にしたことにならない
//		paraStream.forEach(System.out::println); //不明 B, C, Aなど
//		paraStream.forEachOrdered(System.out::println); //A, B. C
		System.out.println(strStream.findAny()); //Optional[A]
//		System.out.println(strStream.findFirst()); //Optional[A]
//		System.out.println(paraStream.findAny()); //不明 Optional[B]など
		System.out.println(paraStream.findFirst()); //Optional[A]
		
		
	}
}
