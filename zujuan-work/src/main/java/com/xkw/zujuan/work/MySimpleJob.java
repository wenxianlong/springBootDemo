package com.xkw.zujuan.work;

import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 *
 * @author wenxianlong
 * @date 2019-08-16
 */

@ElasticJobConf(name = "mySimpleJob", cron = "0/10 * * * * ?")
public class MySimpleJob implements SimpleJob {
    @Override
    public void execute(ShardingContext context) {
        System.out.println(2 / 0);
        String shardParameter = context.getShardingParameter();
        System.out.println("分片参数：" + shardParameter);
        int value = Integer.parseInt(shardParameter);
        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == value) {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                System.out.println(time + ":开始执行简单任务" + i);
            }
        }
    }
}
