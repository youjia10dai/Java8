package interface1;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-10 14:47
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        InterfaceBase.getName2();
        // 接口可以直接创建出来,而不需要实现类了(通过匿名类型的形式创建出来,这里的匿名类指的是,没有显示的实现)
        InterfaceBase t = new InterfaceBase(){};
        t.getName();
    }
}