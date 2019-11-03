package java8inaction.chapter10;

import java.util.Optional;

public class Person {
  Optional<Car> car;
  int age;

  public Optional<Car> getCar() {
    return car;
  }

  public void setCar(Optional<Car> car) {
    this.car = car;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }



}
