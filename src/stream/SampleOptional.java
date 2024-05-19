package stream;

import java.util.Optional;

public class SampleOptional {

	public static void main(String[] args) throws Exception {
//		Optional<String> sample = Optional.of(null); //この時点でNullPointerException
		Optional<String> sample = Optional.ofNullable(null);
		System.out.println(sample);
//		System.out.println(sample.get()); //nullだと例外発生(NoSuchElementException)
//		System.out.println(sample.orElseThrow(() -> new Exception())); //任意の例外をスロー
		System.out.println(sample.isPresent());
		System.out.println(sample.isEmpty());
		System.out.println(sample.orElse("例外は出させない!"));
		System.out.println(sample.orElseGet(() -> "Supplier"));
		Optional<String> sample2 = Optional.of("A"); 
		System.out.println(sample2.get()); 
		
		Optional<String> op1 = Optional.of("A");
		System.out.println(op1.map((s) -> s.toUpperCase()));
		Optional<Optional<String>> op2 = Optional.of(Optional.of("A"));
		System.out.println(op2.flatMap((s) -> s));
	}

}
