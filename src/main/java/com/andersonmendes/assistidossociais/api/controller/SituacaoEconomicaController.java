package com.andersonmendes.assistidossociais.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public SituacaoEconomica buscar(@PathVariable Long situacaoeconomicaId) {
		return cadastroSituacaEconomicaService.buscarOuFalhar(situacaoeconomicaId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SituacaoEconomica adicionar(@RequestBody SituacaoEconomica situacaoEconomica) {
		return cadastroSituacaEconomicaService.salvar(situacaoEconomica);
	}

	@PutMapping("/{situacaoEconomicaId}")
	public SituacaoEconomica atualizar(@PathVariable Long situacaoEconomicaId, @RequestBody SituacaoEconomica situacaoEconomica) {
		
		SituacaoEconomica situacaoEconomicaAtual = situacaoEconomicaRepository.findById(situacaoEconomicaId).orElse(null);
		
		BeanUtils.copyProperties(situacaoEconomica, situacaoEconomicaAtual, "id");
		
		return cadastroSituacaEconomicaService.salvar(situacaoEconomica);
	}
	
	@DeleteMapping("/{situacaoEconomicaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long situacaoEconomicaId) {
		cadastroSituacaEconomicaService.excluir(situacaoEconomicaId);
	}
}
