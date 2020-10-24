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

	private static String arquivo;

	static {
		//String arquivo = "Banco de dados.txt";
	
	}
	static String caminhoAbsoluto = System.getProperty("user.home") + File.separator + arquivo;
	
	//Gravação de um arquivo
	public static void gravar(Armazenavel obj, Boolean sobrescrever) {
		try(FileWriter fw = new FileWriter(caminhoAbsoluto, false);
				BufferedWriter bf = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bf)){
			
	
			
		}catch(IOException e) {
			e.printStackTrace(); }
		}
	
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

