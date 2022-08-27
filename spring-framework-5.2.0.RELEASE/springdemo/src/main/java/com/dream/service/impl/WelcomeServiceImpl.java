package com.dream.service.impl;

import com.dream.service.WelcomeService;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String sayHello(String name) {
		System.out.println("welcome : " + name);
		return "success";
	}
}
