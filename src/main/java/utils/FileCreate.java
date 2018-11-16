package utils;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Ares
 * @Date 2018/9/29 11:01
 * @Description:
 * @Version JDK 1.8
 */
public class FileCreate
{
    //文件内容的缓冲区大小
    private final static int CONTENTSIZE = 512;
    //文件头缓冲区大小
    private final static int HEADSIZE = 41;
    //文件编码
    private final static String FILECHARSET = "GBK";
    //换行符
    private final static String LINESEPARATOR = "\r\n";

    private static ByteBuffer byteBuffer = null;
    private static FileChannel fileChannel = null;

    public static void main(String[] args) throws UnsupportedEncodingException
    {
        // 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。
        try
        {
            fileChannel = new RandomAccessFile("yyyymmdd_zzzz_outOrderSync_iiii_xxxx.REQ", "rw").getChannel();

            fileChannel.position(HEADSIZE);
            writeString(fileChannel, HEADSIZE, "", FILECHARSET);
            System.out.println("当前游标为: " + fileChannel.position());

            writeString(fileChannel, CONTENTSIZE, "我是你爸爸", FILECHARSET);
            System.out.println("当前游标为: " + fileChannel.position());

            fileChannel.position(0);
            fileChannel.write(ByteBuffer.wrap("你好".getBytes(FILECHARSET)));

            System.out.println("当前游标为: " + fileChannel.position());

            //获取文件通道位置
            //fileChannel.position();
            //获取文件管道大小
            //fileChannel.size();
            //截取内容
            //fileChannel.truncate(1024);
            //强制刷新数据到硬盘
            //fileChannel.force(true);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (null != fileChannel)
            {
                try
                {
                    fileChannel.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    //写入文件，指定缓冲区、字符集
    public static void writeString(FileChannel fileChannel, int size, String content, String charSet) throws IOException
    {
        byteBuffer = ByteBuffer.allocate(size);
        //读取512字节内容到byteBuffer钟
        fileChannel.read(byteBuffer);

        byteBuffer.clear();
        byteBuffer.put((content + LINESEPARATOR).getBytes(charSet));
        //类似于flush()函数功能，将buffer里面的数据刷新出去
        byteBuffer.flip();
        //检查是否还有数据未写入
        while(byteBuffer.hasRemaining())
        {
            fileChannel.write(byteBuffer);
        }

        //指定文件大小MappedByteBuffer,通过length可提前占位
        //MappedByteBuffer out = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);
    }
}
