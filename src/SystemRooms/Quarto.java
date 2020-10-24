package SystemRooms;

import BancoDeDados.Armazenavel;
import Entities.HotelSystem;


public class Quarto extends HotelSystem implements Armazenavel{
	
//-------------ATRIBUTOS---------------
	
	private Integer room;
	private String reserva;
	public OrderLuxo levelLuxo;
	Cadastro cadastro;

	
//-----------CONTRUTORES---------------
	
	public Quarto() {
		
	}
	
	public Quarto(OrderLuxo levelLuxo, String agoraFormatado) {
	
		this.levelLuxo = levelLuxo;
		this.reserva = agoraFormatado;
		
	}

//-------------GETERS E SETTERS-------------	

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public String getReserva() {
		return reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Quarto number: " + room 
				+ ", levelLuxo: " + levelLuxo 
				+ ", reservado: " + reserva;
	}

	@Override
	public String obterNomeArquivo() {
		return "quarto.txt";
	}
	

	
	
}
