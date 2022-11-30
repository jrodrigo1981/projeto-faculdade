package com.devrodrigo.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devrodrigo.projeto.entities.Servico;

public interface ServicoRepository  extends JpaRepository<Servico, Long>{

	@Query(" select nomeCliente from Servico where status  = 'agendado' ")	
	List<String> buscarServicosPagamentoPendente();
	
	@Query(" select nomeCliente from Servico where status  = 'cancelado' ")	
	List<String> buscarServicosCancelados();
	

}
