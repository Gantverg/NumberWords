package tel_ran.numbers.russian;

import tel_ran.numbers.Gender;

enum RussianThousand {
	квинтиллион(1000000000000000000l, Gender.MASCULINE),
	квадриллион(1000000000000000l, Gender.MASCULINE), 
	триллион(1000000000000l, Gender.MASCULINE), 
	миллиард(1000000000l, Gender.MASCULINE), 
	миллион(1000000l, Gender.MASCULINE), 
	тыс€ча(1000l, Gender.FEMININE);
	private long value;
	private Gender gender;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String getDeclension(long current, RussianThousand russianThousand) {
		if (current % 100 > 10 && current % 100 < 13 && russianThousand == RussianThousand.тыс€ча)
			return "тыс€ч";
		if (current % 100 > 10 && current % 100 < 13)
			return russianThousand.name() + "ов";
		if (current % 10 == 1)
			return russianThousand.name();
		if (current % 10 > 1 && current % 10 < 5 && russianThousand == RussianThousand.тыс€ча)
			return "тыс€чи";
		if (current % 10 > 1 && current % 10 < 5)
			return russianThousand.name() + "а";
		if (russianThousand == RussianThousand.тыс€ча)
			return "тыс€ч";
		return russianThousand.name() + "ов";
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