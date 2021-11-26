package lambda;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 16:09
 * @Description: lambda表达式 总结
 * 注：当一个接口中存在多个抽象方法时，如果使用lambda表达式，并不能智能匹配对应的抽象方法，因此引入了函数式接口的概念
 */
public class LambdaBase3 {

    /**
     * 无参数无返回值                                  	() -> System.out.println(“Hello WOrld”)
     * 有一个参数无返回值                                	(x) -> System.out.println(x)
     * 有且只有一个参数无返回值	                        x -> System.out.println(x)
     * 有多个参数，有返回值，有多条lambda体语句	            (x，y) -> {System.out.println(“xxx”);return xxxx;}；
     * 有多个参数，有返回值，只有一条lambda体语句         	(x，y) -> xxxx
     */

}