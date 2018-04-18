package com.wuhulala.springboot.transcation.service;

import com.wuhulala.springboot.transcation.base.BaseException;
import com.wuhulala.springboot.transcation.mapper.UserMapper;
import com.wuhulala.springboot.transcation.model.User;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 功能说明: com.wuhulala.springboot.transcation.service<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
@Service
public class UserService {

    @Autowired
    ShopService shopService;

    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public User findByName(String name) {
        return mapper.selectByPrimaryKey(name);
    }

    @Transactional
    public int updateUser(User user) {
        mapper.updateByPrimaryKeySelective(user);
        Object proxy = AopContext.currentProxy();
        System.out.println(proxy);
        throw new BaseException("-1", "我就不想让你更新成功");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////


    public void testRequiredNoTransaction(){
        //shopService.testA();
        System.out.println(">>>>>>>>>>>>>>>> 我没有事务，我调用一个事务传播行为Propagation.REQUIRED，开始");
        shopService.testTransaction1();
        System.out.println(">>>>>>>>>>>>>>>> 我没有事务，我调用一个事务传播行为Propagation.REQUIRED，结束");
    }

    @Transactional
    public void testRequiredHasTransaction(){
        //shopService.testA();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.REQUIRED，开始");
        shopService.testTransaction1();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.REQUIRED，结束");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Transactional
    public void testSupportsOfHasTransaction(){
        //shopService.testA();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.SUPPORTS，开始");
        shopService.testTransactionSupports();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.SUPPORTS，结束");
    }


    public void testSupportsOfNoTransaction(){
        //shopService.testA();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.SUPPORTS，开始");
        shopService.testTransactionSupports();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.SUPPORTS，结束");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Transactional
    public void testRequiredNewOfHasTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.REQUIRED_NEW，开始");
        shopService.testTransactionRequiredNew();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.REQUIRED_NEW，结束");
    }

    public void testRequiredNewOfNoTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.REQUIRED_NEW，开始");
        shopService.testTransactionRequiredNew();
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.REQUIRED_NEW，结束");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Transactional
    public void testMandatoryOfHasTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.MANDATORY，开始");
        shopService.testTransactionMandatory();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.MANDATORY，结束");
    }

    public void testMandatoryOfNoTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.MANDATORY，开始");
        shopService.testTransactionMandatory();
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.MANDATORY，结束");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Transactional
    public void testNestedOfHasTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NESTED，开始");
        shopService.testTransactionNested();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NESTED，结束");
    }


    @Transactional
    public void testNestedOfHasTransactionWithException() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NESTED，开始");
        shopService.testTransactionNested();
        throw new BaseException("-1", "外层调用函数抛出异常！！");
    }

    @Transactional
    public void testNestedOfHasTransactionWithNestedException() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NESTED，开始");
        User user = new User();
        user.setName("wuhulala");
        user.setRemark("内层事务回滚。外层事务不回滚！！！");
        mapper.updateByPrimaryKeySelective(user);
        try {
            shopService.testTransactionNestedWithException();
        } catch (Exception e){
            // do nothing
        }
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NESTED，结束");
    }

    public void testNestedOfNoTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.NESTED，开始");
        shopService.testTransactionNested();
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.NESTED，结束");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Transactional
    public void testNeverOfHasTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NEVER，开始");
        shopService.testTransactionNever();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NEVER，结束");
    }

    public void testNeverOfNoTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.NEVER，开始");
        shopService.testTransactionNever();
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.NEVER，结束");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    @Transactional
    public void testNotSupportedOfHasTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NOT_SUPPORTED，开始");
        shopService.testTransactionNotSupported();
        System.out.println(">>>>>>>>>>>>>>>> 我有事务，我调用一个事务传播行为Propagation.NOT_SUPPORTED，结束");
    }

    public void testNotSupportedOfNoTransaction() {
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.NOT_SUPPORTED，开始");
        shopService.testTransactionNotSupported();
        System.out.println(">>>>>>>>>>>>>>>> 我没事务，我调用一个事务传播行为Propagation.NOT_SUPPORTED，结束");
    }
}
