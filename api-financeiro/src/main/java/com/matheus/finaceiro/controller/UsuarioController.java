package com.matheus.finaceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.finaceiro.entities.Usuario;
import com.matheus.finaceiro.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		Usuario usuarioCriado = usuarioService.cadastrar(usuario);
		if (usuarioCriado != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
