import java.util.Random;
/**
 *    @author - Fermin Lanzas
 */
public class DemoBucles
{
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private Random generador;
    /**
     * Constructor  
     */
    public DemoBucles()
    {
       generador = new Random();
    }

    /**
     * Calcular la mayor potencia de 2 que es menor o igual a numero
     * Asumimos numero > 0
     * 
     * Si numero = 7 devuelve 4             numero = 8 devuelve 8
     *    numero = 19 devuelve 16           numero = 32 devuelve 32
     *    numero = 74 devuelve 64           numero = 1 devuelve 1
     *    numero = 190 devuelve 128
     *    
     *  Usa bucles while
     */
    public int mayorPotencia2(int numero) {
        int resultado = 1;
        while (resultado < numero){            
            resultado *= 2;
        }
        if (resultado > numero){
            resultado /= 2;
            }
        return resultado;
    }

    /**
     * Escribir numero como suma de potencias de 2 
     * tal como indica el enunciado (Se asume numero > 0)
     * 
     * Todos los valores se muestran en pantalla fomateados a 6 posiciones 
     * y ajustados a la derecha
     * 
     * Hay que usar el método anterior - 
     * Utiliza bucles while
     * 
     *  77 =    64     8     4     1
     * 215 =   128    64    16     4     2     1
     *  18 =    16     2
     *  64 =    64
     */
    public void escribirSumaPotencias(int numero) {
        String cadena = String.format("%6s =",numero); 
        int aux1 = numero;
        while (aux1 > 1){
            int aux2 = mayorPotencia2(aux1);
            aux1 -= aux2;
            cadena += String.format("%6s",aux2);
        }
        cadena += String.format("%6s","1");
        System.out.println("Si numero = " + numero + cadena);
    }

    /**
     * Generar aleatorios entre 0 y 255
     * y escribir cada aleatorio como suma de potencias de 2
     * Parar al salir el 255 o despues de generar n aleatorios
     * (ver enunciado)
     * 
     * Hay que usar el método anterior
     * 
     * Utiliza bucles while
     * 
     */
    public void generarAleatorios(int n) {
        System.out.println("Nºs aleatorios como suma de potencias de 2");
        int aleatorio = generador.nextInt(256);
        int i = 1;
        System.out.println();
        while(i <= n && aleatorio != 0){
            escribirSumaPotencias(aleatorio);
            aleatorio = generador.nextInt(256);
            i++;
        }
        if (aleatorio == 0){
            System.out.println("\nBucle terminado porque se ha salido el numero 0");
        }
        else {
            System.out.println("\nBucle terminado porque se han generado ya " + n + " aleatorios");
        }
    }

    /**
     *  Escribe en pantalla caracter n veces en la misma línes
     *  
     *  Usa bucles for
     */
    public void escribirCaracter(int n, char caracter)
    {
         for(int i = 1; i <= n; i++){
             System.out.printf("%1s",caracter);
         }
    }

    /**
     *  Genera la figura tal como muestra el enunciado 
     *  con ayuda del método anterior
     *  
     *   Usa bucles for
     */
    public  void mostrarEscalera(int escalones, int alto, int ancho) {
        for(int i = 0; i <= escalones - 1; i++){
            int aux1 = i * ancho;
            for(int j = 0; j <= alto - 1; j++){                
                escribirCaracter(aux1, ESPACIO);
                escribirCaracter(ancho, ASTERISCO);
                System.out.println();
            }
        }
    }

}
