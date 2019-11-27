package com.matheus.finaceiro.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.finaceiro.entities.Movimentacao;
	
@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
	
	@Query("SELECT m FROM Movimentacao m WHERE usuario_id=:idUsuario")
	List<Movimentacao> findByIdUsuario(Long idUsuario);
	
	@Query("SELECT m FROM Movimentacao m WHERE usuario_id=:idUsuario AND data >=:dataInicial AND data <=:dataFinal")
	List<Movimentacao> findByIdUsuarioMes(Long idUsuario, Date dataInicial, Date dataFinal);
}
