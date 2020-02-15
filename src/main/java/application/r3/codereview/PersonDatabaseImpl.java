package application.r3.codereview;

import java.io.IOException;

import application.r3.codereview.Person;
import application.r3.codereview.PersonDatabase;

public class PersonDatabaseImpl implements PersonDatabase<Person> {

	@Override
	public Person[] getAllPersons() throws IOException {
		
		Person [] persons = new Person[500];
		boolean male =false;
		for(int i=0;i<500;i++) {			
			Person p1 = new Person(i+1,"A"+i,"Nagpal");
			if(male) {
				p1.setGender("Male");
			} else {
				p1.setGender("Female");
			}
			System.out.println(p1.gender);
			persons[i]=p1;
			male=!male;
		}
		
		
		return persons;
	}

}
