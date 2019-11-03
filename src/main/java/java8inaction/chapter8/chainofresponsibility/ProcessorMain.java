package java8inaction.chapter8.chainofresponsibility;

public class ProcessorMain {

  public static void main(String[] args) {
    Processor<String> headerProcessor = new HeaderProcessor();
    Processor<String> footerProcessor = new FooterProcessor();
    headerProcessor.setSucessor(footerProcessor);
    headerProcessor.chain("AKHIL");
  }
}
