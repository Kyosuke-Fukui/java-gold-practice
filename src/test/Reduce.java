package test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		//初期値なしの場合、戻り値はOptional型
		Optional<Integer> result = list.stream().reduce((a, b) -> a + b);
		//初期値ありの場合、戻り値はInteger型
		Integer result2 = list.stream().reduce(10, (a, b) -> a + b);
		
		System.out.println(result);
		System.out.println(result2);

	}
}
