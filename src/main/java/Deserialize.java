import entity.Thing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Ares
 * @date 2018/6/26 14:02
 */
public class Deserialize
{
    public static void main(String[] args)
    {

        String directory = "D:" + File.separator + "Projects" + File.separator + "IdeaProjects" + File.separator + "ares-fun" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        String fileName = "serialization.txt";

        createFile(directory + fileName);
        Thing thing = (Thing) createObject(directory + fileName);
        System.out.println("反序列化生成的对象: " + thing);
    }

    /**
     * 根据二进制文件反序列化生成对象
     */
    public static Object createObject(String file)
    {
        ObjectInputStream ois = null;
        Thing thing = null;
        try
        {
            ois = new ObjectInputStream(new FileInputStream(file));
            thing = (Thing) ois.readObject();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } finally
        {
            if (null != ois)
            {
                try
                {
                    ois.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
        return thing;
    }

    /**
     * 序列化对象到文件中(二进制)
     */
    public static void createFile(String file)
    {

        ObjectOutputStream oos = null;
        try
        {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(new Thing(100, "低", null));
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (null != oos)
            {
                try
                {
                    oos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
