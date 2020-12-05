package calendar;

import java.util.Scanner;
import java.util.HashMap;

public class Calendar {

	
	private static final String[] DATES = {"   ", "   ", "   ", "   ", "   ", "   ", "   ",
			"  1", "  2", "  3", "  4", "  5", "  6", "  7", "  8", "  9", " 10", 
			" 11", " 12", " 13", " 14", " 15", " 16", " 17", " 18", " 19", " 20", 
			" 21", " 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29", " 30"," 31"};
	
	HashMap<String, Integer> DAY_OF_WEEK_HASH = new HashMap<String, Integer>(){{
		put("SU", 0);
		put("MO", 1);
		put("TU", 2);
		put("WE", 3);
		put("TH", 4);
		put("FR", 5);
		put("SA", 6);
	}};
	
	private static final int[] MAX_DATE = { 31, 28, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final int[] MAX_DATE_LEAN_YEAR = { 31, 29, 30, 31, 30, 31, 31, 31, 30, 31, 30, 31 };
	private static final String[] DAY_OF_WEEK = {"SU", "MO", "TU", "WE", "TH", "FR", "SA" };
	private static String PROMPT_YEAR = "YEAR> ";
	private static String PROMPT_MONTH = "MONTH> ";
	private static String PROMPT_WEEKDAY = "WEEKDAY> ";
	
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

	public void showAllDays(int inputYear, int inputMonth, String inputDay) {
		int maxDay = getMaxDay(inputYear, inputMonth);

		System.out.printf("    <<%d년 %d월>>    ", inputYear, inputMonth);
		System.out.println(" ");
		
		int startPoint = DAY_OF_WEEK_HASH.get(inputDay);
		
		String[] copyOfDATES = new String[maxDay + startPoint + 1];

		System.arraycopy(DATES, 7-startPoint, copyOfDATES, 0, copyOfDATES.length);
		
		for (String eachDay : DAY_OF_WEEK) {
			System.out.print(" "+ eachDay);
		}
		System.out.println("\n---------------------");
		
		int indexForTap = 1;
		for(String date : copyOfDATES) {
			
			System.out.print(date);
			
			if (indexForTap % 7 == 0) {
				System.out.println(" ");
			}
			indexForTap++;
		}
		
//		for (int date = 1; date <= maxDay; date++) {
//			System.out.printf("%3d", date);
//			if (date % 7 == 0) {
//				System.out.println(" ");
//			}
//		}
		System.out.println(" ");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 0;
		int year = 0;
		String day = "";

		while (true) {
			System.out.println("연도를 입력하세요.");
			System.out.print(PROMPT_YEAR);
			year = scan.nextInt();
			if (year == -1)
				break;

			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT_MONTH);
			month = scan.nextInt();
			
			System.out.println("첫번째 요일을 입력하세요.");
			System.out.print(PROMPT_WEEKDAY);
			day = scan.next();

			if (month == -1)
				break;

			if (month > 12 || month < 1)
				continue;

			cal.showAllDays(year, month, day);
			System.out.println("");
		}

		scan.close();
		System.out.println("Done");
	}
}
