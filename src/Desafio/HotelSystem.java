package Desafio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HotelSystem {

	Clientes clientes;
	Quarto quartos;
	

	public HotelSystem() {
		
	}
	
	public HotelSystem(Quarto quarto1) {
		quartos = quarto1;
	}


	public String takeHour() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
		String agoraFormatado = now.format(formatter);
		return agoraFormatado;
	}

	@Override
	public String toString() {
		return quartos.toString();
	}
}
