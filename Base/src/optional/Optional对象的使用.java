package optional;

import test.Student;
import java.util.Optional;

/**
 * @Author: chenlj
 * @CreateTime: 2022-12-09 10:07
 * @Description: todo
 */
public class Optional对象的使用 {

    public static void main(String[] args) {
        Student student = null;
        // 1.将可嫩为空的对象转换为Optional对象 student可以为空
        Optional<Student> optional = Optional.ofNullable(student);

        // student不能为空,可以使用如下的调用
//        Optional<Student> optional = Optional.of(student);


        // 2.Optional 链式操作
        Integer age = optional.map(Student::getAge).orElse(20);
        System.out.println("age = " + age);

        // 过滤student对象,不满足怎返回一个空的Optional  ifPresent只有存在才执行
        optional.filter((s) -> {
            return s.getAge() < 3;
        }).ifPresent(s->{
            System.out.println("s=" + s);
        });


        // 3.Optional短路
        // 从数据库中查询出某个用户,如果不存在则想数据库中新建用户并返回
        // Student student1 =  optional.orElse(newStudent()); 会有问题 问题在于newStudent()会100%执行

        // 正确的 如果存在就不会去new
        student = optional.orElseGet(()->new Student(5));
        System.out.println("student = " + student);

        //4.Optional抛出异常
        optional.orElseThrow(()-> new RuntimeException("没有这个学生"));
    }
}
