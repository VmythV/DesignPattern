package type3;

/**
 * @author myth
 * @Date 2021-02-08 22:47:56
 * 懒汉式(线程不安全)
 */
public class SingletonTest03 {
    public static void main(String[] args) {

        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }
}

//饿汉式(静态代码块)

class Singleton {


    //2.本类内部创建对象实例
    private static Singleton instance;

    //构造器私有化
    private Singleton() {
    }

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance
    //即懒汉式
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}