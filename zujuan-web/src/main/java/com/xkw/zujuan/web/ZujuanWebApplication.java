package com.xkw.zujuan.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@SpringBootApplication(scanBasePackages = {"com.xkw.zujuan"})
public class ZujuanWebApplication {

    public static void main(String[] args) {
        // 设置环境变量，解决Es的netty与Netty服务本身不兼容问题
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ZujuanWebApplication.class, args);
    }

}
