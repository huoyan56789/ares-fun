package jython;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

/**
 * @Author Ares
 * @Date 2018/11/9 1:33
 * @Description:
 * @Version JDK 1.8
 */
public class JythonDemo
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        //python运行环境变量
        PySystemState sys = Py.getSystemState();
        sys.path.add("D:\\Master\\Python27\\Lib\\site-packages");
        //       System.out.println(sys.path.toString());

        //调试第三方库
        //        PythonInterpreter python = new PythonInterpreter();
        //        python.exec("import qrcode");


        String pyFile = "D:\\Projects\\PycharmProjects\\ares_fun\\test_net.py";
        String[] arguments = {pyFile, ""};
        PythonInterpreter.initialize(System.getProperties(), System.getProperties(), arguments);
        PythonInterpreter python = new PythonInterpreter();
        StringWriter out = new StringWriter();
        python.setOut(out);
        python.execfile(pyFile);
        //转码
        String result = new String(out.toString().getBytes("iso8859-1"), "utf-8");
        System.out.println(result);

        // 获取文件中的函数
        PyFunction function = (PyFunction) python.get("hello", PyFunction.class);
        //调用Python中的方法
        //传参有中文时设置中文编码方式
        PyString pySex = Py.newStringUTF8("");
        PyInteger pyage = new PyInteger(1);
        PyObject pyobject = function.__call__(pySex, pyage);
    }
}
