package com.fn.inversion;

/**
 * 使用依赖倒转
 */
public class Demo02 {
    public static void main(String[] args) {
        Person2 person2 = new Person2();
        person2.receiver(new Email2());
    }
}

interface Message {
    String getInfo();
}

class Email2 implements Message {
    @Override
    public String getInfo() {
        return "收到email消息";
    }
}

class WeiXin implements Message {
    @Override
    public String getInfo() {
        return "收到微信消息";
    }
}

class Person2 {
    // 消息的来源对接收方法来说变得不重要(入参只需要定义一个消息接口)，想要调用接收方法就传入具体细节(实现类)
    // 因为方法入参依赖的是一个接口，所以不管什么消息入参都不需要改变方法(需要什么消息就去实现Message接口)
    public void receiver(Message message) {
        System.out.println(message.getInfo());
    }
}