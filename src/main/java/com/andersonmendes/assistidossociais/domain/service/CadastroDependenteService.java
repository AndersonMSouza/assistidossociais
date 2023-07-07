package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.andersonmendes.assistidossociais.domain.exceptions.DependenteNaoEncontradoException;
import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.model.Dependente;
import com.andersonmendes.assistidossociais.domain.repository.DependenteRepository;

@Service
public class CadastroDependenteService {

	private static final String MSG_DEPENDENTE_EM_USO 
		= "Dependente de código %d não pode ser removido pois está em uso!";
	
	@Autowired
	private DependenteRepository dependenteRepository;
	
	public Dependente salvar(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}
	
	public void excluir(Long dependenteId) {
		try {
			dependenteRepository.deleteById(dependenteId);
		
		} catch (EmptyResultDataAccessException e) {
			throw new DependenteNaoEncontradoException(dependenteId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_DEPENDENTE_EM_USO, dependenteId));
		}
	}
	
	public Dependente buscarOuFalhar(@PathVariable Long dependenteId) {
		return dependenteRepository.findById(dependenteId)
			.orElseThrow(() -> new DependenteNaoEncontradoException(dependenteId));
	}
	
}
