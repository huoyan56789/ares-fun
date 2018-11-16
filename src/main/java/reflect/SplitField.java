package reflect;


import annotation.IgnoreSplit;
import entity.BalanceOfAccountPO;

import java.lang.reflect.Field;
import java.util.StringJoiner;

/**
 * @Author Ares
 * @Date 2018/11/12 23:00
 * @Description:
 * @Version JDK 1.8
 */
public class SplitField
{
    public static void main(String[] args) throws IllegalAccessException
    {
        BalanceOfAccountPO balanceOfAccountPO = new BalanceOfAccountPO();
        balanceOfAccountPO.setDepartCode("1");
        balanceOfAccountPO.setOrderSource("2");
        balanceOfAccountPO.setTradeTime("3");
        System.out.println(splitParam(balanceOfAccountPO));
    }

    private static String splitParam(BalanceOfAccountPO boap) throws IllegalAccessException
    {
        Field[] fields = boap.getClass().getDeclaredFields();

        StringJoiner stringJoiner = new StringJoiner(",");
        for (Field field:fields)
        {
            // 如果属性有注解，就不进行拼接
            if (!field.isAnnotationPresent(IgnoreSplit.class))
            {
                field.setAccessible(true);
                Object fieldValue = field.get(boap);
                stringJoiner.add((null == fieldValue ? "" : fieldValue.toString()));
            }
        }
        return stringJoiner.toString();
    }
}
