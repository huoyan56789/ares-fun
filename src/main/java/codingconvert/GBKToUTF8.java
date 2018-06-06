package codingconvert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ares
 * @date 2018/6/6 9:42
 */
public class GBKToUTF8
{
    public static void GBKToUTF8(String file, String convertFile) throws IOException
    {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("GBK")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(convertFile), Charset.forName("UTF-8")));
            String lineTxt = null;
            while((lineTxt = br.readLine()) != null)
            {
                bw.write(lineTxt);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } finally
        {
            if (null != br)
            {
                bw.close();
            }

            if (null != bw)
            {
                br.close();
            }
        }
    }

    /**
     * 获取路径下的所有文件/文件夹
     *
     * @param directoryPath  需要遍历的文件夹路径
     * @param isAddDirectory 是否将子文件夹的路径也添加到list集合中
     *
     * @return
     */
    public static List<String> getAllFile(String directoryPath, boolean isAddDirectory)
    {
        List<String> fileList = new LinkedList<>();
        File directory = new File(directoryPath);
        if (directory.isFile() || !directory.exists())
        {
            return fileList;
        }
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isDirectory())
            {
                if (isAddDirectory)
                {
                    fileList.add(file.getAbsolutePath());
                }
                fileList.addAll(getAllFile(file.getAbsolutePath(), isAddDirectory));
            }
            else
            {
                fileList.add(file.getAbsolutePath());
            }
        }
        return fileList;
    }

    public static void main(String[] args)
    {
        String project = "D:" + File.separator + "Projects" + File.separator + "IdeaProjects" + File.separator + "ares-fun" + File.separator;
        String commonDir = "src" + File.separator + "main" + File.separator + "java" + File.separator;
        String directory = "soap";
        String convertDir = "convertfile";
        List<String> fileList = getAllFile( project + commonDir + directory, false);
        fileList.forEach(i ->{
            //设置过滤，这里只转java文件
            if(new File(i).getName().contains("java")){
                try
                {
                    GBKToUTF8(i,i.replace(directory,convertDir));
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
