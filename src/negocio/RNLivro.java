package negocio;

import erro.ConexaoException;
import erro.GeralException;
import erro.RepositorioException;
import negocio.basica.Livro;

import java.util.ArrayList;

import acesso.DAOLivro;
import acesso.DAOLivroImpl;

/**
 *
 * @author Jeferson Junior
 */
public class RNLivro {
    private final DAOLivro dao;
    
    public RNLivro(){
        dao = new DAOLivroImpl();
    }
/*
###########################################################
FUNCIONALIDADES (servem a GUI)
###########################################################
*/
    /**
     * Aciona a validacao dos dados e salva, um NOVO registro, no BD
     * @param c recebe o Objeto com os dados do Livro
     * @throws GeralException 
     */
    public void salvarNovo(Livro l)throws GeralException{
        validaPreenchimento(l);
        validar(l);
        duplicidade(l);
        inserir(l);
    }

    /**
     * Valida os dados e atualiza no BD
     * @param a Objeto com os dados do Cliente
     * @throws GeralException 
     */
    public void salvarAlteracao(Livro l)throws GeralException{
        validaPreenchimento(l);
        validaID(l);
        validar(l);
        existe(l);
        isNomeUnico(l);
        atualizar(l);
    }
    
    /**
     * Exclui um registro do BD por nome
     * @param a Objeto com os dados do Cliente
     * @throws GeralException 
     */
    public void excluirRegistroPorNome(Livro a)throws GeralException{
        validaID(a);
        existe(a);
        excluir(a);
    }
    
    /**
     * Exclui um registro pelo cod_cli
     * @param a Objeto cliente
     * @throws GeralException 
     */
    public void excluirRegistroPorCodigo(Livro a)throws GeralException{
        validaID(a);
        existe(a);
        excluir(a.getCod_li());
    }
    
    /**
     * Faz uma busca no BD por todos os registros
     * @return Lista com todos os objetos
     * @throws GeralException 
     */
    public ArrayList<Livro> listarTodos()throws GeralException{
        return listar();
    }
    
    /**
     * Faz uma busca no BD por um registro com o NOME do Cliente
     * @param a Objeto contendo, no minimo, o NOME
     * @return Um objeto com todos os dados do Cliente
     * @throws GeralException 
     */
    public Livro pesquisarNome(Livro l)throws GeralException{
        existe(l);
        return pesquisar(l.getTituloDoLivro());
    }

    /**
     * Faz uma busca no BD por um registro com o CODIGO do Cliente
     * @param a Objeto contendo, no minimo, o CODIGO
     * @return Um objeto com todos os dados do Cliente
     * @throws GeralException 
     */
    public Livro pesquisarCodigo(Livro a)throws GeralException{
        existe(a);
        return pesquisar(a.getCod_li());
    }
    
/*
###########################################################
FUNCOES INTERNAS (fragmentacao dos metodos)
###########################################################
*/
    
    /**
     * Verifica o preenchimento (vazio) dos campos
     * @param a Objeto com os dados preenchidos
     * @throws GeralException 
     */
    private void validaPreenchimento(Livro l)throws GeralException{
        if(l==null)
            throw new GeralException("Objeto invalido");
       // if(!l.isValido())
       //    throw new GeralException("Preenchimento invalido");
  
    }
   

    /**
     * Verifica os valores (regras) dos campos
     * valores dentro da regra (cpf, nome, endereco)
     * @param a Objeto com os dados preenchidos
     * @throws GeralException 
     */
    private void validar(Livro l)throws GeralException{
        if(l.getTituloDoLivro().trim().length()<=2)
            throw new GeralException("Nome invalido");  
    }
    
    /**
     * Verifica se o nome ja existe no BD
     * @param a Objeto com os dados preenchidos
     * @throws GeralException 
     */
    private void duplicidade(Livro l)throws GeralException{
        if(pesquisar(l.getTituloDoLivro())!=null)
            throw new GeralException("Nome ja existe");
    }

    /**
     * Verifica se o CODIGO existe no BD
     * @param a Obejto contendo o CODIGO do Cliente
     * @throws GeralException 
     */
    private void existe(Livro j)throws GeralException{
        if(pesquisar(j.getCod_li())==null)
            throw new GeralException("Livro Invalido");
    }
    
    /**
     * Faz uma busca no BD pelo CODIGO do Cliente
     * @param codigo
     * @return Objeto com os dados encontrados
     * @throws GeralException 
     */
    private Livro pesquisar(Integer codigo)throws GeralException{
        try{
            return dao.pesquisar(codigo);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    /**
     * Faz uma busca no BD pelo NOME do Cliente
     * @param nome
     * @return Objeto com os dados encontrados
     * @throws GeralException 
     */
    private Livro pesquisar(String nome)throws GeralException{
        try{
            return dao.pesquisar(nome);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    /**
     * Envia os dados para salvar no BD
     * @param a Objeto com os dados do Cliente
     * @throws GeralException 
     */
    private void inserir(Livro a)throws GeralException{
        try{
            dao.inserir(a);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("error no repositorio");
        }
    }

    /**
     * Envia os dados para salvar no BD
     * @param a Objeto com os dados do Cliente
     * @throws GeralException 
     */
    private void atualizar(Livro l)throws GeralException{
        try{
            dao.alterar(l);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("error no repositorio");
        }
    }

    /**
     * Envia os dados para excluir do BD
     * @param a Objeto com os dados do Cliente
     * @throws GeralException 
     */
    private void excluir(Livro l)throws GeralException{
        try{
            dao.excluir(l);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }
    /**
     * Envia os dados para excluir do BD
     * @param cod_cli codigo do cliente do tipo int
     * @throws GeralException 
     */
    
    private void excluir(int cod_cli)throws GeralException{
        try{
            dao.excluir(cod_cli);
        }catch(ConexaoException jeffDeNovoAqui){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException jeffDeNovoAqui){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    /**
     * Verifica se o campo CODIGO foi preenchido
     * @param a
     * @throws GeralException 
     */
    private void validaID(Livro l)throws GeralException {
        if((l.getCod_li()==null)||(l.getCod_li()==0))
            throw new GeralException("Codigo invalido");
    }
    
    /**
     * Solicita busca no BD por todos os registros
     * @return Lista com todos os registros encontrados no BD
     * @throws GeralException 
     */
    private ArrayList<Livro> listar()throws GeralException{
        try{
            return dao.listar();
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    /**
     * Verifica no BD se o NOME tem duplicidade no BD
     * @param a Objeto com os dados
     * @throws GeralException 
     */
    private void isNomeUnico(Livro a) throws GeralException{
        try{
            Livro x = dao.pesquisarDuplicidade(a);
            if(x!=null)
                throw new GeralException("Nome duplicado");
        }catch(ConexaoException e){
            throw new GeralException("Contacte o administrador");
        }catch(RepositorioException e){
            throw new GeralException("Desista! BUG!");
        }
    }


}