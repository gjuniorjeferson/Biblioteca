package biblioteca;


import erro.ConexaoException;
import erro.RepositorioException;
import negocio.basica.Livro;
import tools.GerenciadorConexao;
import tools.GerenciadorConexaoMySQL;

import javax.swing.JOptionPane;

import acesso.DAOLivro;
import acesso.DAOLivroImpl;

/**
 *
 * @author Jeferson Junior
 */
public class ADS02N2016 {
    private static final GerenciadorConexao GC = GerenciadorConexaoMySQL.getInstancia();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	testeLivro();
        //testeInserir();
       //testeAlterar();
       //testePesquisa();
    }
    
    private static void testeLivro() {
        try{
            Livro livro = new Livro();
            livro.setTituloDoLivro("testTituloDoLivro");
            livro.setNomeDoAutor("TestAutorDoLivro");
            livro.setNomeDaEditora("TestEditoraDoLivro");
            DAOLivro dao = new DAOLivroImpl();
            dao.inserir(livro);
            JOptionPane.showMessageDialog(null, "OK");
        }catch(ConexaoException e){
            JOptionPane.showMessageDialog(null, "Problemas no banco");
        }catch(RepositorioException e){
            JOptionPane.showMessageDialog(null, "Problemas no repositorio");
        }
    }
    
}
