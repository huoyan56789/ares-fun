package utils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

/**
 * 本工具利用jdk的默认js引擎Nashorn完成java和js的互相调用
 * @author Ares
 * @date 2018/7/6 14:46
 */
public class JsUtils
{
    //参见NashornScriptEngineFactory类
    //private static final List<String> names = immutableList("nashorn", "Nashorn", "js", "JS", "JavaScript", "javascript", "ECMAScript", "ecmascript");
    //private static final List<String> mimeTypes = immutableList("application/javascript", "application/ecmascript", "text/javascript", "text/ecmascript");
    //private static final List<String> extensions = immutableList("js");
    //所以以上述名称都可以获取Nashorn引擎
    private final static ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");


    public static Object call(String expression) throws ScriptException
    {
        //System.out.println(scriptEngine.getClass().getName());

        //scriptEngine还有一个eval方法，参数为Reader reader，
        //可以利用这一点将持久化的脚本(文件或者数据库)读取之后直接执行而不需要先转化为字符串
        return scriptEngine.eval(expression);
    }

    public static Object callFunc(String func, String param) throws ScriptException, NoSuchMethodException
    {
        scriptEngine.eval("var func = function (param) {" + func + "}");
        Invocable invocable = (Invocable) scriptEngine;

        Object result = invocable.invokeFunction("func", param);
        return result;
    }

    public static void main(String[] args)
    {
        //简单调用
//        try
//        {
//            System.out.println((Object)null instanceof String);
//            call("print('Hello World!');");
//        } catch (ScriptException e)
//        {
//            e.printStackTrace();
//        }

        //函数调用
        try
        {
            //可以做成在配置文件读取或者在数据库中读取，更省事的使用eval(Reader reader)这个计算，输入则new FileReader(filePath)
            String func = "if(null == param || param == undefined){return \"参数为空或无法识别\";}else if(Number(param) > 10){return \"比10大\";}else{return \"小于或等于10\";}";
            String str = (String)callFunc(func, "9");
            System.out.println(str);
        } catch (ScriptException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }
}
