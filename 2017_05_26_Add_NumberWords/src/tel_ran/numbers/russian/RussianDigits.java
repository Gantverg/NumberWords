package tel_ran.numbers.russian;

import tel_ran.numbers.Gender;

enum RussianDigits{
	ноль(0), один(1), два(2), три(3), четыре(4), пять(5), шесть(6), семь(7), восемь(8), девять(9), 
	десять(10), одиннадцать(11), двенадцать(12), тринадцать(13), четырнадцать(14), пятнадцать(15), шестнадцать(16), семнадцать(17), восемнадцать(18), девятнадцать(19),
	двадцать(20), тридцать(30), сорок(40), пятьдесят(50), шестьдесят(60), семьдесят(70), восемьдесят(80), девяносто(90),
	сто(100), двести(200), триста(300), четыреста(400), пятьсот(500), шестьсот(600), семьсот(700), восемьсот(800), девятьсот(900);
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
		for(RussianDigits currentDigit : values()){
			if(currentDigit.getValue() == number){
				return currentDigit.name();
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
