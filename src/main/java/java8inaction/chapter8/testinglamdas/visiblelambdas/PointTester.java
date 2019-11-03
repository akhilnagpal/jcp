package java8inaction.chapter8.testinglamdas.visiblelambdas;

import org.junit.Test;

public class PointTester {

  @Test
  public void testComparatorLambda() {
    Point firstPoint = new Point(1, 2);
    Point secondPoint = new Point(2, 3);
    Point thirdPoint = new Point(2, 3);
    int result = Point.comparingXThenY.compare(firstPoint, secondPoint);
    System.out.println(result);
    result = Point.comparingXThenY.compare(thirdPoint, secondPoint);
    System.out.println(result);
    result = Point.comparingXThenYUsingLamda.compare(secondPoint, thirdPoint);
    System.out.println(result);
    result = Point.comparingXThenYUsingLamda.compare(firstPoint, secondPoint);
    System.out.println(result);
  }
}
