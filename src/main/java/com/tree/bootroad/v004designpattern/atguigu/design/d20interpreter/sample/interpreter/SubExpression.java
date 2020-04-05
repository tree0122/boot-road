package com.tree.bootroad.v004designpattern.atguigu.design.d20interpreter.sample.interpreter;

import java.util.Map;

/**
 * 减法符号解析器
 */
public class SubExpression extends SymbolExpression{

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return getLeft().interpreter(var) - getRight().interpreter(var);
    }
}
