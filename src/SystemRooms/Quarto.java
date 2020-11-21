package SystemRooms;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import BancoDeDadosTxt.Armazenavel;
import Entities.HotelSystem;


public class Quarto extends HotelSystem implements Armazenavel{
	
//-------------ATRIBUTOS---------------
	
	private Integer room;
	private String reserva;
	public OrderLuxo levelLuxo;
	private String reservaPara;
	private String reservaAte;
	private Integer formatday;
	private Integer formatmonth;

	
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

	public String getReservaPara() {
		return reservaPara;
	}

	public void setReservaPara(String reservaPara) {
		this.reservaPara = reservaPara;
	}

	public String getReservaAte() {
		return reservaAte;
	}

	public void setReservaAte(String reservaAte) {
		this.reservaAte = reservaAte;
	}


//------------------METODOS---------------

	@Override
	public String toString() {
		return "Quarto number: " + room 
				+ ", levelLuxo: " + levelLuxo 
				+ "\nCheckIn: " + reservaPara
				+ "\nCheckOut: " + reservaAte
				+ "\nTempo Reservado: " + formatday+ " Dias e " + formatmonth + " Meses"
				+ "\nHorario da reserva: " + reserva;		
	}

	@Override
	public String obterNomeArquivo() {
		return "quarto.txt";
	}

	//excessão de data do checkout menos que o checkin
	//colocar mensagem para reservas a cima de 30 dias
	public Integer diferencaDeData() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate checkin = LocalDate.parse(reservaPara, formatter);
		LocalDate checkout = LocalDate.parse(reservaAte, formatter);
		
		Boolean dataMenor = checkout.isBefore(checkin);
		Boolean dataIgual = checkin.isEqual(checkout);
		
		if(dataIgual == true) {
				return 99;
			
		}else if(dataMenor == false) {
			try {	
				Period periodo = checkin.until(checkout);
				
				
				formatday = periodo.getDays();
				formatmonth = periodo.getMonths();
				return formatday + formatmonth;
				
				}catch(DateTimeParseException e){
					return null;
				}
		}else {
			return 99;
		}
		
	
	}
	
	
}
