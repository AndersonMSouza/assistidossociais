package com.andersonmendes.assistidossociais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonmendes.assistidossociais.domain.model.Parecer;

@Repository
public interface ParecerRepository extends JpaRepository<Parecer, Long>{

}
