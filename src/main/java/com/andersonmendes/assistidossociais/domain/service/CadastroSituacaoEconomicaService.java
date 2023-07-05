package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.exceptions.SituacaoEconomicaNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.SituacaoEconomica;
import com.andersonmendes.assistidossociais.domain.repository.SituacaoEconomicaRepository;

@Service
public class CadastroSituacaoEconomicaService {

	@Autowired
	private SituacaoEconomicaRepository situacaoEconomicaRepository;
	
	public SituacaoEconomica salvar(SituacaoEconomica situacaoEconomica) {
		return situacaoEconomicaRepository.save(situacaoEconomica);
	}
		
	public void excluir(Long situacaoEconomicaId) {
		try {
			situacaoEconomicaRepository.deleteById(situacaoEconomicaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe situacaoEconomica cadastrada com o codigo %d.", situacaoEconomicaId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("SituacaoEconomica de código %d não pode ser removida pois está em uso!", situacaoEconomicaId));
		}
	}
	
	public SituacaoEconomica buscarOuFalhar(@PathVariable Long situacaoEconomicaId) {
		return situacaoEconomicaRepository.findById(situacaoEconomicaId)
			.orElseThrow(() -> new SituacaoEconomicaNaoEncontradaException(situacaoEconomicaId));
	}
}
