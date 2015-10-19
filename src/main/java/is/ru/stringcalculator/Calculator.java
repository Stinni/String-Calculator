package is.ru.stringcalculator;
import java.util.List;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {

	public static int add(String text) {
		if(text.isEmpty()) {
			return 0;
		}
		else if(text.startsWith("//")) {
			String regexPattern = "-?\\d+";
			Matcher m = Pattern.compile(regexPattern).matcher(text);
			List<Integer> numbers = new LinkedList<Integer>();
			while(m.find()) {
				int number = toInt(m.group());
				numbers.add(number);
			}
			checkInputForIllegalNumbers(numbers);
			return sumOfListOfIntegers(numbers);
		}
		else if(text.contains(",") || text.contains("\n")) {
			String [] numbers = text.split(",|\n");
			List<Integer> listOfNumbers = new LinkedList<Integer>();
			for(String s : numbers) {
				listOfNumbers.add(toInt(s));
			}
			checkInputForIllegalNumbers(listOfNumbers);
			return sumOfListOfIntegers(listOfNumbers);
		}
		else {
			int number = toInt(text);
			if (number < 0) {
				throw new IllegalArgumentException("Negatives not allowed: " + text);
			}
			return number;
		}
	}

	private static void checkInputForIllegalNumbers(List<Integer> numbers) {
		String negativeNumbers = "";
		for(Integer i : numbers) {
			if(i < 0) {
				negativeNumbers += i.toString();
				negativeNumbers += ",";
			}
		}
		if(!negativeNumbers.isEmpty()) {
			negativeNumbers = negativeNumbers.substring(0, negativeNumbers.length()-1);
			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
		}
	}

	private static int sumOfListOfIntegers(List<Integer> numbers) {
		int sum = 0;
		for(Integer i : numbers) {
			sum += i;
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
