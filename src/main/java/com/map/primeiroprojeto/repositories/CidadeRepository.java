package com.map.primeiroprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.map.primeiroprojeto.domain.Cidade;

@Repository
public  interface CidadeRepository extends JpaRepository <Cidade,Integer> {

}
