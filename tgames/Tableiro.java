package tgames;
public class Tableiro {
    private Ficha[][] tableiro;
    private final String EMPTY_CELL = "🔲"; 
    public Tableiro(int nFilas, int nColumnas) { tableiro = new Ficha[nFilas][nColumnas]; init(); }
    public int nFilas() { return tableiro.length; }
    public int nColumnas() { return tableiro[0].length; }
    
    // Inicializa o taboleiro a null
    public void init() { 
        for(int f=0;f<tableiro.length;f++) { 
            for(int c=0;c<tableiro[0].length;c++) { tableiro[f][c]=null; } 
        } 
    }
    
    // Mostra o taboleiro con numeración de columnas
    public void show() {
        for (int c = 0; c < nColumnas(); c++) { System.out.print(" " + c); } System.out.println(); // Numeración
        for(int f=0;f<tableiro.length;f++) {
            for(int c=0;c<tableiro[0].length;c++) {
                System.out.print(tableiro[f][c] == null ? EMPTY_CELL : tableiro[f][c]);
            }
            System.out.println();
        }
    }
    
    // Coloca unha ficha (con comprobación de límites)
    public void ponFicha(int f, int c, Ficha ficha) throws MovementoIlegal {
        if (f < 0 || f >= nFilas() || c < 0 || c >= nColumnas()) {
            throw new MovementoIlegal("Posición (" + f + "," + c + ") está fóra do tableiro");
        }
        tableiro[f][c] = ficha;
    }
    
    // Obtén a ficha (con comprobación de límites)
    public Ficha colleFicha(int f, int c) throws MovementoIlegal {
        if (f < 0 || f >= nFilas() || c < 0 || c >= nColumnas()) {
            throw new MovementoIlegal("Posición (" + f + "," + c + ") está fóra do tableiro");
        }
        return tableiro[f][c];
    }
}
