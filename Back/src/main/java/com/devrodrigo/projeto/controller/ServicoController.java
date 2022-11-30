package com.devrodrigo.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrodrigo.projeto.entities.Servico;
import com.devrodrigo.projeto.services.ServicoService;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/")
	@CrossOrigin("http://localhost:3000")
	public List<Servico> buscarTodos(){
		return servicoService.buscarTodos();
	}
	
	@GetMapping("/pagamentosPendente")
	@CrossOrigin("http://localhost:3000")
	public List<String> buscarServicosPagamentosPendentes(){
		return servicoService.buscarServicosPagamentosPendentes();
	}
	
	@GetMapping("/cancelados")
	@CrossOrigin("http://localhost:3000")
	public List<String> buscarServicosCancelados(){
		return servicoService.buscarServicosCancelados();
	}
	
	@PostMapping("/inserir")
	@CrossOrigin("http://localhost:3000")
	public Servico inserir(@RequestBody Servico servico) {
		return servicoService.inserir(servico);
	}
	
	@PostMapping("/alterar")
	@CrossOrigin("http://localhost:3000")
	public Servico alterar(@RequestBody Servico servico) {
		return servicoService.alterar(servico);
	}
	
	@DeleteMapping("/apagar/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		servicoService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
