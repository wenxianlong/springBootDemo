package com.xkw.zujuan.common.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * es配置类
 *
 * @author wenxianlong
 * @date 2019-08-15
 **/
public class EsConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        // 9300是es的tcp服务端口
        TransportAddress node = new TransportAddress(
                InetAddress.getByName("127.0.0.1"),
                9300);

        // 设置es节点的配置信息
        Settings settings = Settings.builder()
                .put("cluster.name", "my-application")
                .put("client.transport.sniff", true)
                .build();

        // 实例化es的客户端对象
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }
}
