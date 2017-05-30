package tel_ran.numbers.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tel_ran.numbers.Gender;
import tel_ran.numbers.NumberWords;
import tel_ran.numbers.NumberWordsHebrew;
import tel_ran.numbers.NumberWordsRussian;

public class NumberWordsTest {
	
	@Test
	public void testNumberWordsRussian() {
		NumberWords numberWords = new NumberWordsRussian();
		assertEquals("ноль", numberWords.numberInWords(0));
		assertEquals("один", numberWords.numberInWords(1));
		assertEquals("один", numberWords.numberInWords(1, Gender.MASCULINE));
		assertEquals("одна", numberWords.numberInWords(1, Gender.FEMININE));
		assertEquals("два", numberWords.numberInWords(2));
		assertEquals("две", numberWords.numberInWords(2, Gender.FEMININE));
		assertEquals("три", numberWords.numberInWords(3));
		assertEquals("три", numberWords.numberInWords(3, Gender.FEMININE));
		assertEquals("четыре", numberWords.numberInWords(4));
		assertEquals("пять", numberWords.numberInWords(5));
		assertEquals("шесть", numberWords.numberInWords(6));
		assertEquals("семь", numberWords.numberInWords(7));
		assertEquals("восемь", numberWords.numberInWords(8));
		assertEquals("девять", numberWords.numberInWords(9));
		assertEquals("десять", numberWords.numberInWords(10));
		assertEquals("одиннадцать", numberWords.numberInWords(11));
		assertEquals("двенадцать", numberWords.numberInWords(12));
		assertEquals("тринадцать", numberWords.numberInWords(13));
		assertEquals("четырнадцать", numberWords.numberInWords(14));
		assertEquals("пятнадцать", numberWords.numberInWords(15));
		assertEquals("шестнадцать", numberWords.numberInWords(16));
		assertEquals("семнадцать", numberWords.numberInWords(17));
		assertEquals("восемнадцать", numberWords.numberInWords(18));
		assertEquals("девятнадцать", numberWords.numberInWords(19));
		assertEquals("двадцать", numberWords.numberInWords(20));
		assertEquals("двадцать один", numberWords.numberInWords(21));
		assertEquals("двадцать два", numberWords.numberInWords(22));
		assertEquals("двадцать одна", numberWords.numberInWords(21, Gender.FEMININE));
		assertEquals("двадцать две", numberWords.numberInWords(22, Gender.FEMININE));
		assertEquals("двадцать три", numberWords.numberInWords(23));
		assertEquals("двадцать четыре", numberWords.numberInWords(24));
		assertEquals("двадцать пять", numberWords.numberInWords(25));
		assertEquals("двадцать шесть", numberWords.numberInWords(26));
		assertEquals("двадцать семь", numberWords.numberInWords(27));
		assertEquals("двадцать восемь", numberWords.numberInWords(28));
		assertEquals("двадцать девять", numberWords.numberInWords(29));
		assertEquals("тридцать", numberWords.numberInWords(30));
		assertEquals("сорок", numberWords.numberInWords(40));
		assertEquals("пятьдесят", numberWords.numberInWords(50));
		assertEquals("шестьдесят", numberWords.numberInWords(60));
		assertEquals("семьдесят", numberWords.numberInWords(70));
		assertEquals("восемьдесят", numberWords.numberInWords(80));
		assertEquals("девяносто", numberWords.numberInWords(90));
		assertEquals("сто", numberWords.numberInWords(100));
		assertEquals("сто один", numberWords.numberInWords(101));
		assertEquals("сто два", numberWords.numberInWords(102));
		assertEquals("сто три", numberWords.numberInWords(103));
		assertEquals("сто десять", numberWords.numberInWords(110));
		assertEquals("сто одиннадцать", numberWords.numberInWords(111));
		assertEquals("сто двадцать", numberWords.numberInWords(120));
		assertEquals("двести", numberWords.numberInWords(200));
		assertEquals("триста", numberWords.numberInWords(300));
		assertEquals("четыреста", numberWords.numberInWords(400));
		assertEquals("пятьсот", numberWords.numberInWords(500));
		assertEquals("шестьсот", numberWords.numberInWords(600));
		assertEquals("семьсот", numberWords.numberInWords(700));
		assertEquals("восемьсот", numberWords.numberInWords(800));
		assertEquals("девятьсот", numberWords.numberInWords(900));
		assertEquals("девятьсот пятьдесят восемь", numberWords.numberInWords(958));
		assertEquals("одна тысяча", numberWords.numberInWords(1000));
		assertEquals("одна тысяча двести тридцать четыре", numberWords.numberInWords(1234));
		assertEquals("две тысячи", numberWords.numberInWords(2000));
		assertEquals("две тысячи пятнадцать", numberWords.numberInWords(2015));
		assertEquals("две тысячи сто", numberWords.numberInWords(2100));
		assertEquals("две тысячи триста сорок пять", numberWords.numberInWords(2345));
		assertEquals("пять тысяч", numberWords.numberInWords(5000));
		assertEquals("одиннадцать тысяч", numberWords.numberInWords(11000));
		assertEquals("пятнадцать тысяч", numberWords.numberInWords(15000));
		assertEquals("двадцать тысяч", numberWords.numberInWords(20000));
		assertEquals("двести тысяч", numberWords.numberInWords(200000));
		assertEquals("один миллион", numberWords.numberInWords(1000000));
		assertEquals("два миллиона", numberWords.numberInWords(2000000));
		assertEquals("пять миллионов триста", numberWords.numberInWords(5000300));
		assertEquals("пять миллионов шестьсот семьдесят восемь тысяч девятьсот двенадцать", numberWords.numberInWords(5678912));
		assertEquals("девятьсот миллионов восемьсот тысяч семьсот", numberWords.numberInWords(900800700));
		assertEquals("пятнадцать миллиардов", numberWords.numberInWords(15000000000l));
		assertEquals("двадцать один триллион", numberWords.numberInWords(21000000000000l));
	}
	
	@Test
	public void TestNumberWordsHebrew(){
		NumberWords numberWords = new NumberWordsHebrew();
		assertEquals("אפס", numberWords.numberInWords(0));
		assertEquals("אחת", numberWords.numberInWords(1, Gender.FEMININE));
		assertEquals("אחד", numberWords.numberInWords(1, Gender.MASCULINE));
		assertEquals("שתיים", numberWords.numberInWords(2, Gender.FEMININE));
		assertEquals("שניים", numberWords.numberInWords(2, Gender.MASCULINE));
		assertEquals("אחת עשרה", numberWords.numberInWords(11, Gender.FEMININE));
		assertEquals("אחד עשר", numberWords.numberInWords(11, Gender.MASCULINE));
		assertEquals("עשרים ואחת", numberWords.numberInWords(21, Gender.FEMININE));
		assertEquals("עשרים ואחד", numberWords.numberInWords(21, Gender.MASCULINE));
		assertEquals("מאה שלושים וחמש", numberWords.numberInWords(135, Gender.FEMININE));
		assertEquals("אלף מאתיים ארבעים ושש", numberWords.numberInWords(1246, Gender.FEMININE));
		assertEquals("אלפיים שלוש מאות שבעים ושמונה", numberWords.numberInWords(2378, Gender.FEMININE));
		assertEquals("תשע מאות שמונים ושבעה אלפים שש מאות חמישים וארבע", numberWords.numberInWords(987654, Gender.FEMININE));
		assertEquals("מיליון מאתיים שלושים וארבעה אלפים חמש מאות שישים ושבע", numberWords.numberInWords(1234567, Gender.FEMININE));
		assertEquals("שני מיליונים מאתיים שלושים וארבעה אלפים חמש מאות שישים ושבע", numberWords.numberInWords(2234567, Gender.FEMININE));
		assertEquals("עשרים וחמישה מיליונים מאתיים שלושים וארבעה אלפים חמש מאות שישים ושבע", numberWords.numberInWords(25234567, Gender.FEMININE));
	}
}
