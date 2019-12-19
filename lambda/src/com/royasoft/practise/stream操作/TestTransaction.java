package com.royasoft.practise.stream操作;

import com.royasoft.practise.stream操作.entity.Trader;
import com.royasoft.practise.stream操作.entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTransaction {

    List<Transaction> transactions = null;

    @BeforeEach
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void test1() {
        transactions.stream().filter((e) -> e.getYear() == 2011)
                .sorted((e1, e2) -> e1.getValue() - e2.getValue())
                .forEach(System.out::println);
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void test2() {
        Map<String, List<Transaction>> collect = transactions.stream()
                .collect(Collectors.groupingBy((e) -> e.getTrader().getCity()));
        System.out.println(collect.keySet());

        transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        transactions.stream()
                .filter((e) -> "Cambridge".equals(e.getTrader().getCity()))
                .sorted((e1, e2) -> e1.getTrader().getName().compareTo(e2.getTrader().getName()))
                .map(Transaction::getTrader)
                .distinct()
                .forEach(System.out::println);

        transactions.stream()
                .filter((t) -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4() {
        transactions.stream()
                .map((e) -> e.getTrader().getName())
                .flatMap(TestTransaction::filterCharacter)// 返回的所有stream会加入到一个大的stream
                .sorted()
                .forEach(System.out::println);
    }

    public static Stream<String> filterCharacter(String str) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i] + "");
        }
        return list.stream();
    }

    //5. 有没有交易员是在米兰工作的？
    @Test
    public void test5() {
        boolean b = transactions.stream()
                .anyMatch((e) -> "Milan".equals(e.getTrader().getCity()));
        System.out.println(b);
    }


    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {
        Optional<Integer> reduce = transactions.stream()
                .filter((e) -> "Cambridge".equals(e.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(reduce.get());

        Optional<Integer> sum = transactions.stream()
                .filter((e) -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);

        System.out.println(sum.get());

    }


    //7. 所有交易中，最高的交易额是多少
    @Test
    public void test7() {
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max.get());

        Optional<Integer> max1 = transactions.stream()
                .map((t) -> t.getValue())
                .max(Integer::compare);

        System.out.println(max1.get());
    }

    //8. 找到交易额最小的交易
    @Test
    public void test8() {
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());

        Optional<Transaction> op = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));

        System.out.println(op.get());
    }

}