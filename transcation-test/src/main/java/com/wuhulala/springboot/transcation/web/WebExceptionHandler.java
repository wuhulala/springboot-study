package com.wuhulala.springboot.transcation.web;


import com.wuhulala.api.base.BaseException;
import com.wuhulala.api.base.BaseResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能说明: com.wuhulala.springboot.transcation.web<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
@RestControllerAdvice
public class WebExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler
    public BaseResp handleAllException(Exception e){
        logger.error("服务内部错误! ", e);
        if(e instanceof BaseException) {
            return new BaseResp(((BaseException) e).getCode(), ((BaseException) e).getMsg());
        }else{
            return new BaseResp("-1", "未知异常，请查看详细日志!");
        }
    }

}
