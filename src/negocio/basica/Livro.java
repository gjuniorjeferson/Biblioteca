package negocio.basica;

public class Livro {
	
	/**
	 * @return the tituloDoLivro
	 */
	public String getTituloDoLivro() {
		return tituloDoLivro;
	}
	/**
	 * @param tituloDoLivro the tituloDoLivro to set
	 */
	public void setTituloDoLivro(String tituloDoLivro) {
		this.tituloDoLivro = tituloDoLivro;
	}
	/**
	 * @return the nomeDoAutor
	 */
	public String getNomeDoAutor() {
		return nomeDoAutor;
	}
	/**
	 * @param nomeDoAutor the nomeDoAutor to set
	 */
	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}
	/**
	 * @return the nomeDaEditora
	 */
	public String getNomeDaEditora() {
		return nomeDaEditora;
	}
	/**
	 * @param nomeDaEditora the nomeDaEditora to set
	 */
	public void setNomeDaEditora(String nomeDaEditora) {
		this.nomeDaEditora = nomeDaEditora;
	}
	
	/**
	 * @return the cod_li
	 */
	public Integer getCod_li() {
		return cod_li;
	}
	/**
	 * @param cod_li the cod_li to set
	 */
	public void setCod_li(Integer cod_li) {
		this.cod_li = cod_li;
	}
	
	private String tituloDoLivro;
	private String nomeDoAutor;
	private String nomeDaEditora;
	private Integer cod_li;
	
    /**
     * Metodo boleano que verifica se os campos foram preechidos corretamente
     * @return true se os campos estiverem ok ou false se ouver erro no preenchimento
     */
    
    public Boolean isValido(){
        if(tituloDoLivro.isEmpty() || nomeDoAutor.isEmpty() || nomeDaEditora.isEmpty()){
            return false;
        }else{
        	return true;
        }
    }
}
