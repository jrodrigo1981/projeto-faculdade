package com.devrodrigo.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrodrigo.projeto.entities.Servico;
import com.devrodrigo.projeto.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	
	public List<Servico> buscarTodos(){
		return servicoRepository.findAll();
	}
	
	public List<String> buscarServicosPagamentosPendentes(){
		return servicoRepository.buscarServicosPagamentoPendente();
	}
	
	public List<String> buscarServicosCancelados(){
		return servicoRepository.buscarServicosCancelados();
	}
	
	public Servico inserir(Servico servico){
		if(servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagamento() == null) {
			servico.setStatus("agendado");
		}else {
			servico.setStatus("realizado");
		}
		return servicoRepository.saveAndFlush(servico);
	}
	
	public Servico alterar(Servico servico){
		if(servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDataPagamento() != null) {
			servico.setStatus("agendado");
		}
		return servicoRepository.save(servico);
	}
	
	public void excluir(Long id){
		Servico servico = servicoRepository.findById(id).get();
		servicoRepository.delete(servico);
	}

}
