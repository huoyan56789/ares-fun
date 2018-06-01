package utils;

/**
 * @author Ares
 * @date 2018/6/1 10:44
 */
public class StringUtils
{
    public static boolean isNotEmpty(String s){
        if(null == s || s.isEmpty()){
            return false;
        }
        return true;
    }
}
