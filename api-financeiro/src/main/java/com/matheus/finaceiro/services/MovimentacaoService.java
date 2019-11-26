package com.matheus.finaceiro.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.finaceiro.entities.Movimentacao;
import com.matheus.finaceiro.entities.Usuario;
import com.matheus.finaceiro.repositories.MovimentaçãoRepository;
import com.matheus.finaceiro.repositories.UsuarioRepository;

@Service
public class MovimentacaoService {

	@Autowired
	MovimentaçãoRepository movimentaçãoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Movimentacao> listarPorUsuario(Usuario usuario) {
		List<Movimentacao> movimentacoes = null;
		try {
			movimentacoes = movimentaçãoRepository.findByUsuario(usuario);
		} catch (Exception e) {
			System.out.println(e);
		}
		return movimentacoes;
	}
	
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Movimentacao criarMovimentacao(Long idUsuario, Movimentacao movimentacao) {
			Usuario usuario = usuarioRepository.findById(idUsuario).get();
			movimentacao.setUsuario(usuario);
			return movimentaçãoRepository.save(movimentacao);
	}
	
	public CompletableFuture<Movimentacao> criarMovimentacaoFuture(Long idUsuario, Movimentacao movimentacao) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		movimentacao.setUsuario(usuario);
		return CompletableFuture.completedFuture(movimentaçãoRepository.save(movimentacao));
}
}
