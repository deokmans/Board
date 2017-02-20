package com.board.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	public static SqlSessionFactory ssf;
	
	static {
		String resource="com/board/mybatis/MyBatisConfig.xml";
		
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("sqlsession");
		}
		
		ssf = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return ssf;
	}
}
