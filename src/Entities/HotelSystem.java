package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	
	public void typeRoom() {
		System.out.println("SIMPLES  ");
		System.out.println("INTERMEDIARIO  ");
		System.out.println("LUXO  ");
		System.out.println("EXECUTIVO  ");
	}

	@Override
	public String toString() {
		return quartos.toString();
	}
	
	public String obterNomeArquivo() {
		return "room.txt";
	}
	
}
