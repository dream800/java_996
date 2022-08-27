package com.dream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-26
 */

@Configuration
public class RestConfig {


    @Bean
    public RestTemplate test()
    {

        // RestTemplate restTemplate = new RestTemplate();
        //设置中文乱码问题方式一
        // restTemplate.getMessageConverters().add(1,new StringHttpMessageConverter(Charset.forName("UTF-8")));
        // 设置中文乱码问题方式二
        // restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码

        return new RestTemplate();
    }
}
