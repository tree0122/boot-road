package com.tree.bootroad.v004designpattern.atguigu.principle.p03inversion;

public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());

        person.receive(new Weixin());
    }
}
/*
class Person{
    public void receive(Email email){
        System.out.println(email.info());
    }
}


class Email{
    public String info(){
        return "email info: hello world";
    }
}*/

class Person{
    public void receive(IReceiver receiver){
        System.out.println(receiver.info());
    }
}

interface IReceiver{
    String info();
}

class Email implements IReceiver{
    public String info(){
        return "email info: hello world";
    }
}

class Weixin implements IReceiver{
    public String info(){
        return "weixin info: hello world";
    }
}