package com.du.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * 如果需要原型对象而不是默认的单例，可以实现ApplicationContextAware接口，
 * 重写setApplicationContext()方法，在本类的方法中getApplicationName()即可，
 * 见注释部分
 */
@Repository
public class IndexDaoImpl implements IndexDao {
//public class IndexDaoImpl implements IndexDao, ApplicationContextAware {

//	private ApplicationContext applicationContext;

	public IndexDaoImpl() {
		System.out.println("构造函数");
	}

	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	@Override
	public void query() {
		System.out.println("IndexDaoImpl");
//		applicationContext.getApplicationName();
	}

//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//	}
}
