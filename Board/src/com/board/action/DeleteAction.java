package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class DeleteAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		if(BoardDao.getInstance().deleteArticle(idx)) {
			return "list.do";
		}
		else {
			return "content.jsp?idx" + idx;
		}
		
	}

}
