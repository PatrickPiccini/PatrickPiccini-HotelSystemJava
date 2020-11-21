package SystemApp;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import BancoDeDadosTxt.ArquivosDados;
import BancoSQLite.*;
import Entities.Clientes;
import Entities.Cpf;
import Entities.HotelSystem;
import Entities.validarEmail;
import SystemRooms.OrderLuxo;
import SystemRooms.Quarto;


public class Sistema {

	public static void main(String[] args) throws ParseException  {

		while(true) {
			
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Cpf validacaoCpf = new Cpf();
		validarEmail validaremail = new validarEmail();
		HotelSystem[] vect = new HotelSystem[10];
		
		 ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
	     CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(conexaoSQLite);

	     criarBancoSQLite.criarTabelaPessoa();
		
		Quarto adm = new Quarto();
		
		
		
		adm.boasVindas();
		System.out.print("Opção: ");
		int n = sc.nextInt();
		
		if(n == 1) {
			ArquivosDados.ler("Banco_de_dados.txt");
		}else if(n == 2) {
			
		try {
//--------------DADOS DO CLIENTE--------------
		Clientes cliente = new Clientes();
		System.out.println(" ");
		sc.nextLine();
		System.out.println("Nome do Cliente: ");
		cliente.setName(sc.nextLine());
		System.out.println("E-mail do Cliente: ");
		cliente.setEmail(sc.next());
//--------------VALIDAÇAO DE EMAIL------------------
		while(validaremail.isValidEmailAddressRegex(cliente.getEmail()) == false) {
			System.out.println("\n--- EMAIL INVÁLIDO!---");
			System.out.println("E-mail do Cliente: ");
			cliente.setEmail(sc.next());	
		}
		
		System.out.println("CPF do Cliente: ");
		cliente.setCpf(sc.next());
		validacaoCpf.cpf(cliente.getCpf());
//--------------VALIDAÇÃO DE CPF-------------------
		while(validacaoCpf.valido() == false) {
			System.out.println("---CPF INVÁLIDO!---");
			System.out.println("CPF do Cliente: ");
			cliente.setCpf(sc.next());
			validacaoCpf.cpf(cliente.getCpf());
		}
		System.out.println("RG: ");
		cliente.setRg(sc.nextInt());
			

//--------------SELEÇÃO DO QUARTO-------------
		Quarto quarto = new Quarto();
		quarto.typeRoom();
		System.out.println("Tipo do quarto: ");
		String tipo = sc.next();
		quarto.levelLuxo = OrderLuxo.valueOf(tipo.toUpperCase());
		quarto.setReserva(quarto.takeHour());
		System.out.println("Escolha o numero do quarto [10]");
		quarto.setRoom(sc.nextInt());
		
		vect[quarto.getRoom()] = new HotelSystem(quarto);
		
		
//---------------DATA DE RESERVA-------------------
		System.out.print("Reservado para dia: ");
		quarto.setReservaPara(sc.next());
		System.out.print("Até dia: ");
		quarto.setReservaAte(sc.next());
		if(quarto.diferencaDeData() == 99) {
			System.out.println("\nData de Checkout menos que a de CheckIn!");
			System.out.print("Reservado para dia: ");
			quarto.setReservaPara(sc.next());
			System.out.print("Até dia: ");
			quarto.setReservaAte(sc.next());
			
			
		}else {
			quarto.diferencaDeData();
		}
				
//------PERCORRE O VETOR PARA PRINTAR AS INFORMAÇÕES DO QUARTO-----
		
		System.out.println();
		System.out.println("------Quarto Reservado------");
		for(int i = 0; i < 10; i++) {
			if(vect[i] != null) {
				System.out.println(cliente);
				System.out.println(vect[i]);
				//GRAVAÇÃO DAS INFO DO CLIENTE
				ArquivosDados.gravatest(cliente, false);
				//GRAVAÇÃO DAS INFO DO VETOR
				ArquivosDados.gravatest(vect[i], true);
			}
		}

//-----------CONEXÃO COM BANCO SQLITE----------------

		conexaoSQLite.conectar();
		
		String sqlInsert = "INSERT INT tbl_cliente ("
				+ "id,"
				+ "Nome, "
				+ "Email,"
				+ "Cpf, "
				+ "Rg, "
				+ "quarto, "
				+ "checkIn, "
				+ "checkOut,"
				+ "TempoReservado "
				+ ") VALUES(?,?,?,?,?,?,?,?)"
				+ ";";
		
		PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
		
			try {
				preparedStatement.setInt(1, 1);
				preparedStatement.setString(2, cliente.getName());
				preparedStatement.setString(3, cliente.getEmail());
				preparedStatement.setString(4, cliente.getCpf());
				preparedStatement.setInt(5, cliente.getRg());
				preparedStatement.setInt(6, quarto.getRoom());
				preparedStatement.setString(7, quarto.getReservaPara());
				preparedStatement.setString(8, quarto.getReservaAte());
				preparedStatement.setString(9, quarto.getReserva());
				
				int resultado = preparedStatement.executeUpdate();
				
				if(resultado == 1) {
					System.out.println("cliente inserido no banco");
				}else {
					System.out.println("Deu ruin no banco");
				}
							
			}catch(SQLException e) {
				System.out.println("Deu ruin no banco Exception");
			}finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, e);
					}		
				}
			}
			conexaoSQLite.desconectar();
//-----------------------------------------------------------------
	
		
		
		
		
//-----------------------EXCEPTIONS--------------------------
		
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Esse quarto não existe");
			e.printStackTrace();
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error");
		} catch(IllegalArgumentException e) {
			System.out.println("Esse tipo de quarto não existe");
			e.printStackTrace();
		}
		
		
		} else if(n == 3) {
			ArquivosDados.gravareset(" ", true);
		} else if (n == 4) {
			System.out.println("Até logo!");
			break;
		}
		
		
		//final do while
		}	
		
	//final do main
	}
	
//final da class
}
