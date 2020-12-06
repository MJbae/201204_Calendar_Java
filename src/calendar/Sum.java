package calendar;

public class Sum {
	private static String[] DATES = { "  1", "  2", "  3", "  4",
			"  5", "  6", "  7", "  8", "  9", " 10", " 11", " 12", " 13", " 14", " 15", " 16", " 17", " 18", " 19",
			" 20", " 21", " 22", " 23", " 24", " 25", " 26", " 27", " 28", " 29", " 30", " 31" };
	
	public static void main(String[] args) {
		
		String[] copyOfArray = new String[28+3];
		
		System.arraycopy(DATES, 0, copyOfArray, 3, 28);
		
		for(String test : copyOfArray) {
			System.out.println("each String " + test);
		}
		
	}
}
