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

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.Parecer;
import com.andersonmendes.assistidossociais.domain.repository.ParecerRepository;
import com.andersonmendes.assistidossociais.domain.service.CadastroParecerService;

@RestController
@RequestMapping("/pareceres")
public class ParecerController {

	@Autowired
	private ParecerRepository parecerRepository;
	
	@Autowired
	private CadastroParecerService cadastroParecerService;
	
	@GetMapping
	public List<Parecer> listar() {
		return parecerRepository.findAll();
	}
	
	@GetMapping("/{parecerId}")
	public ResponseEntity<Parecer> buscar(@PathVariable Long parecerId) {
		Optional<Parecer> parecer = parecerRepository.findById(parecerId);
		
		if (parecer.isPresent()) {
			return ResponseEntity.ok(parecer.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Parecer adicionar(@RequestBody Parecer parecer) {
		return cadastroParecerService.salvar(parecer);
	}

	@PutMapping("/{parecerId}")
	public Parecer atualizar(@PathVariable Long parecerId, @RequestBody Parecer parecer) {
		
		Parecer parecerAtual = parecerRepository.findById(parecerId).orElse(null);
		
		BeanUtils.copyProperties(parecer, parecerAtual, "id");
		
		return cadastroParecerService.salvar(parecerAtual);
	}
	
	@DeleteMapping("/{parecerId}")
	public ResponseEntity<?> remover(@PathVariable Long parecerId) {
		try {
			cadastroParecerService.excluir(parecerId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
