package Desafio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivosDados {

	
	private static String arquivo= "Banco_de_dados.txt";
	static String caminhoAbsoluto = System.getProperty("user.home") + File.separator + arquivo;
	
//-------------GRAVA UM VETOR--------------
	public static void gravar(HotelSystem vect, Boolean sobrescrever) {
		try(FileWriter fw = new FileWriter(caminhoAbsoluto, false);
				BufferedWriter bf = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bf)){
			
			out.println(vect.toString());
			
		}catch(IOException e) {
			e.printStackTrace(); }
	}
	
	
//----------GRAVA A STRING-----------------
	
	public static void gravarname(Clientes cliente1, boolean b) {
		try(FileWriter fw = new FileWriter(caminhoAbsoluto, true);
				BufferedWriter bf = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bf)){
			
			out.println(cliente1.toString());
			
		}catch(IOException e) {
			e.printStackTrace(); }
		
	}
//----------LE O BACO DE DADOS-----------------	
	public static void ler(String arquivo) {
		String caminhoAbsoluto = obterCaminhoAbsoluto(arquivo);
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminhoAbsoluto))){
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();				
			}
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	private static String obterCaminhoAbsoluto(String arquivo) {
		
		return System.getProperty("user.home") + File.separator + arquivo;
	}









	
}

