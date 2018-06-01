package json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ares
 * @date 2018/4/24 14:15
 */
public class ObjectMapperTest
{
    public static void main(String[] args)
    {
        ObjectMapper mapper = new ObjectMapper();
        //等价于#@JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //忽略实体类中不含有的字段方法,用在方法中
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonString = "{\"name\":\"ares\",\"age\":\"23\",\"sex\":\"man\",\"company\":\"tydic\",\"firm\":\"null\",\"testNum\":1,\"testNull\":null}";
        try
        {
            //将json字符串映射到实体的属性
            Student student = mapper.readValue(jsonString,Student.class);
            System.out.println("映射后的实体为: " + student);
            //读取实体(也可以是集合)为String
            String jsonStr = mapper.writeValueAsString(student);
            System.out.println("读取实体为字符串: " + jsonStr);

            //读取实体为byte[] 为ascil编码
            byte [] bytes = mapper.writeValueAsBytes(student);
            System.out.print("读取实体为byte数组: ");
            for (byte b:bytes)
            {
                System.out.print(b + " ");
            }
            System.out.println();
            Student studentByte = mapper.readValue(bytes,Student.class);
            System.out.println("用byte数组映射的实体: " + studentByte);

            //读取实体为字符串并写入文件
//            File file = new File("D://writeJson.txt");
//            mapper.writeValue(file,student);
//            json.Student studentFile = mapper.readValue(file,json.Student.class);
//            System.out.println("用文件映射的实体: " + studentFile);

            //将字符串读取为map,map中的null会写明为null，firm=  这种没有value的形式其实value是""(空串)
            HashMap<String,String> map = mapper.readValue(jsonString,HashMap.class);
            System.out.println("字符串转换后的map: " + map);

        } catch (IOException e)
        {
            e.printStackTrace();
        }


        /**
         * json字符串转List
         */
        ObjectMapper objectMapper = new ObjectMapper();
        String listString = "[{\"age\":\"23\",\"firm\":\"tydic\"},{\"age\":\"23\"}]";
        try
        {

          JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Student.class);
          List<Student> list =  objectMapper.readValue(listString, javaType);
//        ArrayList<json.Student> list = objectMapper.readValue(listString,new TypeReference<List<json.Student>>() {});
          list.forEach(System.out::println);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

