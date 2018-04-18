package com.wuhulala.springboot.transcation.controller;

import com.wuhulala.springboot.transcation.base.BaseResp;
import com.wuhulala.springboot.transcation.model.User;
import com.wuhulala.springboot.transcation.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Set;

/**
 * 功能说明: com.wuhulala.springboot.transcation.controller<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
@RestController
public class UserController implements BeanFactoryAware{

    @Autowired
    UserService service;

    @GetMapping("/user/{username}")
    public User findOneUser(@PathVariable("username")String username){
        return service.findByName(username);
    }

    @PutMapping("/user")
    public BaseResp<User> updateOneUser(@RequestBody User user){
        int udpateCount = service.updateUser(user);
        return udpateCount == 1 ? new BaseResp<User>() : new BaseResp<>("-1", "更新失败！");
    }

    @GetMapping("/datasource/list")
    public BaseResp<Set<String>> getAllDataSource(){
        Map<String, DataSource> dataSources;
        dataSources = ((ListableBeanFactory)beanFactory).getBeansOfType(DataSource.class);

        BaseResp result = new BaseResp();
        result.setItem(dataSources.keySet());
        return result;
    }

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
