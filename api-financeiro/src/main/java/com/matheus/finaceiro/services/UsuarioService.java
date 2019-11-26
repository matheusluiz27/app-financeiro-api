package com.matheus.finaceiro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.finaceiro.entities.Usuario;
import com.matheus.finaceiro.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario) {
		try {
			Usuario usuarioCriado = usuarioRepository.save(usuario);
			return usuarioCriado;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
