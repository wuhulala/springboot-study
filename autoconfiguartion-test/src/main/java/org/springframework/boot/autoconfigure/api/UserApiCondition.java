package org.springframework.boot.autoconfigure.api;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 功能说明: com.wuhulala.springboot.autoconfiguration.condition<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/6<br>
 */
public class UserApiCondition extends SpringBootCondition{
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean enable = context.getEnvironment().getProperty("user.enable", Boolean.class);
        System.out.println(enable);
        return new ConditionOutcome(enable, "用户开关开启状态：" + enable);
    }
}
