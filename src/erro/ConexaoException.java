package erro;

/**
 *
 * @author Jeferson Junior
 */
public class ConexaoException extends Exception {
    public ConexaoException(){
        super();
    }
    
    public ConexaoException(Exception e){
        super(e);
    }
    
    public ConexaoException(String x){
        super(x);
    }
    
}
