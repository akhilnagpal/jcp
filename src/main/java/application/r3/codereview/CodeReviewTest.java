package application.r3.codereview;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Imagine you are a peer of the developer who committed this (syntactically correct) Java code and asked you to review
// their pull request. You work on the same product but are not familiar with this piece of work or its associated
// requirements.
//
// Please use Java comments for your review feedback, putting them on separate lines around the code. Do not modify the
// code itself.

public class CodeReviewTest {

    volatile Integer totalAge = 0;
    
    // Constructor should throw IOException
    CodeReviewTest(PersonDatabase<Person> personPersonDatabase)   {
        Person[] persons = null;
        try {
            persons = personPersonDatabase.getAllPersons();
        } catch (IOException e) {        	
        		// print log optionally and Throw back the IOException like this
        	// throw e;

        }

        List<Person> personsList = new LinkedList();
        
        // You should have i < persons.length-1, otherwise you might end up in java.lang.ArrayIndexOutOfBoundsException during runtime
//        for (int i = 0; i <= persons.length; i++) {
        	//CHANGEBYAKHIL BELOW
        	for (int i = 0; i <= persons.length-1; i++) {
            personsList.add(persons[i]);
        }
        	
        	System.out.println(personsList);
        
        // there is synchrnoization issues as even though totalAge is volatile
        	// with parallel stream multiple threads are working on personList
        	// personList is not syncronized and thread will act on a master copy of totalage (which is a dirty read , 
        	// as previous thread would not have written back from their calculation.
        	// total age will always be less
        	// This will be clearly visible during production in case of Person array size in hundred.
        	// Either use personsList.stream() or synchrnonized personList around totalAge += person.getAge();
        personsList.stream().forEach(person -> {
//        	synchronized(personsList) {
        		totalAge += person.getAge();
//        	}
            
        });

        
        // using linked list is fine as we are inserting it
        List<Person> males = new LinkedList<>();
        
        // person.gender was not never initialised, so it is null,
        // this will surely throw Null Pointer Exception 
        
        

        // You cannot remove an item from the collection directly 
        // while iterating through the elements as this will cause a ConcurrentModificationException. 
        // Iterator.remove() is the accepted safe way to modify a collection during iteration. 
        
        


//        for (Person person : personsList) {
//            switch (person.gender) {
//                // this logicis wrong, you are removing females from personList and then using it far below to know the female sizes
                  // look at code snippet below which can solve thewhole problem
//                case "Female": personsList.remove(person);
        // PUT A break; otherwise male will always get added
//                case "Male"  : males.add(person);
        //add break;
//            }
//        }
        
        // REMOVED BELOW
        Iterator<Person> iterator = personsList.iterator();
        while (iterator.hasNext()) {
        	Person person = iterator.next();
            switch (person.gender) {         
                case "Female": ;
                break;
                case "Male"  : males.add(person); iterator.remove();
            }
        }
        
        

        System.out.println("Total age =" + totalAge);
        System.out.println("Total number of females =" + personsList.size());
        System.out.println("Total number of males =" + males.size());
    }

}


// Better do final class, if you want to use in threads so that they are not inherited(mutable)
class Person {
	
	// Better to do final attributes along with private do to make it immutable , to make it thread safe
    private int age;
    private String firstName;
    private String lastName;
    //1. Why gender is not private - make class immutable by private / final or setting through constructors
    //2. Why it is part of Person if not set or get
    String gender;
    
    /// ADDED BY AKHIL BELOW
    public void setGender(String gender) {
    	this.gender=gender;
    }
    
    public String getGender() {
    	return gender;
    }

    public Person(int age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    // Why we do not have getter methods on firstName and lastName
    public int getAge() {
        return age;
    }

    
    // This equals will only work assuming String literals like "NAGPAL" are being set as lastName
    // If it is a comparison between String literal and String object, the below comparison will fail.
    // Instead use return null!=obj &&  lastName.equals(((Person)obj).lastName);
    // Also it is not right only to compare lastName as for Person equality.
    // PLease compare firstName and age, as we passing these in constructors too, based on above guidelines
    @Override
    public boolean equals(Object obj) {
        return this.lastName == ((Person)obj).lastName;
    	
    }
    
    //Please add hashCode - to make it retrieve from HashMap
//    @Override
//    public int hashCode() { return firstName.hashCode()+lastName.hashCode()+31*age;}

}

interface PersonDatabase<E> {

	// To make return it generic (templated) change like below
//	E[] getAllPersons() throws IOException;
    Person[] getAllPersons() throws IOException;

}