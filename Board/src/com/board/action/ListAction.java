package com.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		List<Board> articleList = BoardDao.getInstance().getArticleList();
		
		// 읽어온 데이터를 뷰에 포워드
		request.setAttribute("articleList", articleList);
		return "boardList.jsp";
		
	}

}
