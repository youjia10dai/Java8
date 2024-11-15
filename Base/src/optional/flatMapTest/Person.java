package optional.flatMapTest;

import java.util.Optional;

/**
 * @Author: chenlj
 * @CreateTime: 2024-11-15 00:53
 * @Description: todo
 */
public class Person {
    public Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public static void main(String[] args) {
        // 如果Person里面的属性都是Optional的,那么使用map的时候会Optional 嵌套Optional
        // Optional<Optional<Integer>> nestedOptional = optionalValue.map(value -> Optional.of(value.length()));

        //     public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        //        Objects.requireNonNull(mapper);
        //        if (!isPresent())
        //            return empty();
        //        else {
        //            return Optional.ofNullable(mapper.apply(value));
        //        }
        //    }
        Optional<Person>  person = Optional.of(new Person());

        person.flatMap(Person::getCar).flatMap(Car::getInsurance);

        person.map((personTemp-> personTemp.getCar().orElse(null))).map((carTemp-> carTemp.getInsurance().orElse(null)));
    }
}
