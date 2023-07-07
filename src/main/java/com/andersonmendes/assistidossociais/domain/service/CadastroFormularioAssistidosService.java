package com.andersonmendes.assistidossociais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.andersonmendes.assistidossociais.domain.exceptions.EntidadeEmUsoException;
import com.andersonmendes.assistidossociais.domain.exceptions.FormularioNaoEncontradoException;
import com.andersonmendes.assistidossociais.domain.model.FormularioAssistidos;
import com.andersonmendes.assistidossociais.domain.repository.FormularioAssisitidosRepository;

@Service
public class CadastroFormularioAssistidosService {

	private static final String MSG_FORMULARIO_EM_USO 
		= "Formulário de código %d não pode ser removido pois está em uso!";
	
	@Autowired
	private FormularioAssisitidosRepository formularioAssisitidosRepository;
	
	public FormularioAssistidos salvar(FormularioAssistidos formularioAssistidos) {
		return formularioAssisitidosRepository.save(formularioAssistidos);
	}
	
	public void excluir(Long formularioAssistidosId) {
		try {
			formularioAssisitidosRepository.deleteById(formularioAssistidosId);
		
		} catch (EmptyResultDataAccessException e) {
			throw new FormularioNaoEncontradoException(formularioAssistidosId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_FORMULARIO_EM_USO, formularioAssistidosId));
		}
	}
	
	public FormularioAssistidos buscarOuFalhar(@PathVariable Long formularioAssitidosId) {
		return formularioAssisitidosRepository.findById(formularioAssitidosId)
			.orElseThrow(() -> new FormularioNaoEncontradoException(formularioAssitidosId));
	}
	
}
