package http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import utils.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ares
 * @date 2018/5/29 17:18
 */
public class Okhttp3
{
    public static void main(String[] args)
    {
        //        String urlWithGet = "http://172.30.225.138:8080/m2m/common/get";
        //        Map dataMap = new HashMap();
        //        dataMap.put("username", "bing");
        //        Map headers = new HashMap<>();
        //        headers.put("Content-Type", "application/json");
        //        headers.put("Accept", "application/json");
        //        headers.put("Authorization", "I love you");
        //        String result = requestByGet(urlWithGet, dataMap, headers);

        String urlWithPost = "http://172.30.225.138:8080/m2m/common/post";
        Map dataMap = new HashMap();
        dataMap.put("username", "ares");
        Map headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        String result = requestByPost(urlWithPost, dataMap, headers);

        System.out.println(result);
    }

    public static String requestByGet(String url, Map dataMap, Map<String, String> headers)
    {
        String result = null;

        StringBuffer stringBuffer = new StringBuffer();
        dataMap.forEach((k, v) -> {
            stringBuffer.append("&" + k + "=" + v);
        });
        if (StringUtils.isNotEmpty(stringBuffer.toString()))
        {
            String s = stringBuffer.substring(1, stringBuffer.length());
            url = url + "?" + s;
        }

        Request.Builder builder = new Request.Builder();
        headers.forEach((k, v) -> {
            builder.addHeader(k, v);
        });
        Request request = builder.url(url).build();

        //        OkHttpClient okHttpClient = new OkHttpClient();
        //        Call call = okHttpClient.newCall(request);
        try
        {
            Response response = new OkHttpClient().newCall(request).execute();
            if (response.isSuccessful())
            {
                result = response.body().string();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }


    public static String requestByPost(String url, Map<String, String> dataMap, Map<String, String> headers)
    {
        String result = null;

        //下面的设置对Content-Type无效，因为会被RequestBody自带的消息头覆盖
        Request.Builder reqBuilder = new Request.Builder();
        headers.forEach((k, v) -> {
            reqBuilder.addHeader(k, v);
        });


        RequestBody requestBody = null;
        if (!StringUtils.isNotEmpty(headers.get("Content-Type")))
        {
            //form表单提交方式，Content-Type默认为application/x-www-form-urlencoded
            FormBody.Builder builder = new FormBody.Builder();
            dataMap.forEach((k, v) -> builder.add(k, v));
            requestBody = builder.build();
        }
        else if (StringUtils.isNotEmpty(headers.get("Content-Type")) && headers.get("Content-Type").contains("application/json"))
        {
            //json提交方式
            String content = null;
            ObjectMapper mapper = new ObjectMapper();
            try
            {
                content = mapper.writeValueAsString(dataMap);
            } catch (JsonProcessingException e)
            {
                e.printStackTrace();
            }
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            requestBody = RequestBody.create(mediaType, content);
        }

        Request request = reqBuilder.url(url).post(requestBody).build();

        try
        {
            Response response = new OkHttpClient().newCall(request).execute();
            if (response.isSuccessful())
            {
                result = response.body().string();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
