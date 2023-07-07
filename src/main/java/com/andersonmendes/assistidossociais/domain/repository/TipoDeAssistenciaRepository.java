package com.andersonmendes.assistidossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonmendes.assistidossociais.domain.model.TipoDeAssistencia;

@Repository
public interface TipoDeAssistenciaRepository extends JpaRepository<TipoDeAssistencia, Long> {

}
