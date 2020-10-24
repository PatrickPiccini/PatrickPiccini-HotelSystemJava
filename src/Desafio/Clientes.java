package Desafio;

public class Clientes implements Armazenavel {

//----------INSTÂNCIAS--------------
	private String name;
	private String email;
	private Integer cpf;
	private Integer rg;
	
//----------CONTRUTORES---------------	
	
	public Clientes(){
		
	}
	
	public Clientes(String name, String email, Integer cpf, Integer rg) {
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

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
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
		return "Clientes name: " + name 
				+ ", email: " + email 
				+ ", cpf: " + cpf 
				+ ", rg: " + rg;
	}
	
	@Override
	public String obterNomeArquivo() {
		return "cliente.txt";
	}
	

	
}
	
	
	

