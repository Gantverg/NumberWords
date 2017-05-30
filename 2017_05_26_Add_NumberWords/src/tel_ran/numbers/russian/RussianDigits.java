package tel_ran.numbers.russian;

import tel_ran.numbers.Gender;

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
