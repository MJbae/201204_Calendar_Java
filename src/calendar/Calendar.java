package calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
//		char[] dayOfWeek = { '��', '��', 'ȭ', '��', '��', '��', '��' };
//
//		for (char eachDay : dayOfWeek) {
//			System.out.print(eachDay + "  ");
//		}
//		System.out.println("\n---------------------");
//		for (int date = 1; date < 29; date++) {
//			System.out.printf("%3d", date);
//			if (date % 7 == 0) {
//				System.out.println(" ");
//			}
//		}

		int[] maxDayOfMonth = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };

		Scanner scan = new Scanner(System.in);

		System.out.println("���� �Է��ϼ���.");
		int inputMonth = scan.nextInt();
		

		System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�.", inputMonth, maxDayOfMonth[inputMonth-1]);
	}
}
