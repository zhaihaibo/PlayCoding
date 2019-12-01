package com.example.demo.Test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class UserTest {

    @Test
    public void test1(){
        List<User> user = Arrays.asList(
                new User ("张三",12,1000.00),
                new User ("李四",32,4000),
                new User ("王五",40,4000),
                new User ("王五",40,4000));
       // System.out.println(user);
        //把user转化成map
        Map<Integer, User> collect9 = user.stream()
                .distinct()
                .collect(Collectors.toMap(User::getAge, us -> us,(m1,m2) -> m1.getAge() >= m2.getAge() ? m1 : m2));
        System.out.println(collect9+"--转化成了map");
        //reduce归约求和
        Integer reduce = user.stream()
                .map(User::getAge)
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        //根据名称生成一个新的List
        List<String> collect = user.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("名称 list ----"+collect);
        //根据名称生成一个新的Set
        Set<String> collect1 = user.stream().map(User::getName).collect(Collectors.toSet());
        System.out.println("名称 set ----"+collect1 );
        //根据名称生成一个新的HashSet
        HashSet<String> collect2 = user.stream().map(User::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println("名称 hashset ---- "+collect2);
        //获取流中的元素总数
        Long collect3 = user.stream().collect(Collectors.counting());
        System.out.println("元素总数为 ---- " +collect3);
        //根据工资获取平均值
        Double collect4 = user.stream().collect(Collectors.averagingDouble(User::getSalary));
        System.out.println("工资平均值为 ---- " +collect4);
        //根据工资获取总和
        DoubleSummaryStatistics collect5 = user.stream().collect(Collectors.summarizingDouble(User::getSalary));
        System.out.println("工资总和为 --- "+collect5.getSum());
        //根据工资获取组函数
        DoubleSummaryStatistics collect6 = user.stream().collect(Collectors.summarizingDouble(User::getSalary));
        System.out.println("工资的组函数 ---- " + collect6);
        //分组
        Map<Double, List<User>> collect7 = user.stream().collect(Collectors.groupingBy(User::getSalary));
        System.out.println("根据工资分组 ---- " + collect7);
        //连接
        String collect8 = user.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println("名字以,连接 ---- " + collect8);


        //两个BigDecimal进行相加
        BigDecimal b1 = new BigDecimal("100.00");
        BigDecimal b2 = new BigDecimal("0.03");
        System.out.println(b1.add(b2)); //加 100.03
        System.out.println(b1.subtract(b2)); //减 99.97
        System.out.println(b1.multiply(b2)); //乘 3.0000
        System.out.println(b1.divide(b2,2,BigDecimal.ROUND_HALF_EVEN)); //除 3333.33
        //多个BigDicemal进行相加

        List<BigDecimal> list = new ArrayList<>();
        for (int i = 1 ;i<=3;i++){
            list.add(new BigDecimal('"'+i+'"').subtract(new BigDecimal("68")));
        }
        System.out.println(list);
       // BigDecimal reduce = list.stream().reduce(BigDecimal.ZERO, (x, y) -> c,BigDecimal::add);
        Optional<BigDecimal> reduce1 = list.stream().reduce(BigDecimal::add);
        System.out.println(reduce1.get());
    }
}
