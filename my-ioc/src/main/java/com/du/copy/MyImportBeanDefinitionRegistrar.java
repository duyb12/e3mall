package com.du.copy;

import com.du.dao.IndexDao;
import com.du.test.TestApp;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/*Class userClass;

	public MyImportBeanDefinitionRegistrar(Class clazz) {
		this.userClass = clazz;
	}*/

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		IndexDao indexDao = (IndexDao) Proxy.newProxyInstance(TestApp.class.getClassLoader(),
											new Class[]{IndexDao.class}, new MyInvocationHandler());
		System.out.println(indexDao.hashCode());
		indexDao.query();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(IndexDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
		registry.registerBeanDefinition("myIndexDao", beanDefinition);
	}
}
