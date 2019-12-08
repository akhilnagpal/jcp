package java8inaction.chapter7.spliterator;


public class IterativeWordCounter {

  public static void main(String[] args) {
    int count =
        countWords("AKHIL NAGPAL IS A BRAVEHEART SO DO NOT WORRY JUST KEEP ON DOING FOCUSED Preparation ");
    System.out.println(count);

  }

  private static int countWords(String sentence) {
    int counter = 0;
    boolean lastSpace = false;
    for (char ch : sentence.toCharArray()) {
      if (Character.isWhitespace(ch)) {
        lastSpace = true;
      } else {
        if (lastSpace) {
          counter++;
        }
        lastSpace = false;
      }
    }
    return counter;
  }
}
