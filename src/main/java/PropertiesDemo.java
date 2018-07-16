

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @author Ares
 * @date 2018/7/9 16:18
 */
public class PropertiesDemo
{
    private static Logger logger = LoggerFactory.getLogger(PropertiesDemo.class);

    public static void main(String[] args)
    {
        //打印系统参数
        //Properties properties = System.getProperties();
        //properties.list(System.out);

        //获取Resource下的文件路径
        //URL url = ClassLoader.getSystemResource("serialization.txt");
        //        URL url = ClassLoader.getSystemResource("ares.properties");
        //        String path = url.getPath();
        //        logger.debug(path);

        //读取文件中的参数
        //        try
        //        {
        //            Properties prop = new Properties();
        //            prop.load(new FileInputStream(path));
        //            Enumeration enumeration = prop.propertyNames();//得到配置文件的名字
        //            while(enumeration.hasMoreElements())
        //            {
        //                String strKey = (String) enumeration.nextElement();
        //                String strValue = prop.getProperty(strKey);
        //                logger.debug(strKey + "=" + strValue);
        //            }
        //        } catch (IOException e)
        //        {
        //            e.printStackTrace();
        //        }


        //获取环境变量
        Map<String, String> map = System.getenv();
        map.forEach((k, v) -> logger.debug("key: " + k + ",value: " + v));
    }
}
