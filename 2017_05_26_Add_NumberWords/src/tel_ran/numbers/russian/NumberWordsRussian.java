package tel_ran.numbers.russian;

import tel_ran.numbers.Gender;
import tel_ran.numbers.NumberWordsLanguage;

public class NumberWordsRussian extends NumberWordsLanguage {
	
	public NumberWordsRussian() {
		super("ru");
	}

	@Override
	public String numberInWords(long number) {
		return generate(number, Gender.MASCULINE);
	}

	@Override
	public String generate(long number, Gender gender) {
		if(number == 0) return RussianDigits.ноль.name();
		
		StringBuilder res = new StringBuilder();
		long upperValue = 0;
		long underValue = number;
		for(RussianThousand thousand : RussianThousand.values()) {
			upperValue = underValue / thousand.getValue();
			underValue %= thousand.getValue();
			if(upperValue > 0){
				res.append(generateUnderThousand(upperValue, thousand.getGender()));
				res.append(" ");
				res.append(RussianThousand.getDeclension(upperValue, thousand));
				res.append(" ");
			}
		}
		if(underValue > 0){
			res.append(generateUnderThousand(underValue, gender));
		}
		return res.toString().trim();
	}

	private String generateUnderThousand(long number, Gender gender){
		StringBuilder res = new StringBuilder();
		if (number >= 100){
			res.append(RussianDigits.get((number / 100) * 100, gender));
			res.append(" ");
			number = number - (number / 100) * 100; 
		}
		if (number >= 20){
			res.append(RussianDigits.get((number / 10) * 10, gender));
			res.append(" ");
			number = number - (number / 10) * 10;
		}
		if(number > 0){
			res.append(RussianDigits.get(number, gender));
		}
		return res.toString().trim();
	}
}