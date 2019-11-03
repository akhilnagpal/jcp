package java8inaction.chapter8.chainofresponsibility;

public class HeaderProcessor extends Processor<String> {

  @Override
  public String handle(String input) {
    input = "Add Header info:" + input;
    return input;
  }
}
