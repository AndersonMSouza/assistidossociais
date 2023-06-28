package com.andersonmendes.assistidossociais.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public Dependente buscar(@PathVariable Long dependenteId) {
		return cadastroDependenteService.buscarOuFalhar(dependenteId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Dependente adicionar(@RequestBody Dependente dependente) {
		return cadastroDependenteService.salvar(dependente);
	}
	
	@PutMapping("{dependenteId}")
	public Dependente atualizar(@PathVariable Long dependenteId, @RequestBody Dependente dependente) {
		
		Dependente dependenteAtual = dependenteRepository.findById(dependenteId).orElse(null);
		
		BeanUtils.copyProperties(dependente, dependenteAtual, "id");
			
		return cadastroDependenteService.salvar(dependenteAtual);
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
