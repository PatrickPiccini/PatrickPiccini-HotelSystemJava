package Entities;

import BancoDeDados.Armazenavel;

public class Cadastro extends HotelSystem implements Armazenavel{
	
//-----------ATRIBUTOS----------------

	private Integer id = 0;
	
//-----------CONTRUTORES---------------
	
	public Cadastro() {
		
	}
	
	public Cadastro(Clientes clientes, int id) {
		this.clientes = clientes;
		this.id = id;
		
	}

//-------------GETERS E SETTERS-------------	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cadastro id: " + id + ", " +clientes.toString() ;
			
	}
	
	@Override
	public String obterNomeArquivo() {
		return "cadastro.txt";
	}
	
	public Integer idGeneration() {
		return this.id += 1;
	}
	
	
}
