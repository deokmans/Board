package com.board.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerAction extends HttpServlet {
	
	private Map commandMap = new HashMap<>(); // 명령어와 명령어 처리 클래스를 HashMap으로 저장
	
	public void init(ServletConfig config) throws ServletException {
		loadProperties("com/board/properties/Command");
	}
	
	// com.board.properties.Command.properties 파일에서 가져온 맵핑정보의 패키지 정보를 바탕으로 클래스화
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while(actionEnumHome.hasMoreElements()) {
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			
			try {
				// 해당 문자열을 클래스로
				Class<?> commandClass = Class.forName(className);
				// 해당 클래스의 객체를 생성
				Object commandInstance = commandClass.newInstance();
				
				// Map 객체인 commandMap에 객체 저장
				commandMap.put(command, commandInstance);
				
			} catch(ClassNotFoundException e) {
				continue; // error
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	// post, get 요청시 requestPro() 호출
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	// 사용자의 요청을 분석해서 해당 작업을 처리
	// url을 분석하여 리소스 번들에 저장된 해당 액션 객체를 싱행후 리턴
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			
			com = (CommandAction) commandMap.get(command);
			
			if(com == null) {
				System.out.println("not found : " + command);
				
				return;
			}
			
			view = com.requestPro(request, response);
			
			if(view == null) {
				return;
			}
			
		} catch(Throwable e) {
			throw new ServletException(e);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
