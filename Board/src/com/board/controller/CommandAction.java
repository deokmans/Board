package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ��û �Ķ���ͷ� ��ɾ �����ϴ� ����� ���� �������̽�
// ��ɾ�� ã�� Ŭ������ Ŭ����ȭ ��Ű�� ���� ��

public interface CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;

}
