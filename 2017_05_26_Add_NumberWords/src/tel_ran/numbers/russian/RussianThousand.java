package tel_ran.numbers.russian;

import tel_ran.numbers.Gender;

enum RussianThousand {
	�����������(1000000000000000000l, Gender.MASCULINE),
	�����������(1000000000000000l, Gender.MASCULINE), 
	��������(1000000000000l, Gender.MASCULINE), 
	��������(1000000000l, Gender.MASCULINE), 
	�������(1000000l, Gender.MASCULINE), 
	������(1000l, Gender.FEMININE);
	private long value;
	private Gender gender;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String getDeclension(long current, RussianThousand russianThousand) {
		if (current % 100 > 10 && current % 100 < 13 && russianThousand == RussianThousand.������)
			return "�����";
		if (current % 100 > 10 && current % 100 < 13)
			return russianThousand.name() + "��";
		if (current % 10 == 1)
			return russianThousand.name();
		if (current % 10 > 1 && current % 10 < 5 && russianThousand == RussianThousand.������)
			return "������";
		if (current % 10 > 1 && current % 10 < 5)
			return russianThousand.name() + "�";
		if (russianThousand == RussianThousand.������)
			return "�����";
		return russianThousand.name() + "��";
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