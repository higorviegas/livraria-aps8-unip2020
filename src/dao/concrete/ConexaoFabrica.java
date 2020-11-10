package dao.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoFabrica {
	private static final String USER = "admin";
    private static final String PW = "awsUNIP2020";
    private static final String URL = "jdbc:mysql://livrariambs.cken9tsusahz.sa-east-1.rds.amazonaws.com:3306/";
    private static final String DB = "livraria";
    private static final String OP = "?useSSL=false";
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	
            conn = DriverManager.getConnection(URL + DB + OP, USER, PW);
            return conn;
        } catch(SQLException e){
            throw new SQLException("Falha na conexao: " + e.getMessage());
            
        }
    }
    
    public static void closeConn(Connection conn){
        try{
            if(conn!=null){
                conn.close();
                System.out.println("Conexao com o banco de dados encerrada com sucesso.");
            }
        }catch(Exception e){
            System.out.println("Erro ao tentar encerrar conexao com o banco de dados: " + e.getMessage());
        }
    }
    
    public static void closeConn(Connection conn, PreparedStatement ps){
        try{
            if(conn!=null){
                closeConn(conn);
            }
            if(ps!=null){
                ps.close();
                System.out.println("PreparedStatement encerrado com sucesso.");
            }
        }catch(Exception e){
            System.out.println("Erro ao tentar encerrar PreparedStatement: " + e.getMessage());
        }
    }
    
    public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs){
        try{
            if(conn!=null || ps!=null){
                closeConn(conn, ps);
            }
            if(rs!=null){
                rs.close();
                System.out.println("ResultSet encerrado com sucesso.");
            }
        }catch(Exception e){
            System.out.println("Erro ao tentar encerrar ResultSet: " + e.getMessage());
        }
    }
}
