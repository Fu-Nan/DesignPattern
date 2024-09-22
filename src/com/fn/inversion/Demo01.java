package com.fn.inversion;

/**
 * 写一个Person类接受消息
 * 平常的写法，不使用依赖倒转
 */
public class Demo01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receiver(new Email());
    }
}

class Email {
    public String getInfo() {
        return "接受到email消息";
    }
}

class Person {
    // 如果receiver还要接受微信、短信消息，要么修改方法入参，要么对方法重载。
    public void receiver(Email email) {
        System.out.println(email.getInfo());
    }
}
