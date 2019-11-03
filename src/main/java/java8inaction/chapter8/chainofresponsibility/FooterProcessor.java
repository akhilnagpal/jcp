package java8inaction.chapter8.chainofresponsibility;

public class FooterProcessor extends Processor<String> {

  @Override
  public String handle(String input) {
    input += ":footer added";
    return input;
  }

}
