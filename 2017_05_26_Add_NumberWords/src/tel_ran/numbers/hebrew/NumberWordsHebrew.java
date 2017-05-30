package tel_ran.numbers.hebrew;

import tel_ran.numbers.Gender;
import tel_ran.numbers.NumberWordsLanguage;

public class NumberWordsHebrew extends NumberWordsLanguage {

	public NumberWordsHebrew() {
		super("he");
	}

	@Override
	public String numberInWords(long number) {
		return numberInWords(number, Gender.FEMININE);
	}

	public String generate(long number, Gender gender) {
		if (number == 0)
			return HebrewDigits.אפס.name();
		StringBuilder res = new StringBuilder();
		long upperValue = 0;
		long underValue = number;
		for (HebrewThousand thousand : HebrewThousand.values()) {
			upperValue = underValue / thousand.getValue();
			underValue %= thousand.getValue();
			if (upperValue > 0) {
				String str = generateUnderThousand(upperValue,
						thousand == HebrewThousand.אלף ? Gender.FEMININE : Gender.MASCULINE);
				res.append(HebrewThousand.getDeclension(upperValue, thousand, str));
				res.append(' ');
			}
		}
		if (underValue > 0) {
			res.append(generateUnderThousand(underValue, gender));
		}
		return res.toString().trim();
	}

	String generateUnderThousand(long number, Gender gender) {
		StringBuilder res = new StringBuilder();
		if (number >= 100) {
			res.append(HebrewDigits.get((number / 100) * 100, gender));
			res.append(" ");
			number = number - (number / 100) * 100;
		}
		if (number >= 20) {
			res.append(HebrewDigits.get((number / 10) * 10, gender));
			res.append(" ");
			number = number - (number / 10) * 10;
		}
		if (number > 0) {
			if (number < 10 && res.length() > 0) {
				res.append('ו');
			}
			res.append(HebrewDigits.get(number, gender));
		}

		return res.toString().trim();
	}
}