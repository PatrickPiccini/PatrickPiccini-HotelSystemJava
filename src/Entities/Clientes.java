package Entities;

import BancoDeDados.Armazenavel;

public class Clientes implements Armazenavel {

//----------ATRIBUTOS--------------
	private String name;
	private String email;
	private String cpf;
	private Integer rg;
	private Integer id;
	
	
//----------CONTRUTORES---------------	
	
	public Clientes(){
		
	}
	
	public Clientes(String name, String email, String cpf, Integer rg, Integer id) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.id = id;
	}

//--------GETERS E SETTERS-----------
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id do Cliente: " + id
				+" Nome do Cliente: " + name 
				+ ", Email: " + email 
				+ ", CPF: " + cpf 
				+ ", RG: " + rg;
	}
	
	@Override
	public String obterNomeArquivo() {
		return "cliente.txt";
	}
	
	public Integer idGeneration() {
		return this.id += 1;
	}
	
	
	
}
	
	
	

