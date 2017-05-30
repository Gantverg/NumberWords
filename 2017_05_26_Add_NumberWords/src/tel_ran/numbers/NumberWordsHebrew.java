package tel_ran.numbers;

public class NumberWordsHebrew extends NumberWordsLanguage {

	public NumberWordsHebrew() {
		super("he");
	}

	@Override
	public String numberInWords(long number) {
		return numberInWords(number, Gender.FEMININE);
	}

	 public String generate(long number, Gender gender) {
		if(number == 0) return HebrewDigits.אפס.name();
		StringBuilder res = new StringBuilder();
		long upperValue = 0;
		long underValue = number;
		for(int i = HebrewThousand.values().length-1; i >= 0; i--) {
			HebrewThousand htValue = HebrewThousand.values()[i];
			upperValue = underValue / htValue.getValue();
			underValue %= htValue.getValue();
			if(upperValue > 0){
				String str = generateUnderThousand(upperValue, htValue==HebrewThousand.אלף?Gender.FEMININE:Gender.MASCULINE);
				res.append(HebrewThousand.getDeclension(upperValue, htValue, str));
				res.append(' ');
			}
		}
		if(underValue > 0){
			res.append(generateUnderThousand(underValue, gender));
		}
		return res.toString().trim();
	}

	String generateUnderThousand(long number, Gender gender){
		StringBuilder res = new StringBuilder();
		if (number >= 100){
			res.append(HebrewDigits.get((number / 100) * 100, gender));
			res.append(" ");
			number = number - (number / 100) * 100; 
		}
		if (number >= 20){
			res.append(HebrewDigits.get((number / 10) * 10, gender));
			res.append(" ");
			number = number - (number / 10) * 10;
		}
		if(number > 0){
			if(number < 10 && res.length() > 0){
				res.append('ו');
			}
			res.append(HebrewDigits.get(number, gender));
		}
		
		return res.toString().trim();
	}
}


enum HebrewDigits{
	אפס(0, Gender.NEUTER),
	אחת(1, Gender.FEMININE), אחד(1, Gender.MASCULINE),
	שתיים(2, Gender.FEMININE), שניים(2, Gender.MASCULINE),
	שלוש(3, Gender.FEMININE), שלושה(3, Gender.MASCULINE),
	ארבע(4, Gender.FEMININE), ארבאה(4, Gender.MASCULINE),
	חמש(5, Gender.FEMININE), חמישה(5, Gender.MASCULINE),
	שש(6, Gender.FEMININE), שישה(6, Gender.MASCULINE),
	שבע(7, Gender.FEMININE), שיבעה(7, Gender.MASCULINE),
	שמונה(8, Gender.NEUTER),
	תשע(9, Gender.FEMININE), תשעה(9, Gender.MASCULINE),
	עשר(10, Gender.FEMININE), עשרה(10, Gender.MASCULINE),
	אחת_עשרה(11, Gender.FEMININE), אחד_עשר(11, Gender.MASCULINE),
	שתימ_עשרה(12, Gender.FEMININE), שנים_עשר(12, Gender.MASCULINE),
	שלוש_עשרה(13, Gender.FEMININE), שלושה_עשר(13, Gender.MASCULINE),
	ארבא_עשרה(14, Gender.FEMININE), ארבאה_עשר(14, Gender.MASCULINE),
	חמש_עשרה(15, Gender.FEMININE), חמשה_עשר(15, Gender.MASCULINE),
	שש_עשרה(16, Gender.FEMININE), ששה_עשר(16, Gender.MASCULINE),
	שבע_עשרה(17, Gender.FEMININE), שבעה_עשר(17, Gender.MASCULINE),
	שמונה_עשרה(18, Gender.FEMININE), שמונה_עשר(18, Gender.MASCULINE),
	תשע_עשרה(19, Gender.FEMININE), תשעה_עשר(19, Gender.MASCULINE),
	עשרים(20, Gender.NEUTER),
	שלושים(30, Gender.NEUTER),
	ארבעים(40, Gender.NEUTER),
	חמישים(50, Gender.NEUTER),
	שישים(60, Gender.NEUTER),
	שבעים(70, Gender.NEUTER),
	שמונים(80, Gender.NEUTER),
	תשעים(90, Gender.NEUTER),
	מאה(100, Gender.NEUTER),
	מאתיים(200, Gender.NEUTER),
	שלוש_מאות(300, Gender.NEUTER),
	ארבע_מאות(400, Gender.NEUTER),
	חמש_מאות(500, Gender.NEUTER),
	שש_מאות(600, Gender.NEUTER),
	שבע_מאות(700, Gender.NEUTER),
	שמונה_מאות(800, Gender.NEUTER),
	תשע_מאות(900, Gender.NEUTER);
	
	private int value;
	private Gender gender;
	
	private HebrewDigits(int value, Gender gender) {
		this.value = value;
		this.gender = gender;
	}
	
	public int getValue(){
		return value;
	}
	public Gender getGender(){
		return gender;
	}
	
	static String get(long number, Gender gender){
		for(int i = 0; i < values().length; i++){
			if(values()[i].getValue()==number&&values()[i].getGender().equals(Gender.NEUTER)) 
				return values()[i].name().replaceAll("_", " ").trim();
			if(values()[i].getValue()==number&&values()[i].getGender().equals(gender)) 
				return values()[i].name().replaceAll("_", " ").trim();
		}
		return null;
	}
}

enum HebrewThousand{
	אלף(1000, "אלפים"),
	מיליון(1000000, "מיליונים"),
	מיליארד(1000000000, "מיליארדים"),
	טריליון(1000000000000l, "טריליונים"),
	קוודריליון(1000000000000000l, "קוודריליונים"),
	קווינטיליון(1000000000000000000l, "קווינטיליונים");
	
	private long value;
	private String multiples;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String getDeclension(long current, HebrewThousand hebrewThousand, String number) {
		if(hebrewThousand == HebrewThousand.אלף&&current==2) return "אלפיים"; //some hardcoding
		if(current==2) return "שני"+" "+hebrewThousand.multiples;
		if(current==1) return hebrewThousand.name();
		if(hebrewThousand == HebrewThousand.אלף) return number + "ה " + hebrewThousand.multiples;
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
