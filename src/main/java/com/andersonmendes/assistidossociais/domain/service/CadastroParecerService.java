package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.ParecerNaoEncontradoException;
import com.andersonmendes.assistidossociais.domain.model.Parecer;
import com.andersonmendes.assistidossociais.domain.repository.ParecerRepository;

@Service
public class CadastroParecerService {

	@Autowired
	private ParecerRepository parecerRepository;
		
	public Parecer salvar(Parecer parecer) {
		return parecerRepository.save(parecer);
	}
	
	public void excluir(Long parecerId) {
		try {
			parecerRepository.deleteById(parecerId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ParecerNaoEncontradoException(
				String.format("Não existe parecer cadastrado com o codigo %d.", parecerId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Pessoa de código %d não pode ser removida pois está em uso!", parecerId));
		}
	}
	
	public Parecer buscarOuFalhar(@PathVariable Long parecerId) {
		return parecerRepository.findById(parecerId)
			.orElseThrow(() -> new ParecerNaoEncontradoException(parecerId));
	}
		
}
