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
		if(number == 0) return RussianDigits.����.name();
		
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
	����(0), ����(1), ���(2), ���(3), ������(4), ����(5), �����(6), ����(7), ������(8), ������(9), 
	������(10), �����������(11), ����������(12), ����������(13), ������������(14), ����������(15), �����������(16), ����������(17), ������������(18), ������������(19),
	��������(20), ��������(30), �����(40), ���������(50), ����������(60), ���������(70), �����������(80), ���������(90),
	���(100), ������(200), ������(300), ���������(400), �������(500), ��������(600), �������(700), ���������(800), ���������(900);
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
				return "����";
			}
			if(number==2){
				return "���";
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
	������(1000l, Gender.FEMININE), �������(1000000l, Gender.MASCULINE), ��������(1000000000l, Gender.MASCULINE), 
	��������(1000000000000l, Gender.MASCULINE), �����������(1000000000000000l, Gender.MASCULINE), �����������(1000000000000000000l, Gender.MASCULINE);
	private long value;
	private Gender gender;

	/**
	 * @return the value
	 */
	long getValue() {
		return value;
	}

	static String getDeclension(long current, RussianThousand russianThousand) {
		if(current%100>10&&current%100<13&&russianThousand==RussianThousand.������) return "�����"; //11 000, 12 000
		if(current%100>10&&current%100<13) return russianThousand.name()+"��"; //11 000 000, 12 000 000, 11 000 000 000 etc
		if(current%10==1) return russianThousand.name(); //1 000, 21 000, 31 000, 101 000, 1 000 000, 21 000 000 etc
		if(current%10>1&&current%10<5&&russianThousand==RussianThousand.������) return "������"; //2 000, 22 000
		if(current%10>1&&current%10<5) return russianThousand.name()+"�"; //2 000 000, 22 000 000, 4 000 000 000 etc
		if(russianThousand == RussianThousand.������) return "�����"; //5 000, 15 000, 16 000, 27 000 etc
		return russianThousand.name()+"��"; //5 000 000, 25 000 000 000 etc
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

