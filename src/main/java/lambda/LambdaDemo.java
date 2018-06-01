package lambda;

import json.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ares
 * @date 2018/1/8 13:55
 */
public class LambdaDemo
{
    public static void main(String[] args)
    {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("2");
        Stream<String> steam = list.stream();
        steam.forEach(s -> System.out.println("steam:" + s));
        Stream<Integer> steamMap = list.stream().map(Integer::new);
        //        steamMap.forEach(i -> System.out.println("steamMap:" + i));
        //steamMap.forEach()不能修改值，因为这时候的值默认是final的
        //成员方法引用
        steamMap.forEach(System.out::println);
        Stream distinctMap = list.stream().map(Integer::new).distinct();
        distinctMap.forEach(i -> System.out.println("distinctMap:" + i));
        List<Integer> integerList = list.stream().map(Integer::new).distinct().collect(Collectors.toList());
        integerList.forEach(integer -> {
            System.out.println("integer:" + integer);
        });
        Map<Integer, Integer> finalMap = list.stream().map(Integer::new).distinct().collect(Collectors.toMap(m -> m, m -> m));
        for (Map.Entry<Integer, Integer> entry : finalMap.entrySet())
        {
            System.out.println("key:" + entry.getKey() + "value:" + entry.getValue());
        }
        //不去重
        Map<Integer, Integer> collectMap = list.stream().map(Integer::new).collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
        for (Map.Entry<Integer, Integer> entry : collectMap.entrySet())
        {
            System.out.println("collectMapKey:" + entry.getKey() + "collectMapValue:" + entry.getValue());
        }


        /*
          map:把input Stream 的每一个元素，映射成 output Stream 的另外一个元素（表达式必须有返回值）
         */
        System.out.println("-------map----------");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        System.out.println(squareNums);

        /*
          flatMap:把input Stream中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终output的新Stream里面已经没有List了，都是直接的数字
         */
        System.out.println("-------flatMap----------");
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        List<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream()).
                collect(Collectors.toList());
        System.out.println(outputStream);

        /*
          filter:对原始Stream进行某项测试，通过测试的元素被留下来生成一个新Stream(表达式不能有返回值)
         */
        System.out.println("-------filter----------");
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).
                filter(n -> n % 2 == 0).
                toArray(Integer[]::new);
        System.out.println(Arrays.toString(evens));

        /*
          peek:对每个元素执行操作并返回一个新的Stream(表达式不能有返回值)
         */
        System.out.println("-------peek----------");
        List listNum = Stream.of("one", "two", "three", "four").
                peek(e -> System.out.println("value: " + e)).
                collect(Collectors.toList());
        System.out.println(listNum);

        /*
          Optional:作为一个容器，它可能含有某值，或者不包含。使用它的目的是尽可能避免 NullPointerException
         */
        System.out.println("-------Optional----------");
        Optional optional = null;
        try
        {
            optional = Optional.class.newInstance();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
        }
        System.out.println(optional);

        /*
          reduce:这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合
         */
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("-------reduce----------");
        System.out.println(concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
        // 求和，sumValue = 10, 无起始值(此时把前两个元素组合做为初始值)
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);

        /*
          limit/skip:limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素
         */
        List<Student> students = new ArrayList();
        for (int i = 1; i <= 100; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setName("name" + i);
            students.add(student);
        }
        List<String>  studentList = students.stream().
                map(Student::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(studentList);
    }

}
