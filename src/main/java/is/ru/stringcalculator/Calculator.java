package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.isEmpty()) {
			return 0;
		}
		else if(text.startsWith("//")) {
			String delimiter = text.substring(2, 3);
			String justNumbers = text.substring(text.indexOf("\n")+1, text.length());
			String [] numbers = justNumbers.split(delimiter);
			int sum = 0;
			for(String s : numbers) {
				sum += toInt(s);
			}
			return sum;
		}
		else if(text.contains(",") || text.contains("\n")) {
			String [] numbers = text.split(",|\n");
			int sum = 0;
			for(String s : numbers) {
				sum += toInt(s);
			}
			return sum;
		}
		else {
			return toInt(text);
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}
}
