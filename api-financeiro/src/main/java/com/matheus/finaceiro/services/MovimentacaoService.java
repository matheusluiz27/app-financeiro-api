package com.matheus.finaceiro.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.finaceiro.entities.Movimentacao;
import com.matheus.finaceiro.entities.Usuario;
import com.matheus.finaceiro.repositories.MovimentacaoRepository;
import com.matheus.finaceiro.repositories.UsuarioRepository;

@Service
public class MovimentacaoService {

	@Autowired
	MovimentacaoRepository movimentaçãoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Movimentacao> listarPorUsuario(Long idUsuario) {
		return movimentaçãoRepository.findByIdUsuario(idUsuario);
	}
	
	@SuppressWarnings("deprecation")
	public List<Movimentacao> listarPorUsuarioMes(Long idUsuario, Date data) {
		Calendar cal = new GregorianCalendar(data.getYear(), data.getMonth(), data.getDay());
		Date d2 =  new GregorianCalendar(data.getYear(), data.getMonth(), cal.getActualMaximum(Calendar.DAY_OF_MONTH)).getTime();
		Date d1 =  new GregorianCalendar(data.getYear(), data.getMonth(), cal.getActualMinimum(Calendar.DAY_OF_MONTH)).getTime();
		List<Movimentacao> movimentacoes = movimentaçãoRepository.findByIdUsuario(idUsuario);
		movimentacoes.removeIf( x -> x.getData().getMonth()!= data.getMonth() && x.getData().getYear() != data.getYear());
		return movimentacoes;
	}

	public CompletableFuture<Movimentacao> criarMovimentacao(Long idUsuario, Movimentacao movimentacao) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		movimentacao.setUsuario(usuario);
		return CompletableFuture.completedFuture(movimentaçãoRepository.save(movimentacao));
	}
	
}
