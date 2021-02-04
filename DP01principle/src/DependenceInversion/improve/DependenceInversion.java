package DependenceInversion.improve;

/**
 * @author myth
 * @Date 2021-02-04 16:50:07
 */
public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();

        person.receive(new Email());
        person.receive(new WenXin());
    }
}

interface IReceiver{
    public String getInfo();
}

class Email implements IReceiver{
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

class WenXin implements IReceiver{
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}

//完成 Person 接收消息的功能
//方式 1 分析
//1. 简单，比较容易想到
//2. 如果我们获取的对象是 微信，短信等等，则新增类，同时 Perons 也要增加相应的接收方法
//3. 解决思路：引入一个抽象的接口 IReceiver, 表示接收者, 这样 Person 类与接口 IReceiver 发生依赖
//	因为 Email, WeiXin 等等属于接收的范围，他们各自实现 IReceiver 接口就 ok,  这样我们就符号依赖倒转原则
class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
