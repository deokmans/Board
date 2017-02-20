package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.beans.Board;

public class BoardDao extends CommonDao {
	
	// Singleton
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		_instance.setFactory();
		return _instance;
	}
	

	public List<Board> getArticleList() throws SQLException {
		
		SqlSession session = getFactory().openSession();
		List<Board> articleList = session.selectList("getArticleList");
		
		session.commit();
		session.close();
		
		return articleList;
	}
	
	public boolean insertArticle(Board article) {

		SqlSession session = getFactory().openSession();
		
		try {
			session.insert("insertArticle", article);
			
			return true;
		} catch(Exception e) {
			System.out.println("insert error");
			System.out.println(article.getContent());
			return false;
		} finally {
			session.commit();
			session.close();
		}
		
	}
	
	public boolean deleteArticle(int idx) {
		
		SqlSession session = getFactory().openSession();
				
		try {
			session.delete("deleteArticle", idx);
			
			return true;
		} catch(Exception e) {
			System.out.println("delete error");
			return false;
		} finally {
			session.commit();
			session.close();
		}
	}
	
	public Board getArticle(int idx) {
		
		SqlSession session = getFactory().openSession();
		
		Board article = session.selectOne("selectArticle", idx);
		
		session.commit();
		session.close();
		
		return article;
	}
	
	public boolean updateArticle(Board article) {
		
		SqlSession session = getFactory().openSession();
		
		try {
			session.update("updateArticle", article);
			
			return true;
		} catch(Exception e) {
			System.out.println("update error");
			return false;
		} finally {
			session.commit();
			session.close();
		}
	}
}
