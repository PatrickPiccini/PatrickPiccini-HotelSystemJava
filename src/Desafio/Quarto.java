package Desafio;

public class Quarto extends HotelSystem implements Armazenavel{
	
//-------------INSTÂNCIAS---------------
	private Integer room;
	private String reserva;
	OrderLuxo levelLuxo;

	
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
				+ ", reserva: " + reserva;
	}

	@Override
	public String obterNomeArquivo() {
		return "quarto.txt";
	}
	

	
	
}
