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
import com.andersonmendes.assistidossociais.domain.model.SituacaoReligiosa;
import com.andersonmendes.assistidossociais.domain.repository.SituacaoReligiosaRepository;
import com.andersonmendes.assistidossociais.domain.service.CadastroSituacaoReligiosaService;

@RestController
@RequestMapping("/situacaoreligiosa")
public class SituacaoReligiosaController {

	@Autowired
	private SituacaoReligiosaRepository situacaoReligiosaRepository;
	
	@Autowired
	private CadastroSituacaoReligiosaService cadastroSituacaoReligiosaService;
	
	@GetMapping
	public List<SituacaoReligiosa> listar() {
		return situacaoReligiosaRepository.findAll();		
	}
	
	@GetMapping("/{situacaoreligiosaId}")
	public ResponseEntity<SituacaoReligiosa> buscar(@PathVariable Long situacaoreligiosaId) {
		Optional<SituacaoReligiosa> situacaoReligiosa = situacaoReligiosaRepository.findById(situacaoreligiosaId);
		
		if (situacaoReligiosa.isPresent()) {
			return ResponseEntity.ok(situacaoReligiosa.get());
		}
		
		return ResponseEntity.notFound().build();
	}
		
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody SituacaoReligiosa situacaoReligiosa) {
		try {
			situacaoReligiosa = cadastroSituacaoReligiosaService.salvar(situacaoReligiosa);
			return ResponseEntity.status(HttpStatus.CREATED).body(situacaoReligiosa);
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{situacaoreligiosaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long situacaoreligiosaId, @RequestBody SituacaoReligiosa situacaoreligiosa) {
		try {
			Optional<SituacaoReligiosa> situacaoReligiosaAtual = situacaoReligiosaRepository.findById(situacaoreligiosaId);
		
			if (situacaoReligiosaAtual.isPresent()) {
				BeanUtils.copyProperties(situacaoreligiosa, situacaoReligiosaAtual.get(), "id");
				SituacaoReligiosa situacaoReligiosaSalva = cadastroSituacaoReligiosaService.salvar(situacaoReligiosaAtual.get());
				return ResponseEntity.ok(situacaoReligiosaSalva);
			}
			
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{situacaoreligiosaId}")
	public ResponseEntity<?> remover(@PathVariable Long situacaoreligiosaId) {
		try {
			cadastroSituacaoReligiosaService.excluir(situacaoreligiosaId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
}
