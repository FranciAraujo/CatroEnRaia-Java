package catroenraia;
import java.util.Scanner;
import tgames.Xogador;
import tgames.Ficha;
import tgames.MovementoIlegal;
import tgames.Xogada;
/** Xogador4enRaia: Elabora as xogadas pedindo o número de columna por consola. */
public class Xogador4enRaia extends Xogador {
    private static final Scanner SCN = new Scanner(System.in);
    
    public Xogador4enRaia(Ficha ficha) { super(ficha); }
    
    @Override
    public Xogada xoga() throws MovementoIlegal {
        Xogada xogada = null;
        System.out.print("Turno de " + this + ". Columna (0-6)?: ");
        try {
            String input = SCN.nextLine().trim();
            int columna = Integer.parseInt(input);
            if (columna < 0 || columna > 6) {
                throw new MovementoIlegal("O número de columna debe estar entre 0 e 6.");
            }
            xogada = new Xogada4enRaia(this, this.ficha, columna);
        } catch (NumberFormatException e) {
            throw new MovementoIlegal("Debes introducir un número válido"); 
        }
        return xogada;
    }
}
