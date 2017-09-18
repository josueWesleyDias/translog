package br.edu.unifesspa.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
	
	public void enviar() {
		System.out.println("Email enviado com sucesso");
			SimpleEmail email = new SimpleEmail();
		   
			//Utilize o hostname do seu provedor de email
		   email.setHostName("smtp.gmail.com");
		   //Quando a porta utilizada n�o � a padr�o (gmail = 465)
		   email.setSmtpPort(465);
		   //Adicione os destinat�rios
		   try {
			email.addTo("xxx@xxx.com", "Jose");
		} catch (EmailException e) {
			e.printStackTrace();
		}
		   //Configure o seu email do qual enviar�
		   try {
			email.setFrom("seuemail@seuprovedor.com", "Seu nome");
		} catch (EmailException e) {
			e.printStackTrace();
		}
		   //Adicione um assunto
		   email.setSubject("Test message");
		   //Adicione a mensagem do email
		   try {
			email.setMsg("This is a simple test of commons-email");
		} catch (EmailException e) {
			e.printStackTrace();
		}
		   //Para autenticar no servidor � necess�rio chamar os dois m�todos abaixo
		   System.out.println("autenticando...");
		   email.setSSL(true);
		   email.setAuthentication("username", "senha");
		   System.out.println("enviando...");
		   try {
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
		   System.out.println("Email enviado!");
	}
}
