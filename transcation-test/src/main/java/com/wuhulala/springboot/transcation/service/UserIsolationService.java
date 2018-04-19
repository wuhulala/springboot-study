package com.wuhulala.springboot.transcation.service;

import com.wuhulala.api.base.BaseException;
import com.wuhulala.springboot.transcation.mapper.UserMapper;
import com.wuhulala.springboot.transcation.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 功能说明: com.wuhulala.springboot.transcation.service<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/18<br>
 */
@Service
public class UserIsolationService {

    private static final Logger logger = LoggerFactory.getLogger(UserIsolationService.class);

    private final UserMapper mapper;

    @Autowired
    public UserIsolationService(UserMapper mapper) {
        this.mapper = mapper;
    }


    public User findByName(String name) {
        return mapper.findByName(name);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public int readUnCommit(User user) {
        logger.info("READ_UNCOMMITTED:历史数据：" + findByName(user.getName()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("READ_UNCOMMITTED:历史数据：" + findByName(user.getName()));
        return 1;
        //mapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public int updateUserReadUnCommit(User user) {

        mapper.updateByName(user);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new BaseException("-1", "我又回滚了额");
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int readCommit(User user) {
        logger.info("READ_COMMITTED 历史数据：" + findByName(user.getName()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("READ_COMMITTED 历史数据：" + findByName(user.getName()));
        return 1;
        //mapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void repeatRead(User user) {
        logger.info("REPEATABLE_READ:历史数据：" + findByName(user.getName()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("REPEATABLE_READ:历史数据：" + findByName(user.getName()));
    }
}
