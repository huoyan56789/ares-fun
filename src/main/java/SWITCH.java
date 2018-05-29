/**
 * @author Ares
 * @date 2018/5/24 14:06
 */
public class SWITCH
{
    public static void main(String[] args)
    {
        String str = "寂寞";
        String s = "孤独";
        String string = "哼";

        //不写break每个case都会走
//        switch (str){
//            case "无敌":
//                System.out.println("我是无敌");
//            case "寂寞":
//                System.out.println("我是寂寞");
//            case "孤独":
//                System.out.println("我是孤独");
//        }

        switch (s){
            case "无敌":
                System.out.println("我是无敌");
                break;
            case "寂寞":
                System.out.println("我是寂寞");
                break;
            case "孤独":
                System.out.println("我是孤独");
                break;
            default:
                System.out.println("我啥都不是");
                break;
        }

        switch (s){
            case "无敌":
            case "孤独":
            case "寂寞":
                System.out.println("无敌是多么寂寞");
                break;
            default:
                System.out.println("我啥都不是");
                break;
        }

        switch (string){
            default:
                System.out.println("我啥都不是");
                break;
            case "无敌":
            case "孤独":
            case "寂寞":
                System.out.println("无敌是多么寂寞");
                break;
        }
    }
}
