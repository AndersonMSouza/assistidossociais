package com.andersonmendes.assistidossociais.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonmendes.assistidossociais.domain.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByNomeCompletoContaining(String nomeCompleto);

	Optional<Pessoa> findByCpf(String cpf);
	
}
