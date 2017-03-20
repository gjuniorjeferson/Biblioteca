/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acesso;

import erro.ConexaoException;
import erro.RepositorioException;
import negocio.basica.Livro;

import java.util.ArrayList;

/**
 *
 * @author Jeferson Junior
 */
public interface DAOLivro {
    
    /**
     * Insere o Livro no banco de dados
     * @param a Objeto com os dados do Livro
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    public void inserir(Livro l) throws ConexaoException,RepositorioException;
    
    /**
     * Altera os dados do Livro no BD
     * @param a Objeto contendo todos os dados tratados e validados do Livro
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void alterar(Livro l) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Livro no BD
     * @param a Objeto contendo todos os dados tratados e validados do Livro
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(Livro l) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Livro no BD
     * @param id Inteiro com o código do Livro
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public void excluir(Integer id) throws ConexaoException,RepositorioException;
    
    /**
     * Retorna a lista de Livro
     * @return Lista com todos os Livro do BD
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public ArrayList<Livro> listar() throws ConexaoException,RepositorioException;
    
    /**
     * Retorna o Livro correspondente ao id passado
     * @param id Filtro da consulta
     * @return O Livro
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Livro pesquisar(Integer id) throws ConexaoException,RepositorioException;

    /**
     * Retorna o Livro correspondente ao NOME passado
     * @param nome Filtro da consulta
     * @return O Livro
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Livro pesquisar(String nome) throws ConexaoException,RepositorioException;
    
    /**
     * Retorna o Livro correspondente ao NOME passado, com ID diferente
     * @param a Cliente com o ID e NOME, filtro da consulta
     * @return O Livro
     * @throws ConexaoException
     * @throws RepositorioException
     */
    public Livro pesquisarDuplicidade(Livro l) throws ConexaoException,RepositorioException;

}
