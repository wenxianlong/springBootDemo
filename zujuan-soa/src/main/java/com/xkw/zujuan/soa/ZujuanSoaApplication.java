package com.xkw.zujuan.soa;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@SpringBootApplication(scanBasePackages = {"com.xkw.zujuan"})
@EnableDubboConfiguration
public class ZujuanSoaApplication {

    public static void main(String[] args) {
        // 设置环境变量，解决Es的netty与Netty服务本身不兼容问题
        //System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ZujuanSoaApplication.class, args);
    }

}
