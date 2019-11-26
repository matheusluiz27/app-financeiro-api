package com.matheus.finaceiro.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.finaceiro.config.security.TokenService;
import com.matheus.finaceiro.entities.Movimentacao;
import com.matheus.finaceiro.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	MovimentacaoService movimentacaoService;

//	@Autowired
//	TokenService tokenService;

	@PostMapping
	public CompletableFuture<Movimentacao> cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
//		Long idUsuario = tokenService.getIdUsuario(token);
		return movimentacaoService.criarMovimentacaoFuture(1L, movimentacao);
	}
}
