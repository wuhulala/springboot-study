package com.wuhulala.springboot.spel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
public class SimpleSpelTest {


    private ExpressionParser parser;
    private String expString;

    @Before
    public void init() {
        parser = new SpelExpressionParser();
    }


    @After
    public void print() {
        Expression exp = parser.parseExpression(expString);
        System.out.println(exp.getValue());
    }

    @Test
    public void test1() throws Exception {
        expString = "'Hello World'.concat('!')";
    }

    @Test
    public void test2() throws Exception {
        expString = "'Hello World'.concat('!').length()";
    }

    @Test
    public void test3(){
        expString = "0x7FFFFFFF";
    }

    @Test
    public void test4(){
        expString = "2 < -5.0";
    }





}