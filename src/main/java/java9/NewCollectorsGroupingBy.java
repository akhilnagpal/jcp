package java9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;

public class NewCollectorsGroupingBy {

	public static void main(String[] args) {
		//Using new Filtering API of Collectors in groupingBy
		Predicate<Book> bookPrice = book-> book.getPrice()>10.0;
		Map <Set<String>,Set<Book>> booksByAuthor = getBooksList().stream().collect(groupingBy(Book::getAuthors,filtering(bookPrice,Collectors.toSet())));
		//Iterating over map using forEach
		booksByAuthor.forEach((authors,books)-> books.stream().forEach(book-> System.out.println(book.getTitle())));
		
		//Using new flatMapping API of Collectors in groupingBy
		Map<Double,List<Book>> booksByPrice = getBooksList().stream().collect(groupingBy(Book::getPrice));
		booksByPrice.forEach((price,books)-> System.out.println(price +" "+ books.get(0).getTitle()));
		/// but we do not need books, we need price by authors which is set of strings under books
		Function<Book,Stream<String>> authorsOfBooks = book -> book.getAuthors().stream();
		Map<Double,Set<String>> authorsByPrice = getBooksList().stream().collect(groupingBy(Book::getPrice,flatMapping(authorsOfBooks,Collectors.toSet())));
		authorsByPrice.forEach((price,authors)-> System.out.println(price+" " + authors));
		
	}
	
	static List<Book>  getBooksList() {
		//Using new Of factory methods instead of Arrays.asList
		return List.of(new Book("Java 8 in action", Set.of("Peter"), 15.0),new Book("Java 9 -First Look", Set.of("Sandham"), 5.0));
	}

}
