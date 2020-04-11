package com.du.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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
//		Object o = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				//搜索return ReflectionUtils.invokeMethod查看样例
//				return ReflectionUtils.invokeMethod(method, bean, args);
//			}
//		});
//		return o;
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
