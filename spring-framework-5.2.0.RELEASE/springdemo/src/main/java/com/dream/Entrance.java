package com.dream;

import com.dream.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public class Entrance {

	public static void main(String[] args) {
		System.out.println("hello world");


		String xml = "D:\\code\\java2022\\java_996\\spring-framework-5.2.0.RELEASE\\springdemo\\src\\main\\resources\\spring\\spring-config.xml";

		ApplicationContext context = new FileSystemXmlApplicationContext(xml);

		WelcomeService welcome = (WelcomeService) context.getBean("welcome");
		welcome.sayHello("hahahaha.....");


	}

}
