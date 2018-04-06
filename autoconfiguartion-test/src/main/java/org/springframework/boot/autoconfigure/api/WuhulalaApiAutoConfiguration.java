package org.springframework.boot.autoconfigure.api;

import com.wuhulala.api.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 功能说明: org.springframework.boot.autoconfigure.api<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/6<br>
 */
@Configuration
@ConditionalOnClass(User.class)
@EnableConfigurationProperties(UserProperties.class)
public class WuhulalaApiAutoConfiguration {

    private final UserProperties properties;

    public WuhulalaApiAutoConfiguration(UserProperties properties) {
        this.properties = properties;
    }

    @Bean
    @Conditional(UserApiCondition.class)
    public User owner(){
        String name = properties.getUsername();
        String phone = properties.getPhone();
        String mail = properties.getEmail();
        User user = new User(name, mail, phone);
        System.out.println(user);
        return user;
    }
}
