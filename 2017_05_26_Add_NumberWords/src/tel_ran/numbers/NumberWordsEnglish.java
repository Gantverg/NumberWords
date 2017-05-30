package tel_ran.numbers;

public class NumberWordsEnglish extends NumberWordsLanguage {

	public NumberWordsEnglish() {
		super("en");
	}

	@Override
	public String generate(long number, Gender gender) {
		return generate(number);
	}

	String generate(long number) {
		if(number == 0) return EnglishDigits.zero.name();
		
		StringBuilder res = new StringBuilder();
		long upperValue = 0;
		long underValue = number;
		for(int i = EnglishThousand.values().length-1; i >= 0; i--) {
			upperValue = underValue / EnglishThousand.values()[i].getValue();
			underValue %= EnglishThousand.values()[i].getValue();
			if(upperValue > 0){
				res.append(generateUnderThousand(upperValue));
				res.append(" ");
				res.append(EnglishThousand.values()[i].name());
				res.append(" ");
			}
		}
		if(underValue > 0){
			res.append(generateUnderThousand(underValue));
		}
		return res.toString().trim();
	}

	private String generateUnderThousand(long number){
		StringBuilder res = new StringBuilder();
		if (number >= 100){
			res.append(EnglishDigits.get((number / 100) * 100));
			number = number - (number / 100) * 100;
			if (number > 0){
				res.append(" and ");
			}
		}
		if (number >= 20){
			res.append(EnglishDigits.get((number / 10) * 10));
			res.append("-"); //like forty-five
			number = number - (number / 10) * 10;
		}
		if(number > 0){
			res.append(EnglishDigits.get(number));
		}
		if(res.charAt(res.length()-1)=='-'){ //
			res.deleteCharAt(res.length()-1);
		}
		return res.toString().trim();
	}

}

enum EnglishDigits{
	zero(0), one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), 
	eleven(11), twelve(12), thirteen(13), fourteen(14), fifteen(15), sixteen(16), seventeen(17), eighteen(18), nineteen (19), 
	twenty (20), thirty (30), forty (40), fifty (50), sixty (60), seventy (70), eighty (80), ninety (90), hundred (100);
	
	private long value;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String get(long number) {
		if(number >=100){
			return get(number / 100) + " " + hundred.name();
		}
		for(int i = 0; i < values().length; i++){
			if(values()[i].getValue() == number){
				return values()[i].name();
			}
		}
		return null;
	}

	/**
	 * @param value
	 */
	private EnglishDigits(long value) {
		this.value = value;
	}
}

enum EnglishThousand{
	thousand (1000l), million (1000000l), billion (1000000000l), trillion (1000000000000l), 
	quadrillion (1000000000000000l), quintillion (1000000000000000000l);
	private long value;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String getDeclension(long current, RussianThousand russianThousand) {
		if(current%100>10&&current%100<13&&russianThousand==RussianThousand.тыс€ча) return "тыс€ч"; //11 000, 12 000
		if(current%100>10&&current%100<13) return russianThousand.name()+"ов"; //11 000 000, 12 000 000, 11 000 000 000 etc
		if(current%10==1) return russianThousand.name(); //1 000, 21 000, 31 000, 101 000, 1 000 000, 21 000 000 etc
		if(current%10>1&&current%10<5&&russianThousand==RussianThousand.тыс€ча) return "тыс€чи"; //2 000, 22 000
		if(current%10>1&&current%10<5) return russianThousand.name()+"а"; //2 000 000, 22 000 000, 4 000 000 000 etc
		if(russianThousand == RussianThousand.тыс€ча) return "тыс€ч"; //5 000, 15 000, 16 000, 27 000 etc
		return russianThousand.name()+"ов"; //5 000 000, 25 000 000 000 etc
	}

	/**
	 * @param value
	 */
	private EnglishThousand(long value) {
		this.value = value;
	}
}

