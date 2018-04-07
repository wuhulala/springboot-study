package com.wuhulala.springboot.async.comp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: com.wuhulala.springboot.async.comp<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/7<br>
 */
@Component
public class CookTask {
    

    private static final Logger logger = LoggerFactory.getLogger(CookTask.class);

    /**
     * 洗菜
     */
    @Async("cookTaskExecutor")
    public Future<String> washVegetables() throws InterruptedException {
        logger.info(">>>>>>>>>>>>>>>>>>>>>开始洗菜<<<<<<<<<<<<<<<<<<");

        TimeUnit.SECONDS.sleep(10);

        logger.info(">>>>>>>>>>>>>>>>>>>>>结束洗菜<<<<<<<<<<<<<<<<<<");
        return new AsyncResult<>("洗菜任务完成");

    }

    /**
     * 切菜
     */
    @Async("cookTaskExecutor")
    public Future<String> cutVegetables() throws InterruptedException {
        logger.info(">>>>>>>>>>>>>>>>>>>>>开始切菜<<<<<<<<<<<<<<<<<<");

        TimeUnit.SECONDS.sleep(10);

        logger.info(">>>>>>>>>>>>>>>>>>>>>结束切菜<<<<<<<<<<<<<<<<<<");
        return new AsyncResult<>("切菜任务完成");
    }

    /**
     * 做菜
     */
    @Async("cookTaskExecutor")
    public Future<String> doCook() throws InterruptedException {
        logger.info(">>>>>>>>>>>>>>>>>>>>>开始做菜<<<<<<<<<<<<<<<<<<");

        TimeUnit.SECONDS.sleep(10);

        logger.info(">>>>>>>>>>>>>>>>>>>>>结束做菜<<<<<<<<<<<<<<<<<<");
        return new AsyncResult<>("做菜任务完成");
    }

}
