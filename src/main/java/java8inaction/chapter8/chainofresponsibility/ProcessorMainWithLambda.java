package java8inaction.chapter8.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;


// No class is actually needed , replaced all chain interface and its implementation
// with a function and then its pipeline andThen , called composing functions
public class ProcessorMainWithLambda {
  public static void main(String[] args) {
    UnaryOperator<String> headerProcessor = (String input) -> "Add Header info:" + input;
    UnaryOperator<String> footerProcessor = (String input) -> input += ":footer added";
    Function<String, String> chainedProcessing = headerProcessor.andThen(footerProcessor);
    String output = chainedProcessing.apply("AKHIL");
    System.out.println(output);
  }
}
