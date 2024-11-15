package interface1;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 16:56
 * @Description:  在接口中可以使用default和static关键字来修饰接口中定义的普通方法
 */
public interface InterfaceBase {
    // 默认实现方法
    default String getName(){
        System.out.println("getName");
        return "getName";
    }
    // 静态实现方法
    static String getName2(){
        System.out.println("getName2");
        return "getName2";
    }
}
