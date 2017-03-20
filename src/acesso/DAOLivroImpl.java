package acesso;

import erro.ConexaoException;
import erro.RepositorioException;
import negocio.basica.Livro;
import tools.GerenciadorConexao;
import tools.GerenciadorConexaoMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Junior
 */
public class DAOLivroImpl implements DAOLivro{
    private final GerenciadorConexao GC = GerenciadorConexaoMySQL.getInstancia();

    @Override
    public void inserir(Livro l) throws ConexaoException,RepositorioException {
        String sql = "INSERT INTO livro(titulodolivro, nomedoautor, nomedaeditora) VALUES(?,?,?)";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setString(1, l.getTituloDoLivro());
            pstm.setString(2, l.getNomeDoAutor());
            pstm.setString(3, l.getNomeDaEditora());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }

    @Override
    public void alterar(Livro l) throws ConexaoException,RepositorioException {
        String sql = "UPDATE livro SET titulodolivro=?,nomedoautor=?,nomedaeditora=? WHERE cod_li=?";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setString(1, l.getTituloDoLivro());
            pstm.setString(2, l.getNomeDoAutor());
            pstm.setString(3, l.getNomeDaEditora());
            pstm.setInt(4, l.getCod_li());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }

    @Override
    public void excluir(Livro l) throws ConexaoException,RepositorioException {
        String sql = "DELETE FROM livro WHERE titulodolivro=?";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setString(1, l.getTituloDoLivro());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }

    @Override
    public void excluir(Integer id) throws ConexaoException,RepositorioException {
        String sql = "DELETE FROM livro WHERE cod_li=?";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }

    @Override
    public ArrayList<Livro> listar() throws ConexaoException,RepositorioException {
        String sql = "SELECT cod_li, titulodolivro, nomedoautor, nomedaeditora FROM livro";
        ArrayList<Livro> lista = new ArrayList<Livro>();
        try{
            Statement stm = GC.getConexao().createStatement();
            try (ResultSet rs = stm.executeQuery(sql)) {
                while(rs.next()){
                    Livro l = new Livro();
                    l.setCod_li(rs.getInt("cod_li"));
                    l.setTituloDoLivro(rs.getString("titulodolivro"));
                    l.setNomeDoAutor(rs.getString("nomedoautor"));
                    l.setNomeDaEditora(rs.getString("nomedaeditora"));
                    lista.add(l);
                }
            }
            return lista;
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }

    @Override
    public Livro pesquisar(Integer id) throws ConexaoException,RepositorioException {
        Livro l = null;
        String sql = "SELECT cod_li, titulodolivro, nomedoautor, nomedaeditora FROM livro WHERE cod_li=?";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if(rs.next()){
                    l = new Livro();
                    l.setCod_li(rs.getInt("cod_li"));
                    l.setTituloDoLivro(rs.getString("titulodolivro"));
                    l.setNomeDoAutor(rs.getString("nomedoautor"));
                    l.setNomeDaEditora(rs.getString("nomedaeditora"));
                }
            }
            return l;
           
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }
    
    @Override
    public Livro pesquisar(String nome) throws ConexaoException,RepositorioException {
        Livro l = null;
        String sql = "SELECT cod_li, titulodolivro, nomedoautor, nomedaeditora FROM livro WHERE titulodolivro=?";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setString(1, nome);
            try (ResultSet rs = pstm.executeQuery()) {
                if(rs.next()){
                    l = new Livro();
                    l.setCod_li(rs.getInt("cod_li"));
                    l.setTituloDoLivro(rs.getString("titulodolivro"));
                    l.setNomeDoAutor(rs.getString("nomedoautor"));
                    l.setNomeDaEditora(rs.getString("nomedaeditora"));
                }
            }
            return l;
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }
    
    @Override
    public Livro pesquisarDuplicidade(Livro l) throws ConexaoException,RepositorioException {
        Livro livro = null;
        String sql = "SELECT cod_li, titulodolivro, nomedoautor, nomedaeditora FROM livro WHERE titulodolivro=? AND cod_li<>?";
        try{
            PreparedStatement pstm = GC.getConexao().prepareStatement(sql);
            pstm.setString(1, l.getTituloDoLivro());
            pstm.setInt(2, l.getCod_li());
            try (ResultSet rs = pstm.executeQuery()) {
                if(rs.next()){
                    livro = new Livro();
                    livro.setCod_li(rs.getInt("cod_li"));
                    livro.setTituloDoLivro(rs.getString("titulodolivro"));
                    livro.setNomeDoAutor(rs.getString("nomedoautor"));
                    livro.setNomeDaEditora(rs.getString("nomedaeditora"));
                }
            }
            return livro;
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }
}
