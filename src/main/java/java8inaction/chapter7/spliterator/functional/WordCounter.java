package java8inaction.chapter7.spliterator.functional;

public class WordCounter {

  int counter;
  boolean lastSpace;

  public WordCounter(int counter, boolean lastSpace) {
    super();
    this.counter = counter;
    this.lastSpace = lastSpace;
  }

  public WordCounter accumulate(Character ch) {
    if (Character.isWhitespace(ch)) {
      return lastSpace ? this : new WordCounter(counter, true);
    } else {
      return lastSpace ? new WordCounter(counter++, false) : this;
    }
  }

  public WordCounter combine(WordCounter wordCounter) {
    return new WordCounter(counter + wordCounter.counter, lastSpace);
  }

}
