# NumberWords
Typing numbers in some languages
I use interface NumberWords. There if method numberInWords with two signatures: 
numberInWords(long number) and numberInWords(long number, Gender gender).
Both uses method generate(long number, Gender gender).
Class NumberWordsLanguage is abstract, implements interface NumberWords 
and add field String Language - usualy 2-chars string
Every class extends NumberWordsLanguage has to realize method generate.
For classes NumberWordsHebrew, NumberWordsRussian and NumberWordsEnglish
I create local enums Digits and Thousand (RusshianDigits, EnglishThousan etc).
These enums contain method get, that returns actualy typing of different type 
of numbers.
