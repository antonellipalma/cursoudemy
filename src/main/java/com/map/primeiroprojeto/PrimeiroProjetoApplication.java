package com.map.primeiroprojeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.map.primeiroprojeto.domain.Categoria;
import com.map.primeiroprojeto.domain.Cidade;
import com.map.primeiroprojeto.domain.Cliente;
import com.map.primeiroprojeto.domain.Endereco;
import com.map.primeiroprojeto.domain.Estado;
import com.map.primeiroprojeto.domain.Produto;
import com.map.primeiroprojeto.domain.enums.TipoCliente;
import com.map.primeiroprojeto.repositories.CategoriaRepository;
import com.map.primeiroprojeto.repositories.CidadeRepository;
import com.map.primeiroprojeto.repositories.ClienteRepository;
import com.map.primeiroprojeto.repositories.EnderecoRepository;
import com.map.primeiroprojeto.repositories.EstadoRepository;
import com.map.primeiroprojeto.repositories.ProdutoRepository;



@SpringBootApplication
public class PrimeiroProjetoApplication implements CommandLineRunner {

	
	@Autowired
	CategoriaRepository repoCat;
	
	@Autowired
	ProdutoRepository repoProd;
	
	@Autowired
	CidadeRepository repoCid;
	
	@Autowired
	EstadoRepository repoEst;
	
	@Autowired
	ClienteRepository repoCli;
	
	@Autowired
	EnderecoRepository repoEnd;
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//CATEGORIA e PRODUTO ------------------------------
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
		
		//ESTADO e CIDADE ------------------------------
		Estado est1= new Estado(null,"Minas Gerais");
		Estado est2= new Estado(null,"Sao Paulo");
		
		Cidade c1= new Cidade(null,"Uberlandia",est1);
		Cidade c2= new Cidade(null,"Sao Paulo",est2);
		Cidade c3= new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
	
		Cliente cli1= new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","9383893"));
		
		Endereco e1= new Endereco(null,"Rua Flores","300","Apto 203","Jardim","38220834",c1,cli1);
		Endereco e2= new Endereco(null,"Avenida Matos","105","Sala800","Centro","38777012",c2,cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		repoCat.saveAll(Arrays.asList(cat1,cat2));
		repoProd.saveAll(Arrays.asList(p1,p2,p3));
		repoEst.saveAll(Arrays.asList(est1,est2));
		repoCid.saveAll(Arrays.asList(c1,c2,c3));
		
		repoCli.saveAll(Arrays.asList(cli1));
		repoEnd.saveAll(Arrays.asList(e1,e2));
		
	}

}
