package json;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import utils.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ares
 * @date 2018/6/4 16:46
 */
public class SoapAndJson
{

    private final static Integer USE_MAP = 1;
    private final static Integer USE_LIST = 2;

    /**
     * 将soap报文转换为Json格式的字符串(丢弃属性值)
     *
     * @return
     */
    public static String soapToJson(String s)
    {
        //创建解析器
        SAXReader reader = new SAXReader();
        Document document = null;
        try
        {
            document = reader.read(new ByteArrayInputStream(s.getBytes("utf-8")));
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        //获取根元素
        Element root = document.getRootElement();
        //对根元素做处理
        Object object = eleToCollection(root);
        return JSONObject.toJSONString(object);
    }

    //对元素及其子元素做迭代处理
    private static Object eleToCollection(Element element)
    {
        Object object = null;
        //计数Map，用以统计元素存在的个数
        Map countMap = new HashMap();
        //元素Map用以存放处理过后的元素
        Map eleMap = new HashMap();
        //当元素个数超过2个时，将Map转为List
        List eleList = new LinkedList();

        List<Element> nodeList = element.elements();
        for (Element e : nodeList)
        {
            //用计数Map计数
            if (null == countMap.get(e.getName()))
            {
                countMap.put(e.getName(), USE_MAP);
            }
            else
            {
                countMap.put(e.getName(), (Integer) countMap.get(e.getName()) + USE_MAP);
            }

            //一通操作猛如虎
            if (countMap.get(e.getName()).equals(USE_LIST))
            {
                eleList.add(eleMap);
            }

            if (countMap.get(e.getName()).equals(USE_MAP))
            {
                object = dealForMap(e, eleMap);
            }
            else
            {
                eleList.add(dealForMap(e, new HashMap()));
                object = eleList;
            }
        }
        return object;
    }


    private static Map dealForMap(Element e, Map map)
    {
        //这部分废弃，因为属性值不能简单地作为一个字段
        //        List<Attribute> listAttr = e.attributes();
        //        if (!listAttr.isEmpty())
        //        {
        //            //将属性作为子元素添加到元素
        //            listAttr.forEach(i -> {
        //                e.addElement(i.getName()).setText(i.getText());
        //            });
        //        }

        if (StringUtils.isNotEmpty(e.getText()))
        {
            map.put(e.getName(), e.getText());
        }
        else if (e.elements().isEmpty())
        {
            map.put(e.getName(), "");
        }
        else
        {
            map.put(e.getName(), eleToCollection(e));
        }
        return map;
    }

    public static void main(String[] args)
    {
        String soapStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP-ENV:Header/><SOAP-ENV:Body><ns2:GetTerminalDetailsResponse xmlns:ns2=\"http://api.jasperwireless.com/ws/schema\" ns2:requestId=\"2La5yq9OjUutmGpO\"><ns2:correlationId/><ns2:version>7.28</ns2:version><ns2:build>Unknown</ns2:build><ns2:timestamp>2018-05-31T05:45:55.218Z</ns2:timestamp><ns2:terminals><ns2:terminal msisdn=\"861064619018688\"><ns2:iccid>89860616010049046168</ns2:iccid><ns2:suspended>N</ns2:suspended><ns2:ratePlan>测试-0元-300M-50SMS-无用量限制</ns2:ratePlan><ns2:status>ACTIVATED_NAME</ns2:status><ns2:monthToDateUsage>0.000</ns2:monthToDateUsage><ns2:overageLimitReached>false</ns2:overageLimitReached><ns2:overageLimitOverride>DEFAULT</ns2:overageLimitOverride><ns2:dateActivated>2017-07-17T07:31:00.292Z</ns2:dateActivated><ns2:dateAdded>2017-04-27T05:57:32.909Z</ns2:dateAdded><ns2:dateModified>2018-04-09T07:52:17.158Z</ns2:dateModified><ns2:dateShipped>2017-04-26T16:00:00.000Z</ns2:dateShipped><ns2:monthToDateDataUsage>0.000</ns2:monthToDateDataUsage><ns2:monthToDateSMSUsage>0</ns2:monthToDateSMSUsage><ns2:monthToDateVoiceUsage>0</ns2:monthToDateVoiceUsage><ns2:secureSimId/><ns2:custom1/><ns2:custom2/><ns2:custom3/><ns2:rating/><ns2:secureSimUsernameCopyRule>N</ns2:secureSimUsernameCopyRule><ns2:secureSimPasswordCopyRule>N</ns2:secureSimPasswordCopyRule><ns2:accountId>100830217</ns2:accountId><ns2:fixedIpAddress xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><ns2:ctdSessionCount xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><ns2:customerCustom1/><ns2:customerCustom2/><ns2:customerCustom3/><ns2:customerCustom4/><ns2:customerCustom5/><ns2:operatorCustom1>Y</ns2:operatorCustom1><ns2:operatorCustom2/><ns2:operatorCustom3>test</ns2:operatorCustom3><ns2:operatorCustom4/><ns2:operatorCustom5/><ns2:imsi>460069001018822</ns2:imsi><ns2:primaryICCID/><ns2:imei>8613740333395200</ns2:imei><ns2:globalSimType/><ns2:version>2</ns2:version><ns2:custom4/><ns2:custom5/><ns2:custom6/><ns2:custom7/><ns2:custom8/><ns2:custom9/><ns2:custom10>2</ns2:custom10></ns2:terminal><ns2:terminal msisdn=\"861064619018688\"><ns2:iccid>89860616010049046168</ns2:iccid><ns2:suspended>N</ns2:suspended><ns2:ratePlan>测试-0元-300M-50SMS-无用量限制</ns2:ratePlan><ns2:status>ACTIVATED_NAME</ns2:status><ns2:monthToDateUsage>0.000</ns2:monthToDateUsage><ns2:overageLimitReached>false</ns2:overageLimitReached><ns2:overageLimitOverride>DEFAULT</ns2:overageLimitOverride><ns2:dateActivated>2017-07-17T07:31:00.292Z</ns2:dateActivated><ns2:dateAdded>2017-04-27T05:57:32.909Z</ns2:dateAdded><ns2:dateModified>2018-04-09T07:52:17.158Z</ns2:dateModified><ns2:dateShipped>2017-04-26T16:00:00.000Z</ns2:dateShipped><ns2:monthToDateDataUsage>0.000</ns2:monthToDateDataUsage><ns2:monthToDateSMSUsage>0</ns2:monthToDateSMSUsage><ns2:monthToDateVoiceUsage>0</ns2:monthToDateVoiceUsage><ns2:secureSimId/><ns2:custom1/><ns2:custom2/><ns2:custom3/><ns2:rating/><ns2:secureSimUsernameCopyRule>N</ns2:secureSimUsernameCopyRule><ns2:secureSimPasswordCopyRule>N</ns2:secureSimPasswordCopyRule><ns2:accountId>100830217</ns2:accountId><ns2:fixedIpAddress xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><ns2:ctdSessionCount xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><ns2:customerCustom1/><ns2:customerCustom2/><ns2:customerCustom3/><ns2:customerCustom4/><ns2:customerCustom5/><ns2:operatorCustom1>Y</ns2:operatorCustom1><ns2:operatorCustom2/><ns2:operatorCustom3>test</ns2:operatorCustom3><ns2:operatorCustom4/><ns2:operatorCustom5/><ns2:imsi>460069001018822</ns2:imsi><ns2:primaryICCID/><ns2:imei>8613740333395200</ns2:imei><ns2:globalSimType/><ns2:version>2</ns2:version><ns2:custom4/><ns2:custom5/><ns2:custom6/><ns2:custom7/><ns2:custom8/><ns2:custom9/><ns2:custom10>2</ns2:custom10></ns2:terminal></ns2:terminals></ns2:GetTerminalDetailsResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";
        String jsonStr = soapToJson(soapStr);
        System.out.println(jsonStr);
    }
}
