package com.matheus.finaceiro.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matheus.finaceiro.entities.Usuario;
import com.matheus.finaceiro.repositories.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}

		throw new UsernameNotFoundException("Dados inválidos!");
	}
}
