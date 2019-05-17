package com.map.primeiroprojeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.map.primeiroprojeto.domain.Categoria;
import com.map.primeiroprojeto.domain.Produto;
import com.map.primeiroprojeto.repositories.CategoriaRepository;
import com.map.primeiroprojeto.repositories.ProdutoRepository;



@SpringBootApplication
public class PrimeiroProjetoApplication implements CommandLineRunner {

	
	@Autowired
	CategoriaRepository repoCat;
	
	@Autowired
	ProdutoRepository repoProd;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1= new Categoria(null,"Informatica");
		Categoria cat2= new Categoria(null,"Escritorio"); 
		
		Produto p1= new Produto(null,"Computador",2000.00);
		Produto p2= new Produto(null,"Impressora",800.00);
		Produto p3= new Produto(null, "Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		
		repoCat.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(p1,p2,p3));
		

		
	}

}
