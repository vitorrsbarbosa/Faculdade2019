package aulaProgramacao._2bimestre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
	public static void main( String[] args )
    {
    	try {
			Connection conexao = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/3esoft2019",
					"postgres",
					"unicesumar");
			criarTabelaBilhete(conexao);
			inserirBilhete(conexao, 1,"Maringá","Maceió",new Date());;
			excluirTodosOsBilhetes(conexao);
    			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    	

	public static list<Bilhete> inserirBilhete(Connection conexao, Integer id, String origem, String destino, Date data) {
		String sql = "insert into bilhete"
				+"(id,origem,destino,data)"
				+"values (?,?,?,?)";
	}


	public static void criarTabelaBilhete(Connection conexao) throws Exception{
		String sql = "create table if not exists bilhete ("
				+"id integer not null primary key,"
				+"origem varchar2(255) not null,"
				+"destino varchar2(255) not null"
				+"data date not null)";
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		statement.close();
		
	}
}