package tel_ran.numbers;

public interface NumberWords {
	default String numberInWords(long number){
		return generate(number, Gender.NEUTER);
	}
	default String numberInWords(long number, Gender gender){
		return generate(number, gender);
	}
	String generate(long number, Gender gender);
}
