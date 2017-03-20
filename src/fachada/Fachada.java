package fachada;

import erro.GeralException;
import negocio.RNLivro;
import negocio.basica.Livro;

import java.util.ArrayList;

/**
 *
 * @author Jeferson Junior
 */
public class Fachada {
    private static Fachada instancia;
    private static RNLivro rnLivro;
    
    private Fachada(){
        rnLivro = new RNLivro();
    }
    
    public static Fachada getInstancia(){
        if(instancia==null) instancia=new Fachada();
        return instancia;
    }

    /**
     * 
     * @param Objeto contendo os dados do livro
     * @throws GeralException
     */
    public void salvarNovoLivro(Livro l)throws GeralException{
    	rnLivro.salvarNovo(l);
    }
    /**
     * 
     * @param Objeto contendo os dados do livro
     * @throws GeralException
     */
    public void salvarAlteracaoLivro(Livro l)throws GeralException {
    	rnLivro.salvarAlteracao(l);
    }
    /**
     * 
     * @param Objeto contendo os dados do livro
     * @throws GeralException
     */
    public void excluirLivroPorTitulo(Livro l) throws GeralException {
    	rnLivro.excluirRegistroPorNome(l);
    }
    /**
     * 
     * @param Objeto contendo os dados do livro
     * @throws GeralException
     */
    public void excluirLivroPorCodigo(Livro l) throws GeralException {
    	rnLivro.excluirRegistroPorCodigo(l);
    }
    /**
     * 
     * @return Retorna um vetor contendo os dados do livro
     * @throws GeralException
     */
    public ArrayList<Livro> listarTodosLivros() throws GeralException {
    	return rnLivro.listarTodos();
    }
    /**
     * 
     * @param Objeto contendo os dados do livro
     * @return Objeto contendo os dados do livro
     * @throws GeralException
     */
    public Livro pesquisarPorCodigo(Livro l) throws GeralException {
    	return rnLivro.pesquisarCodigo(l);
    }
    /**
     * 
     * @param Objeto contendo os dados do livro
     * @return Objeto contendo os dados do livro
     * @throws GeralException
     */
    public Livro pesquisarNome(Livro l) throws GeralException {
    	return rnLivro.pesquisarNome(l);
    }
}

