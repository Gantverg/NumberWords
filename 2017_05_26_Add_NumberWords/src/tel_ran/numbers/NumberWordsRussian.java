package tel_ran.numbers;

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
		for(int i = RussianThousand.values().length-1; i >= 0; i--) {
			upperValue = underValue / RussianThousand.values()[i].getValue();
			underValue %= RussianThousand.values()[i].getValue();
			if(upperValue > 0){
				res.append(generateUnderThousand(upperValue, RussianThousand.values()[i].getGender()));
				res.append(" ");
				res.append(RussianThousand.getDeclension(upperValue, RussianThousand.values()[i]));
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

enum RussianDigits{
	ноль(0), один(1), два(2), три(3), четыре(4), п€ть(5), шесть(6), семь(7), восемь(8), дев€ть(9), 
	дес€ть(10), одиннадцать(11), двенадцать(12), тринадцать(13), четырнадцать(14), п€тнадцать(15), шестнадцать(16), семнадцать(17), восемнадцать(18), дев€тнадцать(19),
	двадцать(20), тридцать(30), сорок(40), п€тьдес€т(50), шестьдес€т(60), семьдес€т(70), восемьдес€т(80), дев€носто(90),
	сто(100), двести(200), триста(300), четыреста(400), п€тьсот(500), шестьсот(600), семьсот(700), восемьсот(800), дев€тьсот(900);
	private long value;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String get(long number, Gender gender) {
		if(gender == Gender.FEMININE){
			if(number==1){
				return "одна";
			}
			if(number==2){
				return "две";
			}
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
	private RussianDigits(long value) {
		this.value = value;
	}
}

enum RussianThousand{
	тыс€ча(1000l, Gender.FEMININE), миллион(1000000l, Gender.MASCULINE), миллиард(1000000000l, Gender.MASCULINE), 
	триллион(1000000000000l, Gender.MASCULINE), квадриллион(1000000000000000l, Gender.MASCULINE), квинтиллион(1000000000000000000l, Gender.MASCULINE);
	private long value;
	private Gender gender;

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

	Gender getGender() {
		return gender;
	}

	/**
	 * @param value
	 */
	private RussianThousand(long value, Gender gender) {
		this.value = value;
		this.gender = gender;
	}
}

