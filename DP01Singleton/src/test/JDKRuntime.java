package test;

/**
 * @author myth
 * @Date 2021-02-11 21:28:39
 * java.lang.Runtime 经典的单例模式(饿汉式)
 */
public class JDKRuntime {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();//看Runtime源码
        MyRuntime myRuntime = MyRuntime.getMyRuntime();
    }
}

class MyRuntime{
    private static MyRuntime MycurrentRuntime = new MyRuntime();

    public static MyRuntime getMyRuntime() {
        return MycurrentRuntime;
    }

    private MyRuntime() {}
}