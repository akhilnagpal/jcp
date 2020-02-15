package application.r3.codereview;

import application.r3.codereview.Person;

public class PersonTest {

	public static void main(String[] args) {
		String lastName = new String("Nagpal");
		Person p1 = new Person(40,"Akhil","Nagpal");
		Person p2 = new Person(23,"Gaurav","Nagpal");
		Person p3 = new Person(33,"Aryan",lastName);
		
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));

	}

}
