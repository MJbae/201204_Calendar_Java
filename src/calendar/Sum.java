package calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요.");

		int inputA = scan.nextInt();
		int inputB = scan.nextInt();
		
		System.out.printf("두 수의 합은 %d입니다.", inputA + inputB);
		
		scan.close();
	}
}
