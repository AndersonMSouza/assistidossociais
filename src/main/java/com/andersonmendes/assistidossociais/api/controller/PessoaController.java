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
import com.andersonmendes.assistidossociais.domain.model.Pessoa;
import com.andersonmendes.assistidossociais.domain.repository.PessoaRepository;
import com.andersonmendes.assistidossociais.domain.service.CadastroPessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CadastroPessoaService cadastroPessoaService;
	
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}	
	
	@GetMapping("/pessoa-por-nome")
	public List<Pessoa> porNome(String nomeCompleto) {
		return pessoaRepository.findByNomeCompletoContaining(nomeCompleto);
	}
	
	@GetMapping("/pessoa-por-cpf")
	public Optional<Pessoa> porCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
		
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Pessoa pessoa) {
		try {
			pessoa = cadastroPessoaService.salvar(pessoa);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{pessoaId}")
	public ResponseEntity<?> atualizar(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {
		try {
			Optional<Pessoa> pessoaAtual = pessoaRepository.findById(pessoaId);
		
			if (pessoaAtual.isPresent()) {
				BeanUtils.copyProperties(pessoa, pessoaAtual.get(), "id");
				Pessoa pessoaSalva = cadastroPessoaService.salvar(pessoaAtual.get());
				return ResponseEntity.ok(pessoaSalva);
			}
			
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<?> remover(@PathVariable Long pessoaId) {
		try {
			cadastroPessoaService.excluir(pessoaId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
