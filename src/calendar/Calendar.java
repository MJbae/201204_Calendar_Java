package calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final char[] dayOfWeek = { '일', '월', '화', '수', '목', '금', '토' };
	private static String PROMPT = "> ";

	public int getMaxDayOfMonth(int inputMonth) {
		if (inputMonth < 1 || inputMonth > 12) {
			System.out.print("유효한 값을 입력하십시오.");
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
			System.out.println("달을 입력하세요.");
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
