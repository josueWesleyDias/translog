package br.edu.unifesspa.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Session {
	
	private static final FacesContext fc = FacesContext.getCurrentInstance();;
	private static final HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
	
	public static Object getSession(String nomeSession) {
		return session.getAttribute(nomeSession);
	}
	
	public static void addSession(String nomeSession, Object objecto) {
		session.setAttribute(nomeSession, objecto);
	}
	
	public static void setSession(String nomeSession, Object objecto) {
		session.setAttribute(nomeSession, objecto);
	}
	
}
