package com.tree.bootroad.v004designpattern.atguigu.design.d20interpreter.sample.interpreter;

import java.util.Map;

/**
 * 运算符号解析器
 * 每个运算符号, 都只和自己左右两个数字有关系
 * 左右两个数字也可能是一个解析的结果, 是Expression的实现
 */
public class SymbolExpression extends Expression{
    private Expression left;
    private Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 默认的空实现
     * @param var
     * @return
     */
    @Override
    public int interpreter(Map<String, Integer> var) {
        return 0;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
}
