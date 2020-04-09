package com.du.test;

import com.du.config.AppConfig;
import com.du.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		IndexDao indexDao = (IndexDao) context.getBean("indexDaoImpl");
		indexDao.query();

	}
}
