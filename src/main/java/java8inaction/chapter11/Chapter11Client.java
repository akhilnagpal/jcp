package java8inaction.chapter11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Chapter11Client {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newCachedThreadPool();
    // CompletableFuture<String> completeFuture = new CompletableFuture<>();
    // completeFuture.complete(Thread.currentThread().getName() + " HELLO AKHIL");

    // CompletableFuture<Void> secondCompleteFuture =
    // CompletableFuture.runAsync(
    // () -> System.out.println(Thread.currentThread().getName() + " WORLD"), executor);

    Supplier<String> supplier = () -> Thread.currentThread().getName() + " Hello from third future";

    CompletableFuture<String> thirdCompleteFuture =
        CompletableFuture.supplyAsync(supplier).thenApply((name) -> name + " greeting");

    CompletableFuture<Void> thenAcceptCompletableFuture =
        thirdCompleteFuture.thenAcceptAsync((String text) -> System.out.println(text));

    thenAcceptCompletableFuture.thenRunAsync(() -> System.out.println(Thread.currentThread()
        .getName() + " LALLU"));

    // try {
    // String result = completeFuture.get();
    // System.out.println(result);
    // secondCompleteFuture.get();
    // System.out.println(thirdCompleteFuture.get());
    // thenAcceptCompletableFuture.get();
    // thenAcceptCompletableFuture.thenRun(() -> System.out.println("LALLU"));
    // }

    // Try out ThenCompose - one future dependent upon the another
    // - get a user from a name and then pass this user to the getCreditRating Service.
    CompletableFuture<Integer> creditRating1 =
        getUser("AKHIL").thenCompose(user -> getCreditRating(user));

    creditRating1.get();

    // Try out Then Combine - independent futures and then use them for some calculations

    // CompletableFuture<Double> bmiFuture =
    // getWeight().thenCombineAsync(getHeight(), (weight, height) -> weight / height);
    //
    // System.out.println(bmiFuture.get());

    CompletableFuture<Double> bmiFuture =
        CompletableFuture.supplyAsync(Chapter11Client::getWeight).thenCombine(
            CompletableFuture.supplyAsync(Chapter11Client::getHeight),
            (weight, height) -> weight / height);
    // Main did it own work and finally waited
    // System.out.println(bmiFuture.get());
    try {
      Thread.sleep(8000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  static Double getWeight() {
    System.out.println(Thread.currentThread().getName() + " getWeight invoked");
    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " getWeight Calculated");
    return 81.7;
  }

  static Double getHeight() {
    System.out.println(Thread.currentThread().getName() + " getHeight invoked");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " getHeight Calculated");
    return 1.80;
  }

  static CompletableFuture<User> getUser(String userId) {
    System.out.println(Thread.currentThread().getName() + "Test getUser");
    return CompletableFuture.supplyAsync(() -> UserService.getUserService());
  }

  static CompletableFuture<Integer> getCreditRating(User user) {
    System.out.println("Test getCreditRating");
    return CompletableFuture.supplyAsync(() -> CreditRatingService.getCreditRating(user));
  }
}
