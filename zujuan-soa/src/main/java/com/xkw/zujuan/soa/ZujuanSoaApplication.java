package com.xkw.zujuan.soa;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动类
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@SpringBootApplication(scanBasePackages = {"com.xkw.zujuan"})
@EnableDubbo
@ImportResource({"classpath:dubbo-provider.xml","classpath:dubbo-customer.xml"})
public class ZujuanSoaApplication {

    public static void main(String[] args) {
        // 设置环境变量，解决Es的netty与Netty服务本身不兼容问题
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ZujuanSoaApplication.class, args);
    }

}
