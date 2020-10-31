package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import BancoDeDados.Armazenavel;
import SystemRooms.Quarto;


public class HotelSystem implements Armazenavel {
	
//-----------ATRIBUTOS----------------
	
	
	public Clientes clientes;
	public Quarto quartos;
	
//-----------CONSTRUTORES-----------------
	
	public HotelSystem() {
	}
	public HotelSystem(Quarto quarto) {
		quartos = quarto;
	}
	
//------------MEOTODOS -----------]
	

	public String takeHour() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
		String agoraFormatado = now.format(formatter);
		return agoraFormatado;
	}
	
	
	public Date reserved(String date) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = sdf1.parse(date);
		
		return dataFormatada;
	}

	
	public void typeRoom() {
		System.out.println("\nTipos dos Quartos");
		System.out.println("SIMPLES  ");
		System.out.println("INTERMEDIARIO  ");
		System.out.println("LUXO  ");
		System.out.println("EXECUTIVO  \n");
	}
	

	@Override
	public String toString() {
		return quartos.toString();
	}
	
	public String obterNomeArquivo() {
		return "room.txt";
	}
	
}
