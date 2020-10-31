package SystemApp;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import BancoDeDados.ArquivosDados;
import Entities.Cadastro;
import Entities.Clientes;
import Entities.Cpf;
import Entities.HotelSystem;
import Entities.validarEmail;
import SystemRooms.OrderLuxo;
import SystemRooms.Quarto;

public class Sistema {

	public static void main(String[] args) throws ParseException  {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Cpf validacaoCpf = new Cpf();
		validarEmail validaremail = new validarEmail();
		HotelSystem[] vect = new HotelSystem[10];
		
		try {
//--------------DADOS DO CLIENTE--------------
		Clientes cliente1 = new Clientes();
		
		System.out.println("Nome do Cliente: ");
		cliente1.setName(sc.next());
		System.out.println("E-mail do Cliente: ");
		cliente1.setEmail(sc.next());
//--------------VALIDAÇAO DE EMAIL------------------
		while(validaremail.isValidEmailAddressRegex(cliente1.getEmail()) == false) {
			System.out.println("\n--- EMAIL INVÁLIDO!---");
			System.out.println("E-mail do Cliente: ");
			cliente1.setEmail(sc.next());	
		}
		
		System.out.println("CPF do Cliente: ");
		cliente1.setCpf(sc.next());
		validacaoCpf.cpf(cliente1.getCpf());
//--------------VALIDAÇÃO DE CPF-------------------
		while(validacaoCpf.valido() == false) {
			System.out.println("---CPF INVÁLIDO!---");
			System.out.println("CPF do Cliente: ");
			cliente1.setCpf(sc.next());
			validacaoCpf.cpf(cliente1.getCpf());
		}
		System.out.println("RG: ");
		cliente1.setRg(sc.nextInt());
		
//---------------CADASTRO DO CLIENTE------------	
		Cadastro cadastroCleinte1 = new Cadastro();
		cadastroCleinte1.clientes = cliente1;
		cadastroCleinte1.setId(cadastroCleinte1.idGeneration());
		
//--------------SELEÇÃO DO QUARTO-------------
		Quarto quarto1 = new Quarto();
		quarto1.typeRoom();
		System.out.println("Tipo do quarto: ");
		String tipo = sc.next();
		quarto1.levelLuxo = OrderLuxo.valueOf(tipo.toUpperCase());
		quarto1.setReserva(quarto1.takeHour());
		System.out.println("Escolha o numero do quarto [10]");
		quarto1.setRoom(sc.nextInt());
		
		vect[quarto1.getRoom()] = new HotelSystem(quarto1);
		
		System.out.print("Reservado para dia: ");
		quarto1.setReservaPara(sc.next());
		System.out.print("Até dia: ");
		quarto1.setReservaAte(sc.next());

		
//------PERCORRE O VETOR PARA PRINTAR AS INFORMAÇÕES DO QUARTO-----
		System.out.println();
		System.out.println("Buys rooms:");
		for(int i = 0; i < 10; i++) {
			if(vect[i] != null) {
				System.out.println(vect[i]);
				//GRAVAÇÃO DAS INFO DO VETOR
				ArquivosDados.gravatest(vect[i], true);
				//GRAVAÇÃO DAS INFO DO CLIENTE
				ArquivosDados.gravatest(cadastroCleinte1, false);
			}
		}
		
		System.out.println(cadastroCleinte1);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("não tem esse quarto");
			e.printStackTrace();
			sc.next();
			
		} catch (InputMismatchException e) {
			System.out.println("Input error");
		} 
		
		sc.close();
	}

}
