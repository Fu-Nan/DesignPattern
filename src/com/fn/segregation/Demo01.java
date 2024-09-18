package com.fn.segregation;

public class Demo01 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1();
        a.depend2();
        a.depend3();

        System.out.println("================");

        C c = new C();
        c.depend1();
        c.depend2();
        c.depend3();
    }
}

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();

    void method3();
}

interface Interface3 {
    void method4();

    void method5();
}

class A {
    private final Interface1 interface1 = new B();
    private final Interface2 interface2 = new B();

    public void depend1() {
        interface1.method1();
    }

    public void depend2() {
        interface2.method2();
    }

    public void depend3() {
        interface2.method3();
    }
}

class B implements Interface1, Interface2 {
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

class C {
    private final Interface1 interface1 = new D();
    private final Interface3 interface3 = new D();

    public void depend1(){
        interface1.method1();
    }

    public void depend2(){
        interface3.method4();
    }

    public void depend3(){
        interface3.method5();
    }
}

class D implements Interface1, Interface3 {
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