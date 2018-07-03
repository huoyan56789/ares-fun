package thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Ares
 * @date 2018/7/3 11:37
 */
public class ConcurrentHashMapUse
{
    private static final Map<String, Long> wordCounts = new ConcurrentHashMap<>();

    //直接这么写是不对的
    public static long increase(String word)
    {

        Long oldValue = wordCounts.get(word);

        Long newValue = (oldValue == null) ? 1L : oldValue + 1;

        wordCounts.put(word, newValue);

        return newValue;
    }

    //使用putIfAbsent这种CAS操作并根据返回进行判断执行结果
    //    public static long increase(String word)
    //    {
    //
    //        Long oldValue, newValue;
    //
    //        while(true)
    //        {
    //
    //            oldValue = wordCounts.get(word);
    //
    //            if (oldValue == null)
    //            {
    //
    //                newValue = 1L;
    //
    //                if (wordCounts.putIfAbsent(word, newValue) == null)
    //                {
    //
    //                    break;
    //
    //                }
    //
    //            }
    //            else
    //            {
    //
    //                newValue = oldValue + 1;
    //
    //                if (wordCounts.replace(word, oldValue, newValue))
    //                {
    //
    //                    break;
    //
    //                }
    //
    //            }
    //
    //        }
    //
    //        return newValue;
    //
    //    }

    //需要把Map中value的类型改成AtomicLong
    //    public static long increase(String word) {
    //
    //        AtomicLong number = wordCounts.get(word);
    //
    //        if(number == null) {
    //
    //            AtomicLong newNumber = new AtomicLong(0);
    //
    //            number = wordCounts.putIfAbsent(word, newNumber);
    //
    //            //如果number是null，说明放入成功了
    //            if(number == null) {
    //                number = newNumber;
    //            }
    //
    //        }
    //        return number.incrementAndGet();
    //
    //    }

    public static void main(String[] args)
    {
        int threadCount = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++)
        {
            new Thread(() -> {
                increase("a");
                increase("b");
                increase("c");
                increase("d");
                countDownLatch.countDown();
            }).start();
        }
        //等待计算线程执行完
        try
        {
            countDownLatch.await();
            long time = System.currentTimeMillis() - startTime;
            System.out.println("执行程序共耗费" + time + "毫秒");
            System.out.println(wordCounts);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
