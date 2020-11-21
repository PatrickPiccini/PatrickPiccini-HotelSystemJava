package BancoSQLite;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import SystemApp.Sistema;
import SystemRooms.Quarto;
import Entities.Clientes; 


public class CriarBancoSQLite {

    private final ConexaoSQLite conexaoSQLite;
    Integer num = 1;
    public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite) {
        this.conexaoSQLite = pConexaoSQLite;
    }

    public void criarTabelaPessoa() {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_cliente"
				+ "("
				+ "id integer PRIMARY KEY,"
				+ "Nome NVARCHAR(100),"
				+ "Email NVARCHAR(100),"
				+ "Cpf NVARCHAR(15),"
				+ "Rg NUMERIC,"
				+ "quarto NUMERIC,"
				+ "checkIn NVARCHAR,"
				+ "checkOut NVARCHAR,"
				+ "TempoReservado integer"
				+ ");";
        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela pessoa criada!");

        } catch (SQLException e) {
            //mensagem de erro na criaçao da tabela
        } finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
        
    }
    
    public void inserirDadosSqlite(Quarto quarto, Clientes cliente){
//-----------CONEXÃO COM BANCO SQLITE----------------

		conexaoSQLite.conectar();
		
		String sqlInsert = "INSERT INTO tbl_cliente ("
				+ "id,"
				+ "Nome, "
				+ "Email,"
				+ "Cpf, "
				+ "Rg, "
				+ "quarto, "
				+ "checkIn, "
				+ "checkOut,"
				+ "TempoReservado "
				+ ") VALUES(?,?,?,?,?,?,?,?,?)"
				+ ";";
		
		PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
			
			try {
				preparedStatement.setInt(1, num);
				preparedStatement.setString(2, cliente.getName());
				preparedStatement.setString(3, cliente.getEmail());
				preparedStatement.setString(4, cliente.getCpf());
				preparedStatement.setInt(5, cliente.getRg());
				preparedStatement.setInt(6, quarto.getRoom());
				preparedStatement.setString(7, quarto.getReservaPara());
				preparedStatement.setString(8, quarto.getReservaAte());
				preparedStatement.setString(9, quarto.getReserva());
				num += 1;
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
    	
        }
}
