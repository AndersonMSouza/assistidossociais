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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.SituacaoEconomica;
import com.andersonmendes.assistidossociais.domain.repository.SituacaoEconomicaRepository;
import com.andersonmendes.assistidossociais.domain.service.CadastroSituacaoEconomicaService;

@RestController
@RequestMapping("/situacaoeconomica")
public class SituacaoEconomicaController {

	@Autowired
	private SituacaoEconomicaRepository situacaoEconomicaRepository;
	
	@Autowired
	private CadastroSituacaoEconomicaService cadastroSituacaEconomicaService;
	
	@GetMapping
	public List<SituacaoEconomica> listar() {
		return situacaoEconomicaRepository.findAll();
	}
	
	@GetMapping("/{situacaoeconomicaId}")
	public ResponseEntity<SituacaoEconomica> buscar(@PathVariable Long situacaoeconomicaId) {
		Optional<SituacaoEconomica> situacaoeconomica = situacaoEconomicaRepository.findById(situacaoeconomicaId);
		
		if (situacaoeconomica.isPresent()) {
			return ResponseEntity.ok(situacaoeconomica.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody SituacaoEconomica situacaoEconomica) {
		try {
			situacaoEconomica = cadastroSituacaEconomicaService.salvar(situacaoEconomica);
			return ResponseEntity.status(HttpStatus.CREATED).body(situacaoEconomica);
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{situacaoEconomicaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long situacaoEconomicaId, @RequestBody SituacaoEconomica situacaoEconomica) {
		try {
			Optional<SituacaoEconomica> situacaoEconomicaAtual = situacaoEconomicaRepository.findById(situacaoEconomicaId);
		
			if (situacaoEconomicaAtual.isPresent()) {
				BeanUtils.copyProperties(situacaoEconomica, situacaoEconomicaAtual.get(), "id");
				SituacaoEconomica situacaoEconomicaSalva = cadastroSituacaEconomicaService.salvar(situacaoEconomicaAtual.get());
				return ResponseEntity.ok(situacaoEconomicaSalva);
			}
			
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{situacaoEconomicaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long situacaoEconomicaId) {
		cadastroSituacaEconomicaService.excluir(situacaoEconomicaId);
	}
}
