package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.TipoDeAssitencia;
import com.andersonmendes.assistidossociais.domain.repository.TipoDeAssistenciaRepository;

@Service
public class CadastroTipoDeAssistenciaService {
	
	@Autowired
	private TipoDeAssistenciaRepository tipoDeAssistenciaRepository;
	
	public TipoDeAssitencia salvar(TipoDeAssitencia tipoDeAssitencia) {
		return tipoDeAssistenciaRepository.save(tipoDeAssitencia);
	}
	
	public void excluir(Long tipoDeAssitenciaId) {
		try {
			tipoDeAssistenciaRepository.deleteById(tipoDeAssitenciaId);
		
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe pessoa cadastrada com o codigo %d.", tipoDeAssitenciaId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Pessoa de código %d não pode ser removida pois está em uso!", tipoDeAssitenciaId));
		}
	}
}
