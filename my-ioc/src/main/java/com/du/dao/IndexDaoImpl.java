package com.du.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDaoImpl implements IndexDao {
	@Override
	public void query() {
		System.out.println("IndexDaoImpl");
	}
}
