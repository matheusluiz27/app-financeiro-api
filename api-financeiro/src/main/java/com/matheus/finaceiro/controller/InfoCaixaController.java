package com.matheus.finaceiro.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.finaceiro.DTO.InfoCaixaDTO;
import com.matheus.finaceiro.config.security.TokenService;
import com.matheus.finaceiro.services.InfoCaixaService;

@RestController
@RequestMapping("caixa")
public class InfoCaixaController {

	@Autowired
	TokenService tokenService;
	
	@Autowired
	InfoCaixaService infoCaixaServise;

	@GetMapping
	public InfoCaixaDTO retornarInfoCaixa(@RequestHeader("Authorization") String authorization) {
		String token = authorization.split(" ")[1];
		Long idUsuario = tokenService.getIdUsuario(token);
		return infoCaixaServise.retornarInfoCaixaGeral(idUsuario);
	}

	@PutMapping("/mes")
	public InfoCaixaDTO retornarInfoCaixaPorMes(@RequestHeader("Authorization") String authorization, @RequestBody Date data) {
		String token = authorization.split(" ")[1];
		Long idUsuario = tokenService.getIdUsuario(token);
		return infoCaixaServise.retornarInfoCaixaGeralPorMes(idUsuario, data);
	}
}
