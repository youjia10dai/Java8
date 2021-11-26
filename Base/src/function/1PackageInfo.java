/**
 * 什么是函数式接口
 * 简单来说就是只定义了一个抽象方法的接口（Object类的public方法除外），就是函数式接口，并且还提供了注解：@FunctionalInterface
 * 注意   接口拥有默认实现方法,并不影响他是一个函数式接口  案例查看 lambda/LambdaBase4对象
 * 常见的四大函数式接口
 *      1.Consumer<T>       消费型接口，有参无返回值
 *      2.Supplier<T>       供给型接口，无参有返回值
 *      3.Function<T, R>    函数式接口，有参有返回值
 *      4.Predicate<T>      断言型接口，有参有返回值，返回值是boolean类型
 */
package function;