package com.tree.bootroad.v004designpattern.atguigu.design.d20interpreter.sample.interpreter;

import java.util.LinkedList;
import java.util.Map;

public class Calculator {

    // 表达式
    private Expression expression;

    public Calculator(String expStr) {
        LinkedList<Expression> stack = new LinkedList<>();
        Expression left = null, right = null;
        char t = ' ';
        for (int i = 0; i < expStr.length(); i++) {
            t = expStr.charAt(i);
            switch (t){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(expStr.charAt(++i) + "");
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(expStr.charAt(++i) + "");
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(t + ""));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    /**
     *
     * var = {a=10, b=20}
     * @param var
     * @return
     */
    public int run(Map<String, Integer> var){
        return expression.interpreter(var);
    }

}
