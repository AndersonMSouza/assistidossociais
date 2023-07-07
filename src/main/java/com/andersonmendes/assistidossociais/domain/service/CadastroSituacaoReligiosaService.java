package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.SituacaoReligiosaNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.SituacaoReligiosa;
import com.andersonmendes.assistidossociais.domain.repository.SituacaoReligiosaRepository;

@Service
public class CadastroSituacaoReligiosaService {

	@Autowired
	private SituacaoReligiosaRepository situacaoReligiosaRepository;

	public SituacaoReligiosa salvar(SituacaoReligiosa situacaoReligiosa) {
		return situacaoReligiosaRepository.save(situacaoReligiosa);
	}

	public void excluir(Long situacaoReligiosaId) {
		try {
			situacaoReligiosaRepository.deleteById(situacaoReligiosaId);;
			
		} catch (EmptyResultDataAccessException e) {
			throw new SituacaoReligiosaNaoEncontradaException(situacaoReligiosaId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Pessoa de código %d não pode ser removida pois está em uso!", situacaoReligiosaId));
		}
	}
	
	public SituacaoReligiosa buscarOuFalhar(@PathVariable Long situacaoReligiosaId) {
		return situacaoReligiosaRepository.findById(situacaoReligiosaId)
			.orElseThrow(() -> new SituacaoReligiosaNaoEncontradaException(situacaoReligiosaId));
	}
	
}
