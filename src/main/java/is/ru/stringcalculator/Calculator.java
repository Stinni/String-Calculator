package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.isEmpty()) {
			return 0;
		}
		else if(text.startsWith("//")) {
			String delimiter = text.substring(2, 3);
			String justNumbers = text.substring(text.indexOf("\n")+1, text.length());
			String [] theNumbers = justNumbers.split(delimiter);
			return sumOfArray(theNumbers);
		}
		else if(text.contains(",") || text.contains("\n")) {
			String [] numbers = text.split(",|\n");
			return sumOfArray(numbers);
		}
		else {
			return toInt(text);
		}
	}

	private static int sumOfArray(String [] numbers) {
		int sum = 0;
		for(String s : numbers) {
			sum += toInt(s);
		}
		return sum;
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}
}
