package calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final int[] maxDayOfLeanMonth = { 31, 29, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final char[] dayOfWeek = { '일', '월', '화', '수', '목', '금', '토' };
	private static String PROMPT = "> ";
	
	
	public boolean isLeapYear(int year) {
		boolean answer = false;
		
		if(year % 4 == 0) {
			answer = true;
		}
		
		if(year % 4 == 0 && year % 100 == 0) {
			answer = false;
		}
		
		if(year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			answer = true;
		}
		
		
		return answer;
	}
	
	
	public int getMaxDay(int year, int month) {
		if (month < 1 || month > 12) {
			System.out.print("유효한 값을 입력하십시오.");
		}
		
		if(isLeapYear(year)) {
			return maxDayOfLeanMonth[month - 1];
		} else {
			return maxDayOfMonth[month - 1];
		}
	}

	public void showAllDays(int inputYear, int inputMonth) {
		int maxDay = getMaxDay(inputYear, inputMonth);
		
		System.out.printf("    <<%d년 %d월>>    ", inputYear, inputMonth);
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
		System.out.println(" ");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 0;
		int year = 0;
		
		while(true) {
			System.out.println("연도를 입력하세요.");
			System.out.print(PROMPT);
			year = scan.nextInt();
			if(year == -1) break;
			
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scan.nextInt();
			if(month == -1) break;
			
			if(month > 12 || month < 1) continue;
			
			cal.showAllDays(year, month);
			System.out.println("");
		}
		
		scan.close();
		System.out.println("Done");
	}
}
