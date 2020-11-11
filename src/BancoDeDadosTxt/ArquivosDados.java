package BancoDeDadosTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ArquivosDados {

//-----------ATRIBUTOS----------------
	
	private static String arquivo= "Banco_de_dados.txt";
	static String caminhoAbsoluto = System.getProperty("user.home") + File.separator + arquivo;
	
//----------GRAVA O CLIENTE-----------------

	public static void gravatest(Armazenavel obj, Boolean sobrescrever) {
		try(FileWriter fw = new FileWriter(caminhoAbsoluto, true);
				BufferedWriter bf = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bf)){
			out.println("------------------------------------------");
			out.println(obj.toString());
			
		}catch(IOException e) {
			e.printStackTrace(); }
		
	}	
	
//-------------GRAVA UM ARQUIVO VAZIO PARA RESETAR-------------
	
	public static void gravareset(String string, Boolean sobrescrever) {
		try(FileWriter fw = new FileWriter(caminhoAbsoluto, false);
				BufferedWriter bf = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bf)){
			out.println(string);
			
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

