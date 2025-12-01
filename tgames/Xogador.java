package tgames;
public class Xogador {
    protected Ficha ficha; 
    public Xogador(Ficha ficha) { this.ficha=ficha; }
    public Ficha getFicha() { return ficha; }
    public Xogada xoga() throws MovementoIlegal { 
        throw new UnsupportedOperationException("E un xogador xenérico, non sabe facer xogadas"); 
    }
    @Override public String toString() { return ficha.toString(); }
}
