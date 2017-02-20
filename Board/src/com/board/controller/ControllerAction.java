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
	
	private Map commandMap = new HashMap<>(); // ��ɾ�� ��ɾ� ó�� Ŭ������ HashMap���� ����
	
	public void init(ServletConfig config) throws ServletException {
		loadProperties("com/board/properties/Command");
	}
	
	// com.board.properties.Command.properties ���Ͽ��� ������ ���������� ��Ű�� ������ �������� Ŭ����ȭ
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while(actionEnumHome.hasMoreElements()) {
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			
			try {
				// �ش� ���ڿ��� Ŭ������
				Class<?> commandClass = Class.forName(className);
				// �ش� Ŭ������ ��ü�� ����
				Object commandInstance = commandClass.newInstance();
				
				// Map ��ü�� commandMap�� ��ü ����
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

	// post, get ��û�� requestPro() ȣ��
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	// ������� ��û�� �м��ؼ� �ش� �۾��� ó��
	// url�� �м��Ͽ� ���ҽ� ���鿡 ����� �ش� �׼� ��ü�� ������ ����
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
