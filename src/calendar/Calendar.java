package calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final char[] dayOfWeek = { '��', '��', 'ȭ', '��', '��', '��', '��' };
	private static String PROMPT = "> ";

	public int getMaxDayOfMonth(int inputMonth) {
		if (inputMonth < 1 || inputMonth > 12) {
			System.out.print("��ȿ�� ���� �Է��Ͻʽÿ�.");
		}
		return maxDayOfMonth[inputMonth - 1];
	}

	public void showAllDays(int maxDay) {
		System.out.println(" ");
		for (char eachDay : dayOfWeek) {
			System.out.print(eachDay + "  ");
		}
		System.out.println("\n---------------------");
		for (int date = 1; date < maxDay + 1; date++) {
			System.out.printf("%3d", date);
			if (date % 7 == 0) {
				System.out.println(" ");
			}
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		int inputMonth = 0;
		int maxDay = 0;
		
		while(true) {
			System.out.println("���� �Է��ϼ���.");
			System.out.print(PROMPT);
			
			inputMonth = scan.nextInt();
			
			if(inputMonth == -1) break;
			if(inputMonth > 12 || inputMonth < 1) continue;
			maxDay = cal.getMaxDayOfMonth(inputMonth);
			cal.showAllDays(maxDay);
			System.out.println("");
		}
		
		scan.close();
		System.out.println("Done");
	}
}
