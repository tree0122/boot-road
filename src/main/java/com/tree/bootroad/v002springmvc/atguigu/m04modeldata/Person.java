package com.tree.bootroad.v002springmvc.atguigu.m04modeldata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;

    private int age;

    private String name;

    private String password;
}
