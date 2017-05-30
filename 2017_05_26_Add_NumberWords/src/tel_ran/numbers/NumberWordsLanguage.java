package tel_ran.numbers;

public abstract class NumberWordsLanguage implements NumberWords {
	private String language;
	
	/**
	 * @param language
	 */
	public NumberWordsLanguage(String language) {
		super();
		this.language = language;
	}
	

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

}
