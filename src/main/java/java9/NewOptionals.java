package java9;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewOptionals {

	public static void main(String[] args) {
		//Java 8 way
		Stream<Optional<Integer>> optionalStream  = Stream.of(Optional.of(1),Optional.empty(),Optional.of(2));
		optionalStream.filter(optional-> optional.isPresent()).forEach(optional-> System.out.println(optional.get()));
		//Java 9 way
		optionalStream  = Stream.of(Optional.of(1),Optional.empty(),Optional.of(2));
		//using stream method
		Stream<Integer> integers = optionalStream.flatMap(Optional::stream);
		integers.forEach(System.out::println);
		
		//another example , get all non-null authors of books
		Set<String> authors = getBooksList().stream().map(book->book.getAuthors().stream().findAny()).flatMap(optional->optional.stream()).
				collect(Collectors.toSet());
		authors.forEach(System.out::println);
		
		// VV IMP
		//Key take way - stream.flatMap and optional.stream are made for each other 
		
		// new method on optional ifPresentOrelse
		Optional<Book> optionalBook = getExternalBook();
		optionalBook.ifPresentOrElse(System.out::println,()-> System.out.println("Nothing here"));
		Optional.empty().ifPresentOrElse(book->System.out.println(book),()-> System.out.println("Nothing here"));
		
		//new method Or
		Optional<Book> bestBookOffer =  getEmptyBook().or(() -> getExternalBook());
		bestBookOffer.stream().forEach(System.out::println);

	}
	
	static Optional<Book> getEmptyBook() {
		return Optional.empty();
	}
	
	
	static Optional<Book> getExternalBook() {
		return Optional.of( new Book("Java 11 in action", Set.of("Akhil","Jackson"), 15.0));
	}
	
	static List<Book>  getBooksList() {
		//Using new Of factory methods instead of Arrays.asList
		return List.of(new Book("Java 8 in action", Set.of("Peter","Jackson"), 15.0),
				new Book("Java 9 -First Look", Set.of("Sandham","Nagpal"), 5.0),new Book("Java 10 in action", Set.of(), 15.0));
	}

}
