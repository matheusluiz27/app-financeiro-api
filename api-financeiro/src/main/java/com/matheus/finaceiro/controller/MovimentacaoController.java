package com.matheus.finaceiro.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.finaceiro.config.security.TokenService;
import com.matheus.finaceiro.entities.Movimentacao;
import com.matheus.finaceiro.services.MovimentacaoService;

import jdk.jfr.BooleanFlag;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	MovimentacaoService movimentacaoService;

	@Autowired
	TokenService tokenService;

	@PostMapping
	public CompletableFuture<Movimentacao> cadastrarMovimentacao(@RequestHeader("Authorization") String authorization,@RequestBody Movimentacao movimentacao) {
		String token = authorization.split(" ")[1];
		Long idUsuario = tokenService.getIdUsuario(token);
		return movimentacaoService.criarMovimentacao(idUsuario, movimentacao);
	}
	
	@GetMapping
	public List<Movimentacao> listarMovimentacoes(@RequestHeader("Authorization") String authorization) {
		String token = authorization.split(" ")[1];
		Long idUsuario = tokenService.getIdUsuario(token);
		return movimentacaoService.listarPorUsuario(idUsuario);
	}
	
	@PutMapping("/mes")
	public List<Movimentacao> listarMovimentaçõesPorMes(@RequestHeader("Authorization") String authorization, @RequestBody Date data) {
		String token = authorization.split(" ")[1];
		Long idUsuario = tokenService.getIdUsuario(token);
		return movimentacaoService.listarPorUsuarioMes(idUsuario, data);
	}
}
