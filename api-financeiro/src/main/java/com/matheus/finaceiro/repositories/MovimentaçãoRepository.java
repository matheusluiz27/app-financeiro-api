package com.matheus.finaceiro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.finaceiro.entities.Movimentacao;
import com.matheus.finaceiro.entities.Usuario;

@Repository
public interface MovimentaçãoRepository extends JpaRepository<Movimentacao, Long>{
	
	List<Movimentacao> findByUsuario(Usuario usuario);
}
