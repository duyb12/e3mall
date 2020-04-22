package com.du.copy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * 	实现BeanPostProcessor对bean实例化过程进行控制（TestBeanPostProcessor），
 * 	可以实现PriorityOrdered实现getOrder()设置顺序
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("indexDaoImpl".equals(beanName)) {
			System.out.println("postProcessBeforeInitialization");
		}
		//也可以返回代理对象
		Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new MyInvocationHandler());
		//return proxy;
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("indexDaoImpl".equals(beanName)) {
			System.out.println("postProcessAfterInitialization");
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 300;
	}
}
