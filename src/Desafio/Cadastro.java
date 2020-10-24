package Desafio;

public class Cadastro extends HotelSystem {

	private Integer id;
	
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
		return "Cadastro id: " + id;
	}
	
	
	
	
	
}
