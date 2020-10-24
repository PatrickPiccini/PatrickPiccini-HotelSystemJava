package SystemApp;

import java.util.Locale;
import java.util.Scanner;
import BancoDeDados.ArquivosDados;
import Entities.Cadastro;
import Entities.Clientes;
import Entities.HotelSystem;
import SystemRooms.OrderLuxo;
import SystemRooms.Quarto;

public class Sistema {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		HotelSystem[] vect = new HotelSystem[10];
		

//--------------DADOS DO CLIENTE--------------
		Clientes cliente1 = new Clientes();
		System.out.println("Name of Client: ");
		cliente1.setName(sc.next());
		System.out.println("E-mail of Client: ");
		cliente1.setEmail(sc.next());
		System.out.println("CPF of Client: ");
		cliente1.setCpf(sc.nextLong());
		System.out.println("RG of Client: ");
		cliente1.setRg(sc.nextInt());
		
//---------------CADASTRO DO CLIENTE------------	
		Cadastro cadastroCleinte1 = new Cadastro();
		cadastroCleinte1.clientes = cliente1;
		cadastroCleinte1.setId(001);
		
//--------------SELE플O DO QUARTO-------------
		Quarto quarto1 = new Quarto();
		quarto1.typeRoom();
		System.out.println("Tipo do quarto: ");
		quarto1.levelLuxo = OrderLuxo.valueOf(sc.next());
		quarto1.setReserva(quarto1.takeHour());
		System.out.println("Escolha o numero do quarto [10]");
		quarto1.setRoom(sc.nextInt());
		
		vect[quarto1.getRoom()] = new HotelSystem(quarto1);
		
//------PERCORRE O VETOR PARA PRINTAR AS INFORMA합ES DO QUARTO-----
		System.out.println();
		System.out.println("Buys rooms:");
		for(int i = 0; i < 10; i++) {
			if(vect[i] != null) {
				System.out.println(vect[i]);
				//GRAVA플O DAS INFO DO VETOR
				ArquivosDados.gravatest(vect[i], false);
				//GRAVA플O DAS INFO DO CLIENTE
				//ArquivosDados.gravatest(cadastroCleinte1, false);
				
				
			}
		}
		System.out.println(cadastroCleinte1);
		
		
		
		
		sc.close();
	}



	
}
