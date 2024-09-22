package com.fn.inversion;

public class DependencyPass {
}

///**
// * 方式一：接口传递
// */
//interface ITV {
//    // 打开小米电视还是华为电视用实现类去做
//    void play();
//}
//
//interface IOpenAndClose {
//    // 通过接口的入参来传递实例
//    // 只管打开电视，不用管去打开什么品牌的电视；所以如果需求改变，只需要在客户端传入实现类，底层的open()方法逻辑不会改变。
//    void open(ITV tv);
//}
//
//class OpenAndCloseImpl implements IOpenAndClose {
//    @Override
//    public void open(ITV tv) {
//        tv.play();
//    }
//}


/**
 * 方式二：构造器传递
 */
interface ITV {
    void play();
}

interface IOpenAndClose {
    void open();
}

class OpenAndCloseImpl implements IOpenAndClose {
    // 每个实现类的构造方法来进行依赖传递
    private final ITV tv;

    public OpenAndCloseImpl(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void open() {
        tv.play();
    }
}

///**
// * 方式三：setter传递
// */
//interface ITV {
//    void play();
//}
//
//interface IOpenAndClose {
//    void open();
//
//    void setTV(ITV tv);
//}
//
//class OpenAndCloseImpl implements IOpenAndClose {
//    private ITV tv;
//
//    // 要使用open()方法，必须先调用setTV方法，将接口传递过来
//    @Override
//    public void setTV(ITV tv) {
//        this.tv = tv;
//    }
//
//    @Override
//    public void open() {
//        tv.play();
//    }
//}
