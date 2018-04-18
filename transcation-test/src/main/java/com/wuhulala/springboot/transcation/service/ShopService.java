package com.wuhulala.springboot.transcation.service;

import com.wuhulala.springboot.transcation.base.BaseException;
import com.wuhulala.springboot.transcation.mapper.UserMapper;
import com.wuhulala.springboot.transcation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明: com.wuhulala.springboot.transcation.service<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
@Service
public class ShopService {


    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void testA() {
        System.out.println("无所谓，被调用事务。。。");
    }

    public void testNoTx() {
        System.out.println("无所谓，我没有事务。。。");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransaction1() {
        System.out.println("我就是测试事务传播行为PROPAGATION_REQUIRED的");
        System.out.println("表示当前方法必须在一个具有事务的上下文中运行，如有客户端有事务在进行，那么被调用端将在该事务中运行，否则的话重新开启一个事务。（如果被调用端发生异常，那么调用端和被调用端事务都将回滚）");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void testTransactionSupports() {
        System.out.println("我就是测试事务传播行为PROPAGATION_SUPPORTS的");
        System.out.println("表示当前方法不必需要具有一个事务上下文，但是如果有一个事务的话，它也可以在这个事务中运行\n" +
                "\n");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void testTransactionMandatory() {
        System.out.println("表示当前方法必须在一个事务中运行，如果没有事务，将抛出异常");
        System.out.println("我就是测试事务传播行为PROPAGATION_MANDATORY的");
    }


    @Transactional(propagation = Propagation.NESTED)
    public void testTransactionNested() {
        System.out.println("我就是测试事务传播行为PROPAGATION_NESTED的");
        System.out.println("表示如果当前方法正有一个事务在运行中，则该方法应该运行在一个嵌套事务中，\n" +
                "被嵌套的事务可以独立于被封装的事务中进行提交或者回滚。\n" +
                "如果封装事务存在，并且外层事务抛出异常回滚，那么内层事务必须回滚，反之，内层事务并不影响外层事务。\n" +
                "如果封装事务不存在，则同PROPAGATION_REQUIRED的一样\n" +
                "\n");
    }



    @Transactional(propagation = Propagation.NESTED)
    public void testTransactionNestedWithException() {
        User user = new User();
        user.setName("hlx");
        user.setRemark("hlx-内层事务回滚。外层事务不回滚！！！");
        userMapper.updateByPrimaryKeySelective(user);
        System.out.println("我就是测试事务传播行为PROPAGATION_NESTED抛出异常的");
        System.out.println("表示如果当前方法正有一个事务在运行中，则该方法应该运行在一个嵌套事务中，\n" +
                "被嵌套的事务可以独立于被封装的事务中进行提交或者回滚。\n" +
                "如果封装事务存在，并且外层事务抛出异常回滚，那么内层事务必须回滚，反之，内层事务并不影响外层事务。\n" +
                "如果封装事务不存在，则同PROPAGATION_REQUIRED的一样\n" +
                "\n");
        throw new BaseException("-1", "内层事务抛出异常");
    }


    @Transactional(propagation = Propagation.NEVER)
    public void testTransactionNever() {
        System.out.println("我就是测试事务传播行为PROPAGATION_NEVER的");
        System.out.println("表示当方法不应该在一个事务中运行，如果存在一个事务，则抛出异常\n" +
                "\n");
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testTransactionRequiredNew() {
        System.out.println("我就是测试事务传播行为PROPAGATION_REQUIRES_NEW的");
        System.out.println("表示当前方法必须运行在它自己的事务中。一个新的事务将启动，而且如果有一个现有的事务在运行的话，则这个方法将在运行期被挂起，直到新的事务提交或者回滚才恢复执行。\n" +
                "\n");
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testTransactionNotSupported() {
        System.out.println("我就是测试事务传播行为PROPAGATION_NOT_SUPPORTED的");
        System.out.println("表示该方法不应该在一个事务中运行。\n" +
                "如果有一个事务正在运行，事务将被挂起，直到当前方法执行完成才恢复执行\n" +
                "\n");
        System.out.println("睡眠5s");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("睡醒了");
    }
}
