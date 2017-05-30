package tel_ran.numbers.english;

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

	/**
	 * @param value
	 */
	private EnglishThousand(long value) {
		this.value = value;
	}
}

