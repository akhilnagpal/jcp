package java8inaction.chapter8.testinglamdas.visiblelambdas;

import static java.util.Comparator.comparing;
import java.util.Comparator;


public class Point {

  public static Comparator<Point> comparingXThenY = comparing(Point::getX).thenComparing(
      Point::getY);

  public static Comparator<Point> comparingXUsingLamda = (Point p1, Point p2) -> p1.getX()
      .compareTo(p2.getX());
  public static Comparator<Point> comparingXThenYUsingLamda = comparingXUsingLamda.thenComparing((
      Point p1, Point p2) -> p1.getY().compareTo(p2.getY()));

  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
