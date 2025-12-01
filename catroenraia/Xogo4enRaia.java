package catroenraia;
import tgames.Ficha;
import tgames.Motor;
import tgames.Resultado;
import tgames.Xogo;
/** Xogo4enRaia: Clase principal do proxecto, conten o método main() para arrancar o xogo. */
public class Xogo4enRaia {
    public static void main(String[] args) {
        // 1. Crear os xogadores e asignarlle as fichas
        Xogador4enRaia[] xogadores = new Xogador4enRaia[2];
        xogadores[0] = new Xogador4enRaia(new Ficha("🔴"));
        xogadores[1] = new Xogador4enRaia(new Ficha("🟡"));
        
        // 2. Crear o motor de xogo específico
        Motor motor = new Motor4enRaia(xogadores);
        
        // 3. Crear o xogo (bucle principal)
        Xogo game = new Xogo(motor);
        
        // 4. Iniciar e obter o resultado final
        Resultado result = game.play();
        
        System.out.println("\n===============================");
        System.out.println(result);
        System.out.println("===============================");
    }
}
