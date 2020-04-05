package com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample.visitor;


import java.util.ArrayList;
import java.util.List;

public class ObjectStructure{

    List<Person> persons = new ArrayList<>();

    public void add(Person person){
        persons.add(person);
    }

    public void remove(Person person){
        persons.remove(person);
    }

    public void display(Action action){
        for (Person person : persons) {
            person.accept(action);
        }
    }

}
