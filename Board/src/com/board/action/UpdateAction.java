package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class UpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		Board article = new Board();
		
		article.setIdx(Integer.parseInt(request.getParameter("idx")));
		article.setTitle(request.getParameter("title"));
		article.setWriter(request.getParameter("writer"));
		article.setContent(request.getParameter("content"));
		
		if(BoardDao.getInstance().updateArticle(article)) {
			return "viewArticle.do?idx=" + article.getIdx();
		}
		else {
			return "changeWrite.jsp";
		}
		
	}

}
