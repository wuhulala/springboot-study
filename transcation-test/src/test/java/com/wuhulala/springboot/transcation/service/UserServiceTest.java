package com.wuhulala.springboot.transcation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能说明: com.wuhulala.springboot.transcation.service<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired UserService service;

    //////////////////////////////////////////////////////////////////
    //   可以发现在调用方法中有事务的话，被调用方法不会新建事务，直接执行
    //   可以发现在调用方法中没有事务的话，会新建一个事务用于执行
    //////////////////////////////////////////////////////////////////
    @Test
    public void testTransaction1() throws Exception {
        service.testRequiredNoTransaction();
    }

    @Test
    public void testTransaction2() throws Exception {
        service.testRequiredHasTransaction();
    }

    //////////////////////////////////////////////////////////////////
    //   可以发现无论有没有事务，supports都不会去创建一个事务
    //////////////////////////////////////////////////////////////////

    @Test
    public void testTransaction3() throws Exception {
        service.testSupportsOfHasTransaction();
    }


    @Test
    public void testTransaction4() throws Exception {
        service.testSupportsOfNoTransaction();
    }



    //////////////////////////////////////////////////////////////////
    //   可以发现无论有没有事务，required都会创建一个事务
    //////////////////////////////////////////////////////////////////

    @Test
    public void testTransaction5() throws Exception {
        service.testRequiredNewOfHasTransaction();
    }


    @Test
    public void testTransaction6() throws Exception {
        service.testRequiredNewOfNoTransaction();
    }

    //////////////////////////////////////////////////////////////////
    // mandatory在没有事务的环境下会抛出异常IllegalTransactionStateException
    // mandatory在由事务的环境下正常运行
    //////////////////////////////////////////////////////////////////

    @Test
    public void testTransaction7() throws Exception {
        try {
            service.testMandatoryOfNoTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testTransaction8() throws Exception {
        try {
            service.testMandatoryOfHasTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////
    // nested 默认会创建一个nested transaction
    // 在外层事务抛出异常下，内层事务会回滚 test11
    // 在内层事务抛出异常下，外层事务不会回滚 test12
    //
    //////////////////////////////////////////////////////////////////

    @Test
    public void testTransaction9() throws Exception {
        try {
            service.testNestedOfNoTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testTransaction10() throws Exception {
        try {
            service.testNestedOfHasTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testTransaction11() throws Exception {
        try {
            service.testNestedOfHasTransactionWithException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testTransaction12() throws Exception {
        try {
            service.testNestedOfHasTransactionWithNestedException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////
    // never在有事务的环境下会抛出异常IllegalTransactionStateException
    // never在没有事务的环境下正常运行,与mandatory正好相反
    //////////////////////////////////////////////////////////////////

    @Test
    public void testTransaction13() throws Exception {
        try {
            service.testNeverOfNoTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testTransaction14() throws Exception {
        try {
            service.testNeverOfHasTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////
    // not_supported 在有事务的环境下会将当前事务挂起，执行完当前方法结束会再把事务唤醒
    // not_supported 在没有事务的环境下直接运行。不等待
    //////////////////////////////////////////////////////////////////

    @Test
    public void testTransaction15() throws Exception {
        try {
            service.testNotSupportedOfHasTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testTransaction16() throws Exception {
        try {
            service.testNotSupportedOfNoTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
