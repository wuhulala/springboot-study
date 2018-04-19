package com.wuhulala.springboot.transcation.service;

import com.wuhulala.springboot.transcation.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

/**
 * 功能说明: com.wuhulala.springboot.transcation.service<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/18<br>
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IsolationTest {

    @Autowired
    UserIsolationService service;

    /**
     * 修改mysql Isolation级别
     * <pre>
     *    SET GLOBAL TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
     *    SELECT @@tx_isolation;
     * </pre>
     */
    @Test
    public void testReadUncommitted() throws InterruptedException {
        CountDownLatch stop = new CountDownLatch(2);
        new Thread(() -> {
            User user = new User();
            user.setName("wuhulala");
            user.setRemark("wuhulala222222");
            service.updateUserReadUnCommit(user);
            stop.countDown();
        }).start();

        new Thread(() -> {
            User user = new User();
            user.setName("wuhulala");
            service.readCommit(user);
            service.readUnCommit(user);
            service.repeatRead(user);
            stop.countDown();
        }).start();

        Thread.sleep(30000);
    }



}
