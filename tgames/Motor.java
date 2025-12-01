package tgames;
import java.util.Random;
public abstract class Motor {
    protected Tableiro estado; 
    private Xogador[] xogadores;
    private int turno;
    
    protected Motor(Tableiro tableiro, Xogador[] xogadores) {
        this.estado = tableiro;
        this.xogadores = xogadores;
        this.turno = new Random().nextInt(xogadores.length); // Sortea el turno inicial
    }
    
    public Tableiro getEstado() { return estado; }
    public Xogador xogadorActual() { return xogadores[turno]; }
    
    protected Xogador seguinteTurno() {
        turno = (turno + 1) % xogadores.length; // Cambia el turno al siguiente jugador
        return xogadores[turno];
    }
    
    /** Método a implementar por cada juego específico para procesar la jugada */
    protected abstract Resultado procesaXogada(Xogada xogada) throws MovementoIlegal;
}
