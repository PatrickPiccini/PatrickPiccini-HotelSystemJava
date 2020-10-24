package Desafio;

public class HotelSystem {

	Clientes clientes;
	Quarto quartos;
	

	public HotelSystem() {
		
	}
	
	public HotelSystem(Quarto quarto1) {
		quartos = quarto1;
	}


	@Override
	public String toString() {
		return quartos.toString();
	}
}
