package com.tree.bootroad.v001spring.atguigu.s011value.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    /**
     * @value
     *
     *  1. 基本数值
     *  2. SpEL: #{}
     *  3. ${}: 环境变量中的值
     */
    @Value("#{8 * 2}")
    private int age;

    @Value("lisi")
    private String name;

    @Value("${person.nickName:hi}")
    private String nickName;
}
