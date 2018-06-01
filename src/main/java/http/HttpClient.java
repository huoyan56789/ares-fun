package http;


import org.apache.http.Header;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ares
 * @date 2018/5/29 12:57
 */
public class HttpClient
{
    public static String requestByGet(String url, Map<String,String> dataMap, Header[] headers)
    {
        //创建默认的HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        String result = null;
        try
        {
            StringBuffer stringBuffer = new StringBuffer();
            dataMap.forEach((k,v) -> {stringBuffer.append("&" + k + "=" +v);});
            if(stringBuffer.length() > 0){
                String s = stringBuffer.substring(1, stringBuffer.length());
                url = url + "?" + s;
            }
            //用Get方法发送http请求
            HttpGet httpGet = new HttpGet(url);

            //添加单个消息头
            //httpGet.setHeader();
            //批量添加消息头
            httpGet.setHeaders(headers);

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


    public static String requestByPost(String url, Map<String,String> dataMap, Header[] headers)
    {
        //创建默认的HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //用Post方法发送http请求
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        dataMap.forEach((k,v) -> { list.add(new BasicNameValuePair(k,v));});
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

        //添加单个消息头
//        httpPost.setHeader();

        //批量添加消息头
        httpPost.setHeaders(headers);

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
        String urlWithGet = "http://172.30.225.138:8080/m2m/common/get";
        List<Header> headerList = new LinkedList<Header>();
        Header[] headers = headerList.toArray(new Header[headerList.size()]);
        Map dataMap = new HashMap();
//        dataMap.put("username", "ares");
//        dataMap.put("password", "love");
        String result = requestByGet(urlWithGet, dataMap, headers);

//        String urlWithPost = "http://172.30.225.138:8080/m2m/common/post";
////        //此时的消息头Content-Type若不设置默认为application/x-www-form-urlencoded
//        List<Header> headerList = new LinkedList<Header>();
//        headerList.add(new HeaderImpl("Content-Type", "application/json"));
//        headerList.add(new HeaderImpl("Accept", "application/json"));
//        Header[] headers = headerList.toArray(new Header[headerList.size()]);
//
//        Map dataMap = new HashMap();
//        dataMap.put("username", "ares");
//        dataMap.put("password", "love");
//        String result = requestByPost(urlWithPost, dataMap, headers);

        System.out.println("响应内容:" + result);
    }
}
