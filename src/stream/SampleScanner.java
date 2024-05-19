package stream;

import java.util.Scanner;

public class SampleScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try (scanner){
			while(scanner.hasNext()) {
				System.out.println(scanner.next());
				//eclipseではCtrl+Zで入力終了（windowsのcmdではCtrl+C）
//				if(scanner.next().equals("finish")) {
//					break;
//				}
			}
		} finally {
			System.out.println("finished");
		}
	}

}
