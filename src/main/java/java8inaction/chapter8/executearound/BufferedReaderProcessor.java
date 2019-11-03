package java8inaction.chapter8.executearound;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {
  // Keep the lamdas simple by throwing all the exception thrown by passing arguments
  // Do not handle try catch
  public String process(BufferedReader br) throws IOException;
}
