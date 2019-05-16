package com.map.primeiroprojeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.primeiroprojeto.domain.Categoria;
import com.map.primeiroprojeto.repositories.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {		
		Optional<Categoria> cat =repo.findById(id);		
		return cat.orElse(null);
	
	}
	
	
	
	
	
	/*FIND -OPCAP 02 - COM Service / SEM Repository - */
	/*------------------------------------------------------------
	public Categoria buscar(List<Categoria> lst, Integer id) {		
		for(Categoria categoriaLista: lst) {
			if(categoriaLista.getId().equals(id)) {
				return categoriaLista;
			}
		}
		return null;	
	}
	------------------------------------------------------------*/
	
	
	
	
}
