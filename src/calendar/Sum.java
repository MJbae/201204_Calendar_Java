package calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�� ���� �Է��ϼ���.");

		int inputA = scan.nextInt();
		int inputB = scan.nextInt();
		
		System.out.printf("�� ���� ���� %d�Դϴ�.", inputA + inputB);
		
		scan.close();
	}
}
