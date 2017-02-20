package com.board.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import com.board.mybatis.SqlMapSessionFactory;

public class CommonDao {
	
	private SqlSessionFactory myFactory;
	
	public void setFactory() {
		myFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}
	
	protected SqlSessionFactory getFactory() {
		return myFactory;
	}
	
}
