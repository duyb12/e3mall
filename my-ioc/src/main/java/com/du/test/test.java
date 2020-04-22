package com.du.test;

import com.du.config.AppConfig;
import com.du.dao.IndexDao;
import com.du.dao.IndexDaoImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {

	//很重要的一个类 ConfigurationClassPostProcessor

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		IndexDao indexDao = (IndexDao) context.getBean("indexDaoImpl");
		IndexDao indexDao2 = (IndexDao) context.getBean("indexDaoImpl");
		indexDao.query();
		System.out.println("indexDao: " + indexDao.hashCode());
		System.out.println("indexDao2: " + indexDao2.hashCode());
	}

	/**
	 * 可以单个类注册，初始化不扫描包。后处理，需要手动refresh()
	 */
	@Test
	public void testSingleClassRegister() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(IndexDaoImpl.class);
		context.refresh();
		IndexDao indexDao = (IndexDao) context.getBean("indexDaoImpl");
		indexDao.query();

	}

	/**
	 * 实现BeanPostProcessor对bean实例化过程进行控制（TestBeanPostProcessor），
	 * 	可以实现PriorityOrdered实现getOrder()设置顺序
	 */
	@Test
	public void testBeanPostProcessor() {
		//把spring所有的前提准备好
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		IndexDao indexDao = (IndexDao) context.getBean("indexDaoImpl");
		indexDao.query();

	}
}
