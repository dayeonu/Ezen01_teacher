package com.springbook.biz.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("log")
public class LogAdvice {
	public void printLog() {
		System.out.println("[���� �α�] ����Ͻ� ���� ������ ����");
	}
}
