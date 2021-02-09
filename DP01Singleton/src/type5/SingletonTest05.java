package type5;

/**
 * @author myth
 * @Date 2021-02-09 23:32:46
 * 懒汉式(线程安全，同步代码块)
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        System.out.println("懒汉式 2 ， 线程安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance ==instance2); // true
        System.out.println("instance.hashCode="+instance.hashCode());
        System.out.println("instance2.hashCode="+instance2.hashCode());
    }

}

class Singleton{
    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}