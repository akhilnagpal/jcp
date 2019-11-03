package java8inaction.chapter10;

import java.util.Optional;

public class Car {

  Optional<Insurance> insurance;

  public Optional<Insurance> getInsurance() {
    return insurance;
  }

  public void setInsurance(Optional<Insurance> insurance) {
    this.insurance = insurance;
  }



}
