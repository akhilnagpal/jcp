package java9;

import java.util.Set;

public class Book {
	
	private final String title;
	private Set<String> authors;
	private final double price;
	
	public Book(String title, Set<String> authors, double price) {
		super();
		this.title = title;
		this.authors = authors;
		this.price = price;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}
	
	

}
