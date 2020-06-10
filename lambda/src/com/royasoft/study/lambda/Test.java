package com.royasoft.study.lambda;

import java.util.Arrays;

/**
 * @Author: chenlj
 * @CreateTime: 2020-06-10 15:30
 * @Description:
 */
public class Test {

    private String name = "clj";

    interface TT {

        Object get(Test name);

    }

    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Test test = new Test("1");
        test.setName("212121");
        /*
         * 一.使用引用方法来实现接口(即匿名对象)注意实现
         * 1.如果接口只有一个方法,那么引用的方法名这接口的方法名可以不一样(如果有多个那么必须相同)
         * 2.当接口参数和 (T::method) T 是相同的时候,那么method就不需要传参数(这个是特殊的用法)
         * Test::gg 默认应该是静态方法的引用
         * test::gg 默认是对象的方法引用
         */
        test.test(Test::gg);
    }

    public void test (TT tt) {
        Object o = tt.get(new Test("33"));
        System.out.println("tt = " + o);
    }

    public Object gg() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}