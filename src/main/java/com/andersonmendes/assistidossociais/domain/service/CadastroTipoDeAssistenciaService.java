package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.TipoDeAssistenciaNaoEncontradaException;
import com.andersonmendes.assistidossociais.domain.model.TipoDeAssistencia;
import com.andersonmendes.assistidossociais.domain.repository.TipoDeAssistenciaRepository;

@Service
public class CadastroTipoDeAssistenciaService {
	
	@Autowired
	private TipoDeAssistenciaRepository tipoDeAssistenciaRepository;
	
	public TipoDeAssistencia salvar(TipoDeAssistencia tipoDeAssitencia) {
		return tipoDeAssistenciaRepository.save(tipoDeAssitencia);
	}
	
	public void excluir(Long tipoDeAssitenciaId) {
		try {
			tipoDeAssistenciaRepository.deleteById(tipoDeAssitenciaId);
		
		} catch (EmptyResultDataAccessException e) {
			throw new TipoDeAssistenciaNaoEncontradaException(tipoDeAssitenciaId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Pessoa de código %d não pode ser removida pois está em uso!", tipoDeAssitenciaId));
		}
	}
	
	public TipoDeAssistencia buscarOuFalhar(@PathVariable Long tipoDeAssistenciaId) {
		return tipoDeAssistenciaRepository.findById(tipoDeAssistenciaId)
			.orElseThrow(() -> new TipoDeAssistenciaNaoEncontradaException(tipoDeAssistenciaId));
	}
}
