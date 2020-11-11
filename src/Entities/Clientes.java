package Entities;

import BancoDeDadosTxt.Armazenavel;

public class Clientes implements Armazenavel {

//----------ATRIBUTOS--------------
	private String name;
	private String email;
	private String cpf;
	private Integer rg;
	
	
//----------CONTRUTORES---------------	
	
	public Clientes(){
		
	}
	
	public Clientes(String name, String email, String cpf, Integer rg) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		
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
	

	@Override
	public String toString() {
		return"Nome do Cliente: " + name 
				+ ", Email: " + email 
				+ ", CPF: " + cpf 
				+ ", RG: " + rg;
	}

	@Override
	public String obterNomeArquivo() {
		return "cliente.txt";
	}
		
	
}
	
	
	

