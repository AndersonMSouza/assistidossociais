package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.Dependente;
import com.andersonmendes.assistidossociais.domain.repository.DependenteRepository;

@Service
public class CadastroDependenteService {

	@Autowired
	private DependenteRepository dependenteRepository;
	
	public Dependente salvar(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}
	
	public void excluir(Long dependenteId) {
		try {
			dependenteRepository.deleteById(dependenteId);
		
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe dependente cadastrado com o código %d.", dependenteId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Dependente de código %d não pode ser removido pois está em uso!", dependenteId));
		}
	}
	
}
