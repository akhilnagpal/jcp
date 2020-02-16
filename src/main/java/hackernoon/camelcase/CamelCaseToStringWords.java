package hackernoon.camelcase;

public class CamelCaseToStringWords {

	public static void main(String[] args) {
		String camelCase = "akhilNagpalIn";
		int count=1;
		for(Character currentChar: camelCase.toCharArray()) {
			if (Character.isUpperCase(currentChar)) {
				count++;
			}
		}
		System.out.println("Number of string words in camelCase words are : "+count);

	}

}
