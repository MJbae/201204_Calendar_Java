package calendar;

public class Calendar {
	public static void main(String[] args) {
		char[] dayOfWeek = { '��', '��', 'ȭ', '��', '��', '��', '��' };

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
}
