package com.teste.conversorgraus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.conversorgraus.entities.Historic;

public interface HistoricRepository extends JpaRepository<Historic, Long> {

}
