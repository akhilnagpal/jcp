package java8inaction.chapter3;

public class Orange extends Fruit {

  private int weight;

  public Orange(int weight) {
    super();
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Orange [weight=" + weight + "]";
  }



}
