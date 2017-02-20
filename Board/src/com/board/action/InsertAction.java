package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		Board board = new Board();
		
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setPassword(request.getParameter("password"));
		board.setContent(request.getParameter("content"));
				
		if(BoardDao.getInstance().insertArticle(board)) {
			return "list.do";
		}
		else {
			return "write.jsp";
		}

	}
	
}
