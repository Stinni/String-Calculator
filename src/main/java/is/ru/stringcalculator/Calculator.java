package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")) {
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")) {
			String [] numbers = text.split(",|\n");
			int x = 0;
			for(String s : numbers) {
				x += toInt(s);
			}
			return x;
		}
		else {
			return toInt(text);
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}
}
