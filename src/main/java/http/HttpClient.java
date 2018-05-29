package http;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ares
 * @date 2018/5/29 12:57
 */
public class HttpClient
{
    public static String requestByGet(String url)
    {
        //创建默认的HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try
        {
            //用Get方法发送http请求
            HttpGet httpGet = new HttpGet(url);
            //httpGet.setHeader();添加单个消息头
            //httpGet.setHeaders();批量添加消息头
            System.out.println("执行Get请求,url:" + httpGet.getURI());

            //发送get请求
            httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (null != entity)
            {
                System.out.println("响应状态码:" + httpResponse.getStatusLine());
                result = EntityUtils.toString(entity);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (null != httpClient)
                {
                    httpClient.close();
                }
                if (null != httpResponse)
                {
                    httpResponse.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static String requestByPost(String url)
    {
        //创建默认的HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //用Post方法发送http请求
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("username", "ares"));
        list.add(new BasicNameValuePair("password", "xue"));
        //url格式编码
        UrlEncodedFormEntity uefEntity = null;
        try
        {
            uefEntity = new UrlEncodedFormEntity(list, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        httpPost.setEntity(uefEntity);
        //httpPost.setHeader();添加单个消息头
        httpPost.setHeader("Content-Type", "application/json");
        //httpPost.setHeaders();批量添加消息头
        System.out.println("执行POST请求,url:" + httpPost.getURI());
        //执行请求
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try
        {
            httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            if (null != entity)
            {
                System.out.println("响应状态码:" + httpResponse.getStatusLine());
                result = EntityUtils.toString(entity);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (null != httpClient)
                {
                    httpClient.close();
                }
                if (null != httpResponse)
                {
                    httpResponse.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
//        String urlWithGet = "https://www.apiopen.top/weatherApi?city=南京";
//        String result = requestByGet(urlWithGet);

        //此时的消息头Content-Type若不设置默认为application/x-www-form-urlencoded
        String urlWithPost = "http://172.30.225.138:8080/m2m/common/post";
        String result = requestByPost(urlWithPost);
        System.out.println("响应内容:" + result);
    }
}
