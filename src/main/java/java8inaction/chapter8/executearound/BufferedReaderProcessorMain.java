package java8inaction.chapter8.executearound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderProcessorMain {
  // What varies I have separated out below in the lambdas function
  static BufferedReaderProcessor brpSingleLine = (BufferedReader br) -> br.readLine();
  static BufferedReaderProcessor brpDoubleLine = (BufferedReader br) -> br.readLine()
      + br.readLine();


  public static void main(String args[]) throws IOException {

    String singleContent = processFile(BufferedReaderProcessorMain::readSingleLine);
    System.out.println(singleContent);
    String doubleContent = processFile(brpDoubleLine);
    System.out.println(doubleContent);
  }

  public static String processFile(BufferedReaderProcessor brp) throws IOException {
    // What remains constant is here, i.e. creation of the BufferedReader,
    // Variable behaviour of BufferedReader is controlled by the lamdas
    BufferedReader br =
        new BufferedReader(new FileReader(
            "C:/Users/angl/workspace/akhil/src/tryoutlamdas/chapter8/data.txt"));
    return brp.process(br);
  }

  public static String readSingleLine(BufferedReader br) throws IOException {
    return br.readLine();
  }
}
