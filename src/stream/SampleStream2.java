package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//要点　例題7
public class SampleStream2 {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("A", 99), new Person("B", 120), new Person("C", 101));
		Predicate<Person> p = b -> b.getAge() > 100;

		var list2 = list.stream().filter(p).collect(Collectors.toList());

		Stream<String> names = list2.stream().map(Person::getName);
		names.forEach(x -> System.out.println(x + " "));
	}

}

class Person {
	private String name;
	private Integer age;

	Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

}