package function;

import java.util.function.Predicate;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-11 11:06
 * @Description:
 */
public class PredicateTest {

    public static void main(String[] args) {
        testNegate();
        testAnd();
        testOr();
    }

    /**
     * negate返回!test()
     */
    public static void testNegate() {
        Predicate<String> firstPredicate = (s) -> {
            return false;
        };
        Predicate<String> secondPredicate = firstPredicate.negate();
        System.out.println(firstPredicate.test("1"));
        System.out.println(secondPredicate.test("1"));
    }

    /**
     * 必须全部满足,才会返回true
     * and的关系
     */
    public static void testAnd() {
        Predicate<String> firstPredicate = (s) -> {
            return false;
        };
        Predicate<String> secondPredicate = (s) -> {
            return true;
        };
        Predicate<String> and = firstPredicate.and(secondPredicate);
        System.out.println(and.test("11"));
    }

    /**
     * 满足其中一个,就会返回true
     * or的关系
     */
    public static void testOr() {
        Predicate<String> firstPredicate = (s) -> {
            return false;
        };
        Predicate<String> secondPredicate = (s) -> {
            return true;
        };
        Predicate<String> and = firstPredicate.or(secondPredicate);
        System.out.println(and.test("11"));
    }

}
