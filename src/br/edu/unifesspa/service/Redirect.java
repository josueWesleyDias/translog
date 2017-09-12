package br.edu.unifesspa.service;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Redirect {
	public static void redirectTo(String caminho) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		try {
			ec.redirect(caminho);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
