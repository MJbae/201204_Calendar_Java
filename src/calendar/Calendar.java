package calendar;

import java.util.Scanner;
import java.util.HashMap;

public class Calendar {
	private static final String[] DATES = {"  1", "  2", "  3", "  4",
			"  5", "  6", "  7", "  8", "  9", " 10", " 11", " 12", " 13", " 14", " 15", " 16", " 17", " 18", " 19",
			" 20", " 21", " 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29", " 30", " 31" };

	private static final int[] MAX_DATE = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] MAX_DATE_LEAN_YEAR = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] DAY_OF_WEEK = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };
	private static String PROMPT_YEAR = "YEAR> ";
	private static String PROMPT_MONTH = "MONTH> ";

	public boolean isLeapYear(int year) {
		boolean answer = false;

		if (year % 4 == 0) {
			answer = true;
		}

		if (year % 4 == 0 && year % 100 == 0) {
			answer = false;
		}

		if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			answer = true;
		}

		return answer;
	}

	public int getMaxDay(int year, int month) {
		if (month < 1 || month > 12) {
			System.out.print("유효한 값을 입력하십시오.");
		}

		if (isLeapYear(year)) {
			return MAX_DATE_LEAN_YEAR[month - 1];
		} else {
			return MAX_DATE[month - 1];
		}
	}

	public int getStartDay(int year, int month) {
		int firstDayOfYear = (year + year / 4 - year / 100 + year / 400);

		int sumDaysOfMonth = 0;

		if (isLeapYear(year)) {
			for (int i = 0; i < month-1; i++) {
				sumDaysOfMonth += MAX_DATE_LEAN_YEAR[i];
			}
		} else {
			for (int i = 0; i < month-1; i++) {
				sumDaysOfMonth += MAX_DATE[i];
			}
		}

//		System.out.println("firstDayOfYear  " + firstDayOfYear % 7 + "sumDaysOfMonth  " + sumDaysOfMonth % 7);
//		System.out.println("return  " + (firstDayOfYear + sumDaysOfMonth) % 7);
		return (firstDayOfYear + sumDaysOfMonth) % 7;
	}

	public void showAllDays(int inputYear, int inputMonth) {
		int maxDay = getMaxDay(inputYear, inputMonth);

		System.out.printf("    <<%d년 %d월>>    ", inputYear, inputMonth);
		System.out.println(" ");

		int startPoint = getStartDay(inputYear, inputMonth);
		
		String[] copyOfDATES = new String[maxDay + startPoint];

		System.arraycopy(DATES, 0, copyOfDATES, startPoint, maxDay);

		for (String eachDay : DAY_OF_WEEK) {
			System.out.print(" " + eachDay);
		}
		System.out.println("\n---------------------");

		int indexForTap = 1;
		for (String date : copyOfDATES) {
			if(date == null) {
				System.out.print("   ");
			} else {
				System.out.print(date);
			}
			

			if (indexForTap % 7 == 0) {
				System.out.println(" ");
			}
			indexForTap++;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = -1;
		int year = -1;

		while (true) {
			System.out.println("연도를 입력하세요.");
			System.out.print(PROMPT_YEAR);
			year = scan.nextInt();
			if (year == -1)
				break;

			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT_MONTH);
			month = scan.nextInt();
			if (month == -1)
				break;


			if (month > 12 || month < 1)
				continue;

			cal.showAllDays(year, month);
			System.out.println("");
		}

		scan.close();
		System.out.println("Done");
	}
}
