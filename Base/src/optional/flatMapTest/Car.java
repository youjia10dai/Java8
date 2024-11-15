package optional.flatMapTest;

import java.util.Optional;

/**
 * @Author: chenlj
 * @CreateTime: 2024-11-15 00:53
 * @Description: todo
 */
public class Car {
    Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
