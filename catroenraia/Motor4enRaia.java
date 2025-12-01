package catroenraia;
import tgames.Motor;
import tgames.MovementoIlegal;
import tgames.Resultado;
import tgames.Tableiro;
import tgames.Xogador;
import tgames.Xogada;
import tgames.Ficha;
/** Motor4EnRaia: E o motor do xogo do 4 en Raia, implementa a caída de fichas e a lóxica de vitoria. */
public class Motor4enRaia extends Motor {

    public Motor4enRaia(Xogador[] xogadores) {
        super(new Tableiro(6, 7), xogadores); // Taboleiro de 6 filas e 7 columnas
    }

    @Override
    protected Resultado procesaXogada(Xogada xogada) throws MovementoIlegal {
        Xogada4enRaia x4r = (Xogada4enRaia) xogada;
        Xogador xogador = x4r.getXogador();
        int columna = x4r.getColumna();
        Ficha ficha = x4r.getFicha();

        // 1. Verificar límites da columna
        if (columna < 0 || columna >= estado.nColumnas()) {
             throw new MovementoIlegal("O número de columna non é válido: " + columna);
        }
        
        // 2. CAIDA DA FICHA: Buscar a posición máis baixa dispoñible
        int fila = -1; // Inicializamos a unha posición inválida

        // Buscamos a primeira cela baleira dende abaixo (fila nFilas()-1) cara arriba (fila 0)
        for(int f = estado.nFilas() - 1; f >= 0; f--) {
            try {
                if (estado.colleFicha(f, columna) == null) {
                    fila = f;
                    break; // Atopamos a fila onde soltar a ficha
                }
            } catch (MovementoIlegal e) { /* non debería ocorrer */ }
        }
        
        if (fila == -1) {
            throw new MovementoIlegal("A columna " + columna + " está completamente chea.");
        }
        
        // 3. Poñer a ficha no taboleiro
        estado.ponFicha(fila, columna, ficha);

        // 4. Verificar condición de vitoria
        if (checkWin(ficha, fila, columna)) {
            return new Resultado("O gañador é " + xogador);
        }
        
        // 5. Verificar empate (taboleiro cheo)
        if (isBoardFull()) {
            return new Resultado("O Resultado foi de Empate");
        }

        return null; // O xogo continúa
    }

    /** Comproba se o taboleiro está completamente cheo (mirando só a fila superior) */
    private boolean isBoardFull() {
         for (int c = 0; c < estado.nColumnas(); c++) {
             try {
                 if (estado.colleFicha(0, c) == null) {
                     return false; 
                 }
             } catch (MovementoIlegal e) { /* non debería ocorrer */ }
         }
         return true; 
    }

    /** Determina se o xogador fixo 4 en raia coa última ficha colocada. */
    private boolean checkWin(Ficha ficha, int fila, int columna) {
        // Horizontal
        if (count(ficha, fila, columna, 0, 1) >= 4) return true;
        // Vertical
        if (count(ficha, fila, columna, 1, 0) >= 4) return true;
        // Diagonal \ (principal)
        if (count(ficha, fila, columna, 1, 1) >= 4) return true;
        // Diagonal / (secundaria)
        if (count(ficha, fila, columna, 1, -1) >= 4) return true;
        return false;
    }

    /** Conta as fichas iguais consecutivas sumando ambas direccións */
    private int count(Ficha ficha, int fila, int columna, int df, int dc) {
        int conta = 1; // A ficha colocada en (fila,columna) xa é 1
        // Sentido positivo 
        conta += countDir(ficha, fila, columna, df, dc);
        // Sentido negativo 
        conta += countDir(ficha, fila, columna, df * -1, dc * -1);
        return conta;
    }

    /** Conta as fichas iguais consecutivas nunha dirección específica. */
    private int countDir(Ficha ficha, int fila, int columna, int df, int dc) {
        int count = 0;
        int f = fila + df;
        int c = columna + dc;
        try {
            // Mentras a ficha que está en (f,c) no taboleiro sexa igual que ficha
            while (estado.colleFicha(f, c) == ficha) {
                count++; // Contamos
                f += df; // Avanzamos
                c += dc;
            }
        } catch (MovementoIlegal e) {
            // Chegouse aos límites do taboleiro
        }
        return count;
    }
}
