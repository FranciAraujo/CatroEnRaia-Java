package catroenraia;
import tgames.Xogada;
import tgames.Ficha;
import tgames.Xogador;
/** Xogada4EnRaia: Contén o xogador, a ficha e a columna escollida. */
public class Xogada4enRaia extends Xogada {
    private final int columna; // Columna onde o xogador quere realizar a xogada.
    private final Ficha ficha;
    
    public Xogada4enRaia(Xogador xogador, Ficha ficha, int columna) {
        super(xogador); 
        this.ficha = ficha;
        this.columna = columna;
    }
    
    public Ficha getFicha() { return ficha; }
    public int getColumna() { return columna; }
}
