package com.matheus.finaceiro.config.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.matheus.finaceiro.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private Long EXPIRATION_TIME = 86400000l;
	private String secret = "senha";

	public String gerarToken(Authentication authentication) {	
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		
		return Jwts.builder()
				.setIssuer("Api posto")//diz qual api está gerando esse token
				.setSubject(usuarioLogado.getId().toString())//informa qual usuário está sendo autenticado
				.setIssuedAt(hoje)//qual data de geração desse token
				.setExpiration(new Date(hoje.getTime() + EXPIRATION_TIME))//data de expiração do token
				.signWith(SignatureAlgorithm.HS256, secret)//especificar o algoritico pra emcriptografar e a chave da encriptografia
				.compact();
	}
	
	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
}
