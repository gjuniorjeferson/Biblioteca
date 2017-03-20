package erro;

/**
 *
 * @author Jeferson Junior
 */
public class GeralException extends Exception {
    public GeralException(){
        super();
    }
    
    public GeralException(Exception e){
        super(e);
    }
    
    public GeralException(String x){
        super(x);
    }
    
}
