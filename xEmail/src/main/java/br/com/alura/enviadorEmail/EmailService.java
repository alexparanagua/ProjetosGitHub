package br.com.alura.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviar(String nome, String emailDestino, String texto){
		try{
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("email@gmail.com", "senha"));
			email.setSSLOnConnect(true);
//			email.setStartTLSEnabled(true);
			
			email.setFrom("teste@testando.email");
			email.setSubject("[xEmail] Email APP");
			email.setMsg("Olá "+nome+"! "+texto);
			email.addTo(emailDestino);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
}
