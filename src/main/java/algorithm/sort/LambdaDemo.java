package algorithm.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        //暂时发现只有除了自身不带其他参数可以用
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
    }
}
