package DependenceInversion.improve;

/**
 * @author myth
 * @Date 2021-02-04 17:24:23
 * 依赖关系三种注入方式
 */
public class DependencyPass {
    public static void main(String[] args) {
        //通过 接口 传递实现依赖
        ChangHong1 changHong1 = new ChangHong1();
        OpenAndClose1 openAndClose = new OpenAndClose1();
        openAndClose.open(changHong1);

        //通过 构造器 进行依赖传递
        ChangHong2 changHong2 = new ChangHong2();
        OpenAndClose2 openAndClose2 = new OpenAndClose2(changHong2);
        openAndClose2.open();

        //通过 setter 方法进行依赖传递
        ChangHong3 changHong3 = new ChangHong3();
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(changHong3);
        openAndClose3.open();


    }
}

class ChangHong1 implements ITV1 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class ChangHong2 implements ITV2 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

class ChangHong3 implements ITV3 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}

//=============================================
//方式 1： 通过接口传递实现依赖
//开关的接口
interface IOpenAndClose1 {
    public void open(ITV1 tv); //抽象方法,接收接口
}
//ITV 接口
interface ITV1 {
    public void play();
}

// 实现接口
class OpenAndClose1 implements IOpenAndClose1 {
    @Override
    public void open(ITV1 tv) {
        tv.play();
    }
}

//=============================================
// 方式 2: 通过构造方法依赖传递
interface IOpenAndClose2 {
    public void open(); //抽象方法
}
//ITV 接口
interface ITV2 {
    public void play();
}

class OpenAndClose2 implements IOpenAndClose2 {
    public ITV2 tv; //成员

    public OpenAndClose2(ITV2 tv) { //构造器
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}

//=============================================
// 方式 3 ,  通过 setter 方法传递
interface IOpenAndClose3 {

    public void open(); // 抽象方法
    public void setTv(ITV3 tv);
}

interface ITV3 { // ITV 接口
    public void play();
}

class OpenAndClose3 implements IOpenAndClose3 {
    private ITV3 tv;

    public void setTv(ITV3 tv) {
        this.tv = tv;
    }


    public void open() {
        this.tv.play();
    }
}



