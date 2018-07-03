package datastructure.map;

import java.util.WeakHashMap;

/**
 * WeakHashMap是一种改进的HashMap，它对key实行“弱引用”，如果一个key不再被外部所引用，那么该key可以被GC回收
 * 可能在系统运行期间key和value就被清除掉了，从而整个map的大小状态都可能改变
 * WeekHashMap 特别适用于需要缓存的场景，缓存MISS也不会造成错误，因为可以通过计算重新得到
 * 在正常的使用场景下不要使用
 * @author Ares
 * @date 2018/7/2 15:58
 */
public class WeakHashMapDemo
{
    public static void main(String[] args)
    {
        WeakHashMap map = new WeakHashMap();
        //方法同HashMap
        map.put("ares", "love");
        map.put("xixi", "hahaha");
        map.put("di", "hai");
        System.out.println(map);
    }
}
