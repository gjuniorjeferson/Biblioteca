package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import erro.ConexaoException;

/**
 *
 * @author Jeferson Junior
 */
public class GerenciadorConexaoMySQL implements GerenciadorConexao{
    private static GerenciadorConexaoMySQL instancia;
    private static Connection c;
    private final String URL,NOME,SENHA;
    
    
    private GerenciadorConexaoMySQL(){
        ResourceBundle rb = ResourceBundle.getBundle("tools.banco");
        URL = rb.getString("url");
        NOME = rb.getString("nome");
        SENHA = rb.getString("senha");
    }
    
    /**
     * Retorna uma instancia Singleton da Classe
     * @return 
     */
    public static GerenciadorConexaoMySQL getInstancia(){
        if(instancia==null) instancia = new GerenciadorConexaoMySQL();
        return instancia;
    }
    
    @Override
    public Connection getConexao() throws ConexaoException{
        try{
            if((c==null)||(c.isClosed()))
                c = DriverManager.getConnection(URL,NOME,SENHA);
            return c;
        }catch(SQLException e){
            throw new ConexaoException();
        }
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        try{
            c.close();
        }catch(SQLException e){
            throw new ConexaoException();
        }
    }
    
}
