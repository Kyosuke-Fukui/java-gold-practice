package file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File file = new File(".");
		List<File> list = Arrays.asList(file.listFiles());
		list.forEach(System.out::println);
		
//		Console console = System.console(); //Eclipseではnullになる
//		System.out.println(console.readLine());
	}

}
