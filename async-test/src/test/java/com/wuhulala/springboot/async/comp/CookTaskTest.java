package com.wuhulala.springboot.async.comp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * 功能说明: com.wuhulala.springboot.async.comp<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/7<br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CookTaskTest {

    private static final Logger logger = LoggerFactory.getLogger(CookTaskTest.class);

    @Autowired
    CookTask task;
    @Test
    public void doTask() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> wash = task.washVegetables();
        Future<String> cut = task.cutVegetables();
        Future<String> cook = task.doCook();
        while(true){
            if(wash.isDone() && cut.isDone() && cook.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();

        logger.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}