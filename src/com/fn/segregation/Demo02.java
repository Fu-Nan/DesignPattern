package com.fn.segregation;

/**
 * 更优雅的写法(视情况而定)
 */
public class Demo02 {
    public static void main(String[] args) {
        J j = new J();
        j.depend1(new K());
        j.depend2(new K());
        j.depend3(new K());

        System.out.println("=================");

        L l = new L();
        l.depend1(new M());
        l.depend2(new M());
        l.depend3(new M());
    }

}

interface Inter1 {
    void method1();
}

interface Inter2 {
    void method2();

    void method3();
}

interface Inter3 {
    void method4();

    void method5();
}

class J {

    public void depend1(Inter1 inter1) {
        inter1.method1();
    }

    public void depend2(Inter2 inter2) {
        inter2.method2();
    }

    public void depend3(Inter2 inter2) {
        inter2.method3();
    }
}

class K implements Inter1, Inter2 {
    @Override
    public void method1() {
        System.out.println("B的方法1");
    }

    @Override
    public void method2() {
        System.out.println("B的方法2");
    }

    @Override
    public void method3() {
        System.out.println("B的方法3");
    }
}

class L {

    public void depend1(Inter1 inter1) {
        inter1.method1();
    }

    public void depend2(Inter3 inter3) {
        inter3.method4();
    }

    public void depend3(Inter3 inter3) {
        inter3.method5();
    }
}

class M implements Inter1, Inter3 {
    @Override
    public void method1() {
        System.out.println("D的方法1");
    }

    @Override
    public void method4() {
        System.out.println("D的方法4");
    }

    @Override
    public void method5() {
        System.out.println("D的方法5");
    }
}