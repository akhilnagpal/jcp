package java8inaction.chapter10;

import java.util.Optional;
import java.util.Properties;

public class PropertiesClient {

  public static void main(String[] args) {
    Properties prop = new Properties();

  }

  public int readDuration(Properties props, String name) {
    return Optional.ofNullable(props.getProperty(name)).flatMap(PropertiesClient::stringtoInt)
        .filter(i -> i > 0).orElse(0);
  }

  public static Optional<Integer> stringtoInt(String input) {
    try {
      int num = Integer.parseInt(input);
      return Optional.of(num);
    } catch (NumberFormatException ne) {
      return Optional.empty();
    }
  }
}
