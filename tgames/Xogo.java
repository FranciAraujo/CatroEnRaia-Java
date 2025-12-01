package tgames;
public class Xogo {
    private Motor motor;
    public Xogo(Motor motor) { this.motor = motor; }
    
    public Resultado play() {
        Resultado result = null;
        motor.getEstado().init(); // Inicializa el tablero
        
        while (result == null) {
            motor.getEstado().show(); // Muestra el estado del juego
            Xogador xogador = motor.xogadorActual();
            Xogada xogada = null;
            boolean xogadaOk = false;
            
            while (!xogadaOk) {
                try {
                    xogada = xogador.xoga(); // El jugador elige la jugada
                    result = motor.procesaXogada(xogada); // El motor procesa la jugada
                    xogadaOk = true;
                } catch (MovementoIlegal e) {
                    System.out.println("\n[ERRO DE XOGADA]: " + e.getMessage());
                } catch (UnsupportedOperationException e) {
                    System.out.println("\n[ERRO DE XOGADA]: " + e.getMessage());
                    return new Resultado("Erro no Xogo: Xogador xenérico usado");
                }
            }
            if (result == null) motor.seguinteTurno(); // Cambia de turno si el juego continúa
        }
        motor.getEstado().show(); // Muestra el estado final
        return result;
    }
}
