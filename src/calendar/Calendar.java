package calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final char[] dayOfWeek = { '일', '월', '화', '수', '목', '금', '토' };

	public int getMaxDayOfMonth(int inputMonth) {
		if (inputMonth < 1 || inputMonth > 12) {
			System.out.print("유효한 값을 입력하십시오.");
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

		System.out.println("달을 입력하세요.");
		int inputMonth = scan.nextInt();

		System.out.printf("%d월은 %d일까지 있습니다.", inputMonth, cal.getMaxDayOfMonth(inputMonth));
		cal.showAllDays();
		scan.close();
	}
}
