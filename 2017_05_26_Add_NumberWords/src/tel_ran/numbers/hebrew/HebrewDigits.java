package tel_ran.numbers.hebrew;

import tel_ran.numbers.Gender;

enum HebrewDigits{
	אפס(0, Gender.NEUTER),
	אחת (1, Gender.FEMININE), אחד (1, Gender.MASCULINE),
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
		for(HebrewDigits current : values()){
			if(current.getValue() == number && current.getGender().equals(Gender.NEUTER)) 
				return current.name().replaceAll("_", " ").trim();
			if(current.getValue() == number && current.getGender().equals(gender)) 
				return current.name().replaceAll("_", " ").trim();
		}
		return null;
	}
}