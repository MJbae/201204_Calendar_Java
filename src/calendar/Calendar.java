package calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final char[] dayOfWeek = { '��', '��', 'ȭ', '��', '��', '��', '��' };

	public int getMaxDayOfMonth(int inputMonth) {
		if (inputMonth < 1 || inputMonth > 12) {
			System.out.print("��ȿ�� ���� �Է��Ͻʽÿ�.");
		}
		return maxDayOfMonth[inputMonth - 1];
	}

	public void showAllDays() {
		System.out.println(" ");
		for (char eachDay : dayOfWeek) {
			System.out.print(eachDay + "  ");
		}
		System.out.println("\n---------------------");
		for (int date = 1; date < 29; date++) {
			System.out.printf("%3d", date);
			if (date % 7 == 0) {
				System.out.println(" ");
			}
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		System.out.println("���� �Է��ϼ���.");
		int inputMonth = scan.nextInt();

		System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�.", inputMonth, cal.getMaxDayOfMonth(inputMonth));
		cal.showAllDays();
		scan.close();
	}
}
