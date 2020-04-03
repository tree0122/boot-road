package com.tree.bootroad.v004designpattern.atguigu.principle.p04liskow;

public class Liskow {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3" + a.func1(11, 3));
        System.out.println("1-8" + a.func1(1, 8));
        System.out.println("----------------------");

        B b = new B();
        System.out.println("11-3" + b.func1(11, 3)); // 本意是求 11-3
        System.out.println("1-8" + b.func1(1, 8));
        System.out.println("11+3+9" + b.func1(11, 3));
    }
}

class A{
    public int func1(int i, int j){
        return i - j;
    }
}

class B extends A{
    // 重写了A的方法, 可能是无意识的
    public int func1(int i, int j){
        return i + j;
    }

    public int func2(int i, int j){
        return func1(i, j) + 9;
    }
}

// right way

class Base{

}

class A1 extends Base{
    public int func1(int i, int j){
        return i - j;
    }
}

class B1 extends Base{
    // 组合关系, 得到A1的方法
    private A1 a1 = new A1();

    public int func1(int i, int j){
        return i + j;
    }

    public int func2(int i, int j){
        return func1(i, j) + 9;
    }
    public int func3(int i, int j){
        return this.a1.func1(i, j);
    }
}
