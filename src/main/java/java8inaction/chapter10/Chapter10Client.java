package java8inaction.chapter10;

import java.util.Optional;

public class Chapter10Client {

  @SuppressWarnings("unused")
public static void main(String[] args) {
    Optional<Car> nullCar = Optional.empty();
    Car car = new Car();
    Optional<Car> optCar = Optional.of(car);
    Optional<Car> optCar2 = Optional.ofNullable(car);
    Insurance insurance = new Insurance();

    Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
    Optional<String> insuranceName = optInsurance.map(Insurance::getName);

    Person pp = new Person();
    pp.setCar(Optional.empty());

    Optional<Person> optPerson = Optional.ofNullable(pp);
    Optional<Optional<Car>> c = optPerson.map(p -> p.getCar());
    System.out.println(c.isPresent());
    Optional<Car> optCar3 = optPerson.flatMap(p -> p.getCar());
    Optional<Insurance> optInsurance2 = optCar3.flatMap(Car::getInsurance);
    Optional<String> name2 = optInsurance2.map(Insurance::getName);
    String name3 =
        optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
            .orElse("Unknown");
    System.out.println(name3);

    // if (insurance != null && insurance.getName().equals("AKHIL")) {
    // System.out.println("akhil");
    // }
    optInsurance = Optional.empty();
    optInsurance.filter(ins -> ins.getName().equals("AKHIL")).ifPresent(
        ins -> System.out.println("akhil"));
  }

  public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person,
      Optional<Car> car) {
    return person.flatMap((Person p) -> car.map((Car c) -> findCheapestInsurance(p, c)));
  }

  public Insurance findCheapestInsurance(Person person, Car car) {
    return null;
  }

  public String getCarInsuranceName(Optional<Person> person, int minAge) {
    return person.filter(p -> p.getAge() > minAge).flatMap(Person::getCar)
        .flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknow");
  }
}
