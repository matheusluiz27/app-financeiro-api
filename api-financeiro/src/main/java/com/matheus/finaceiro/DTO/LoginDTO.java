package com.matheus.finaceiro.DTO;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDTO {
	public String email;
	public String senha;
	
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	
	public UsernamePasswordAuthenticationToken converter() {		
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
}
