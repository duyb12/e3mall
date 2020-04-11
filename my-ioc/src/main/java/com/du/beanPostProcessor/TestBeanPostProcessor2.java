package com.du.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor2 implements BeanPostProcessor, PriorityOrdered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		if ("indexDaoImpl".equals(beanName)) {
//			System.out.println("postProcessBeforeInitialization2");
//		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		if ("indexDaoImpl".equals(beanName)) {
//			System.out.println("postProcessAfterInitialization2");
//		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 200;
	}
}
