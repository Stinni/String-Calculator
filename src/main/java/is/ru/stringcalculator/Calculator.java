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
			checkInputForIllegalNumbers(theNumbers);
			return sumOfArray(theNumbers);
		}
		else if(text.contains(",") || text.contains("\n")) {
			String [] numbers = text.split(",|\n");
			checkInputForIllegalNumbers(numbers);
			return sumOfArray(numbers);
		}
		else {
			int number = toInt(text);
			if (number < 0) {
				throw new IllegalArgumentException("Negatives not allowed: " + number);
			}
			return number;
		}
	}

	private static void checkInputForIllegalNumbers(String [] numbers) {
		String negativeNumbers = "";
		for(String s : numbers) {
			if(toInt(s) < 0) {
				negativeNumbers += s;
				negativeNumbers += ",";
			}
		}
		if(!negativeNumbers.isEmpty()) {
			negativeNumbers = negativeNumbers.substring(0,negativeNumbers.length()-1);
			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
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
		int num = Integer.parseInt(number);
		if(num>1000) {
			return 0;
		}
		return num;
	}
}
