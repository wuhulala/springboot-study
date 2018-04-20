package com.wuhulala.springboot.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 功能说明: com.wuhulala.springboot.spel<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/20<br>
 */
public class SimpleSpel {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        exp = parser.parseExpression("'Hello World'.concat('!!!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
