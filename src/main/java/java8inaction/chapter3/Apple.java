package java8inaction.chapter3;

public class Apple extends Fruit {

  private String colour;
  private int weight;
  private boolean rotten;


  public boolean isRotten() {
    return rotten;
  }


  public void setRotten(boolean rotten) {
    this.rotten = rotten;
  }


  public Apple(String colour, int weight, boolean rotten) {
    super();
    this.colour = colour;
    this.weight = weight;
    this.rotten = rotten;
  }


  public String getColour() {
    return colour;
  }


  public void setColour(String colour) {
    this.colour = colour;
  }


  public Integer getWeight() {
    return weight;
  }


  public void setWeight(int weight) {
    this.weight = weight;
  }


  public Apple(String colour, int weight) {
    super();
    this.colour = colour;
    this.weight = weight;
  }


  public Apple(int weight) {
    super();
    this.weight = weight;
  }


  public Apple() {
    super();
  }


  @Override
  public String toString() {
    return "Apple [colour=" + colour + ", weight=" + weight + "]";
  }



}
