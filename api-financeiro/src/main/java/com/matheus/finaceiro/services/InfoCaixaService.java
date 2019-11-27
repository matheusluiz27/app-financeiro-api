package com.matheus.finaceiro.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.finaceiro.DTO.InfoCaixaDTO;
import com.matheus.finaceiro.entities.Movimentacao;
import com.matheus.finaceiro.enuns.TipoMovimentacao;

@Service
public class InfoCaixaService {
	
	@Autowired
	MovimentacaoService movimentacaoService;
	
	public InfoCaixaDTO retornarInfoCaixaGeral(Long idUsuario) {
		List<Movimentacao> movimentacoes = movimentacaoService.listarPorUsuario(idUsuario);
		
		Double totalSaidas = movimentacoes.stream()
				.filter(x -> x.getTipo().equals(TipoMovimentacao.SAIDA))
				.mapToDouble(Movimentacao::getValor)
				.sum();
		
		Double totalEntradas = movimentacoes.stream()
				.filter(x -> x.getTipo().equals(TipoMovimentacao.ENTRADA))
				.mapToDouble(Movimentacao::getValor)
				.sum();
		
		Double total = totalEntradas - totalSaidas;
		
		return new InfoCaixaDTO(total, totalEntradas, totalSaidas);
	}
	
	public InfoCaixaDTO retornarInfoCaixaGeralPorMes(Long idUsuario, Date data) {
		
		List<Movimentacao> movimentacoes = movimentacaoService.listarPorUsuarioMes(idUsuario, data);
		
		Double totalSaidas = movimentacoes.stream()
				.filter(x -> x.getTipo().equals(TipoMovimentacao.SAIDA))
				.mapToDouble(Movimentacao::getValor)
				.sum();
		
		Double totalEntradas = movimentacoes.stream()
				.filter(x -> x.getTipo().equals(TipoMovimentacao.ENTRADA))
				.mapToDouble(Movimentacao::getValor)
				.sum();
		
		Double total = totalEntradas - totalSaidas;
		
		return new InfoCaixaDTO(total, totalEntradas, totalSaidas);
	}
}
