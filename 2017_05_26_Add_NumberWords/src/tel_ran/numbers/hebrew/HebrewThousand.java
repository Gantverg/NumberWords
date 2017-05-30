package tel_ran.numbers.hebrew;

enum HebrewThousand {
	קווינטיליון (1000000000000000000l, "קווינטיליונים"),
	קוודריליון (1000000000000000l, 	"קוודריליונים"),
	טריליון (1000000000000l,	"טריליונים"),
	מיליארד (1000000000, "מיליארדים"),
	מיליון (1000000, "מיליונים"),
	אלף (1000, "אלפים");

	private long value;
	private String multiples;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String getDeclension(long current, HebrewThousand hebrewThousand, String number) {
		if (hebrewThousand == HebrewThousand.אלף && current == 2)
			return "אלפיים";
		if (current == 2)
			return "שני" + " " + hebrewThousand.multiples;
		if (current == 1)
			return hebrewThousand.name();
		if (hebrewThousand == HebrewThousand.אלף)
			return number + "ה " + hebrewThousand.multiples;
		return number + " " + hebrewThousand.multiples;
	}

	/**
	 * @param value
	 */
	private HebrewThousand(long value, String multiples) {
		this.value = value;
		this.multiples = multiples;
	}
}