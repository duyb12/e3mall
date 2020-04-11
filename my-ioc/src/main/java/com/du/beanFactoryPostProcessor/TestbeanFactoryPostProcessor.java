package com.du.beanFactoryPostProcessor;

import com.du.dao.IndexDao;
import com.du.dao.IndexDaoImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Component交给spring管理
 * 得到AnnotatedBeanDefinition，设置scope
 */
@Component
public class TestbeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AnnotatedBeanDefinition abd = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("indexDaoImpl");
		abd.setScope("prototype");
	}
}
