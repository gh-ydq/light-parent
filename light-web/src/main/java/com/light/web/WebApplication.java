package com.light.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@ComponentScan("com.light")
//@EntityScan("entity对应的包路径")
@EntityScan("com.light.core.entity")
public class WebApplication extends WebMvcConfigurerAdapter{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
	{
		super.configureMessageConverters(converters);
        /*
         * 1、需要先定义一个 convert 转换消息对象；
         * 2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
         * 3、在 Convert 中添加配置信息;
         * 4、将 convert 添加到 converts 中;
         */

		//1、需要先定义一个 convert 转换消息对象；
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		//2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		//3、在 Convert 中添加配置信息;
		fastConverter.setFastJsonConfig(fastJsonConfig);

		//4、将 convert 添加到 converts 中;
		converters.add(fastConverter);

	}

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
