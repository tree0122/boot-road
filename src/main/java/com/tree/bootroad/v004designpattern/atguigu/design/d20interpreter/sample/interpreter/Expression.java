package com.tree.bootroad.v004designpattern.atguigu.design.d20interpreter.sample.interpreter;

import java.util.Map;

public abstract class Expression {

    /**
     * a + b - c
     *
     * 解释公式和数值,
     * key   是表达式参数[a, b, c]
     * value 是具体的参数值
     * {a=10, b=20}
     * @param var
     * @return
     */
    public abstract int interpreter(Map<String, Integer> var);

}
