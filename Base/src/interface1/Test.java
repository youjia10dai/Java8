package interface1;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-10 14:47
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        InterfaceBase.getName2();

        InterfaceBase t = new InterfaceBase(){
        };
        t.getName();
    }
}
