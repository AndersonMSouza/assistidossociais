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
import com.andersonmendes.assistidossociais.domain.model.TipoDeAssitencia;
import com.andersonmendes.assistidossociais.domain.repository.TipoDeAssistenciaRepository;
import com.andersonmendes.assistidossociais.domain.service.CadastroTipoDeAssistenciaService;

@RestController
@RequestMapping("/tiposdeassistencias")
public class TipoDeAssitenciaController {

	@Autowired
	private TipoDeAssistenciaRepository tipoDeAssistenciaRepository;
	
	@Autowired
	private CadastroTipoDeAssistenciaService cadastroTipoDeAssistenciaService;
	
	@GetMapping
	public List<TipoDeAssitencia> listar() {
		return tipoDeAssistenciaRepository.findAll();
	}
	
	@GetMapping("/{tipodeassistenciaId}")
	public ResponseEntity<TipoDeAssitencia> buscar(@PathVariable Long tipodeassistenciaId) {
		Optional<TipoDeAssitencia> tipoDeAssitencia = tipoDeAssistenciaRepository.findById(tipodeassistenciaId);
		
		if (tipoDeAssitencia.isPresent()) {
			return ResponseEntity.ok(tipoDeAssitencia.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody TipoDeAssitencia tipoDeAssitencia) {
		try {
			tipoDeAssitencia = cadastroTipoDeAssistenciaService.salvar(tipoDeAssitencia);
			return ResponseEntity.status(HttpStatus.CREATED).body(tipoDeAssitencia);
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{tipoDeAssistenciaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long tipoDeAssistenciaId, @RequestBody TipoDeAssitencia tipoDeAssitencia) {
		try {
			Optional<TipoDeAssitencia> tipoDeAssistenciaAtual = tipoDeAssistenciaRepository.findById(tipoDeAssistenciaId);
		
			if (tipoDeAssistenciaAtual.isPresent()) {
				BeanUtils.copyProperties(tipoDeAssitencia, tipoDeAssistenciaAtual.get(), "id");
				TipoDeAssitencia tipoDeAssistenciaSalva = cadastroTipoDeAssistenciaService.salvar(tipoDeAssistenciaAtual.get());
				return ResponseEntity.ok(tipoDeAssistenciaSalva);
			}
			
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{tipoDeAssistenciaId}")
	public ResponseEntity<?> remover(@PathVariable Long tipoDeAssistenciaId) {
		try {
			cadastroTipoDeAssistenciaService.excluir(tipoDeAssistenciaId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
