package com.andersonmendes.assistidossociais.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.Dependente;
import com.andersonmendes.assistidossociais.domain.repository.DependenteRepository;
import com.andersonmendes.assistidossociais.domain.service.CadastroDependenteService;

@RestController
@RequestMapping("/dependentes")
public class DependentesController {

	@Autowired
	private DependenteRepository dependenteRepository;
	
	@Autowired
	private CadastroDependenteService cadastroDependenteService;
	
	@GetMapping
	public List<Dependente> listar() {
		return dependenteRepository.findAll();
	}
	
	@GetMapping("/{dependenteId}")
	public ResponseEntity<Dependente> buscar(@PathVariable Long dependenteId) {
		Optional<Dependente> dependente = dependenteRepository.findById(dependenteId);
		
		if (dependente.isPresent()) {
			return ResponseEntity.ok(dependente.get());
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Dependente dependente) {
		try {
			dependente = cadastroDependenteService.salvar(dependente);
			return ResponseEntity.status(HttpStatus.CREATED).body(dependente);
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{dependenteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long dependenteId, @RequestBody Dependente dependente) {
		try {
		Optional<Dependente> dependenteAtual = dependenteRepository.findById(dependenteId);
		
		if (dependenteAtual.isPresent()) {
			BeanUtils.copyProperties(dependente, dependenteAtual.get(), "id");
			Dependente dependenteSalvo = cadastroDependenteService.salvar(dependenteAtual.get());
			return ResponseEntity.ok(dependenteSalvo);
		}
		
		return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}			
	}
	
	@DeleteMapping("/{dependenteId}")
	public ResponseEntity<?> remover(@PathVariable Long dependenteId) {
		try {
			cadastroDependenteService.excluir(dependenteId);
			return ResponseEntity.noContent().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			ResponseEntity.notFound().build();
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
