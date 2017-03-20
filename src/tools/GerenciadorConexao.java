package tools;

import java.sql.Connection;

import erro.ConexaoException;

/**
 *
 * @author Jeferson Junior
 */
public interface GerenciadorConexao {
    
    /**
     * Retorna uma conexao com o BD
     * @return 
     * @throws erro.ConexaoException 
     */
    public Connection getConexao() throws ConexaoException;
    
    /**
     * Desconecta do BD
     * @param c 
     * @throws erro.ConexaoException 
     */
    public void desconectar(Connection c) throws ConexaoException;
    
}
