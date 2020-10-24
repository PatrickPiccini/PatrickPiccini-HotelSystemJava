package Desafio;

import java.util.Locale;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		HotelSystem[] vect = new HotelSystem[10];
		

//------DADOS DO CLIENTE------
		Clientes cliente1 = new Clientes();
		System.out.println("Name of Client: ");
		cliente1.setName(sc.next());
		System.out.println("E-mail of Client: ");
		cliente1.setEmail(sc.next());
		System.out.println("CPF of Client: ");
		cliente1.setCpf(sc.nextInt());
		System.out.println("RG of Client: ");
		cliente1.setRg(sc.nextInt());
		
//------CADASTRO DO CLIENTE------		
		Cadastro cadastroCleinte1 = new Cadastro();
		cadastroCleinte1.clientes = cliente1;
		cadastroCleinte1.setId(001);
		
//------SELEÇÃO DO QUARTO------
		Quarto quarto1 = new Quarto();
		System.out.println("Escolha o numero do quarto [10]");
		quarto1.setRoom(sc.nextInt());
		System.out.println(" Tipo do quarto: ");
		//OrderLuxo Estyle1 = OrderLuxo.valueOf("LUXO");
		quarto1.setReserva(quarto1.takeHour());
		
		
		vect[quarto1.getRoom()] = new HotelSystem(quarto1);
		
		
		System.out.println();
		System.out.println("Buys rooms:");
		for(int i = 0; i < 10; i++) {
			if(vect[i] != null) {
				System.out.println(vect[i]);
				ArquivosDados.gravar(vect[i], false);
				
				
			}
		}
		System.out.println(cadastroCleinte1);
		ArquivosDados.gravarname(cliente1, false);
		
		
		
		sc.close();
	}




	
}
