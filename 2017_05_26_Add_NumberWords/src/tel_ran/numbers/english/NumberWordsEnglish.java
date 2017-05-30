package tel_ran.numbers.english;

import tel_ran.numbers.Gender;
import tel_ran.numbers.NumberWordsLanguage;

public class NumberWordsEnglish extends NumberWordsLanguage {

	public NumberWordsEnglish() {
		super("en");
	}

	@Override
	public String generate(long number, Gender gender) {
		return generate(number);
	}

	String generate(long number) {
		if (number == 0){
			return EnglishDigits.zero.name();
		}

		StringBuilder res = new StringBuilder();
		long upperValue = 0;
		long underValue = number;
		for (EnglishThousand thousand : EnglishThousand.values()) {
			upperValue = underValue / thousand.getValue();
			underValue %= thousand.getValue();
			if (upperValue > 0) {
				res.append(generateUnderThousand(upperValue));
				res.append(" ");
				res.append(thousand.name());
				res.append(" ");
			}
		}
		if (underValue > 0) {
			res.append(generateUnderThousand(underValue));
		}
		return res.toString().trim();
	}

	private String generateUnderThousand(long number) {
		StringBuilder res = new StringBuilder();
		if (number >= 100) {
			res.append(EnglishDigits.get((number / 100) * 100));
			number = number - (number / 100) * 100;
			if (number > 0) {
				res.append(" and ");
			}
		}
		if (number >= 20) {
			res.append(EnglishDigits.get((number / 10) * 10));
			res.append("-"); // like forty-five
			number = number - (number / 10) * 10;
		}
		if (number > 0) {
			res.append(EnglishDigits.get(number));
		}
		if (res.charAt(res.length() - 1) == '-') { //
			res.deleteCharAt(res.length() - 1);
		}
		return res.toString().trim();
	}
}
