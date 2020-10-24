package Desafio;

import java.text.DateFormat;
import java.util.Date;

public class Quarto extends HotelSystem {
	
//-------------INSTÂNCIAS---------------
	Date date = new Date();
	private Integer room;
	private String reserva;
	Cadastro cadastro;
	OrderLuxo levelLuxo;
	String dateStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
	
//-----------CONTRUTORES---------------
	
	public Quarto() {
		
	}
	
	public Quarto(Integer number, OrderLuxo levelLuxo, Cadastro cadastro ) {
	
		this.levelLuxo = levelLuxo;
		this.reserva = dateStr;
		this.cadastro = cadastro;
	}


//-------------GETERS E SETTERS-------------	

	public OrderLuxo getLevelLuxo() {
		return levelLuxo;
	}

	public void setLevelLuxo(OrderLuxo levelLuxo) {
		this.levelLuxo = levelLuxo;
	}

	public String getReserva() {
		return dateStr;
	}

	public void setReserva(String reserva) {
		this.reserva = dateStr;
	}

	
	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Quarto number: " + room 
				+ ", levelLuxo: " + levelLuxo 
				+ ", reserva: " + reserva
				+ ", dados do cleinte: " + cadastro;
	}


	
	
	
	
	
	
	

	
	
	
}
