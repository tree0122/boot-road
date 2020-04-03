package com.tree.bootroad.v004designpattern.atguigu.principle.p02interfacesegregation;

public class Segregation1 {

    public static void main(String[] args) {
        C1 c1 = new C1();
        A a = new A();
        c1.depend1(a); // C1 依赖于 A
        c1.depend2(a);
        c1.depend3(a);

        C2 c2 = new C2();
        B b = new B();
        c2.depend1(b); // C2 依赖于 B
        c2.depend2(b);
        c2.depend3(b);
    }


}

interface Ia{
    void m1();
    void m2();
    void m3();
    void m4();
    void m5();
}

interface I1{
    void m1();
}

interface I2{
    void m2();
    void m3();
}

interface I3{
    void m4();
    void m5();
}

class C1 {
    public void depend1(I1 i1){
        i1.m1();
    }

    public void depend2(I2 i2){
        i2.m2();
    }

    public void depend3(I2 i2){
        i2.m3();
    }
}

class C2 {
    public void depend1(I1 i1){
        i1.m1();
    }

    public void depend2(I3 i3){
        i3.m4();
    }

    public void depend3(I3 i3){
        i3.m5();
    }
}

class A implements I1, I2{

    @Override
    public void m1() {
        System.out.println("A#m1()");
    }

    @Override
    public void m2() {
        System.out.println("A#m2()");
    }

    @Override
    public void m3() {
        System.out.println("A#m3()");
    }
}

class B implements I1, I3{

    @Override
    public void m1() {
        System.out.println("B#m1()");
    }

    @Override
    public void m4() {
        System.out.println("B#m4()");
    }

    @Override
    public void m5() {
        System.out.println("B#m5()");
    }
}
