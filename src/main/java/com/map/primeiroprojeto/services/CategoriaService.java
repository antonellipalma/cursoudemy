package com.map.primeiroprojeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.primeiroprojeto.domain.Categoria;
import com.map.primeiroprojeto.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {		
		Optional<Categoria> cat =repo.findById(id);		
		//Opcao de retorno 01 - retorno simples sem tratamento de excecao
		//return cat.orElse(null);
		
		//Opcao de retorno 02 - com excecao Padrao - usando classe RuntimeException
		return cat.orElseThrow(() -> new RuntimeException("OPT:02: Deu pau - Objeto nao Encontrado! Id: "+id+" - Tipo: "+ Categoria.class.getName()) );
	
		
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
