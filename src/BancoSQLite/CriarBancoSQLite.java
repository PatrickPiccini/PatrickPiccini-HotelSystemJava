package BancoSQLite;


import java.sql.SQLException;
import java.sql.Statement;


public class CriarBancoSQLite {

    private final ConexaoSQLite conexaoSQLite;

    public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite) {
        this.conexaoSQLite = pConexaoSQLite;
    }

    public void criarTabelaPessoa() {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_cliente"
				+ ")"
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
}
