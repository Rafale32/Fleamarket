package com.fleamarket.bean;

public class ActionForward {
	
	private boolean isRedirect;//리다이렉트 할건지 아닌지
	private String path; //실제 가기위한 경로
	private String conPath; //containerPath template.jsp 안의 container = 뷰단 jsp 파일 경로 
	
	public ActionForward() {	}
	
	public String getConPath() {
		return conPath;
	}
	public void setConPath(String conPath) {
		this.conPath = conPath;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
