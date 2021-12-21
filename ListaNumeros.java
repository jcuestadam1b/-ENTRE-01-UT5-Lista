/**
 * Un objeto de esta clase
 * guarda una lista de n�meros enteros
 * 
 * La clase incluye una serie de m�todos de instancia
 * para hacer operaciones sobre la lista
 * y dos  m�todos est�ticos para trabajar con
 * arrays de dos dimensiones
 *
 * @Javier Cuesta -
 */


import java.util.Random;
import java.util.Arrays;
public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    //TODO
    int pos;
    int[] listaNumeros;

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tama�o m�ximo de la lista
     */
    public ListaNumeros(int n) {
        pos=0;
        listaNumeros = new int[n];
    }

    /**
     * A�ade un valor al final de la lista 
     * siempre que no est� completa
     *
     * @param numero el valor que se a�ade.  
     * @return true si se ha podido a�adir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if(pos<listaNumeros.length){
            listaNumeros[pos]= numero;
        }
        else {
            System.out.println("error cadena llena ");
        }
        
        pos = pos + 1;
        
        return (listaNumeros[pos-1])==numero;
    }

    /**
     * @return true si la lista est� completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        int contador = 0;
        int contador1 = 0;
        while(contador<listaNumeros.length){
            if(listaNumeros[contador]!=0){
                contador1++;
            }
            contador++;
        }
        
        return contador1==listaNumeros.length;
    }

    /**
     * @return true si la lista est� vac�a, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
       int contador = 0;
       int contador1 = 0;
        while(contador<listaNumeros.length){
            if(listaNumeros[contador]==0){
                contador1++;
            }
            contador++;
        }
        
        return contador1==listaNumeros.length;

    }

    /**
     * @return el n� de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vac�a la lista
     */
    public void vaciarLista() {
        int contador=0;
        while(contador<listaNumeros.length){
            listaNumeros[contador]=0;
        }
    }

    /**
     * @return una cadena con representaci�n textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista est� vac�a devuelve ""
     */
    public String toString() {
       //TODO
       String lista="";
       lista = ("--------------------------------------\n"+Arrays.toString(listaNumeros)+"\n--------------------------------------");
       
       
       return lista;
       
    }

     

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor m�ximo en la lista
     * Cuando no haya un segundo m�ximo el m�todo 
     * devolver� el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {       
       //TODO
       int primer_maximo=-999;
       int segundo_maximo=-999;
       int contador=0;
       int contador1=0;
       while(contador<listaNumeros.length){
           if(primer_maximo<listaNumeros[contador]){
                primer_maximo=listaNumeros[contador];
            }
           contador++; 
        }
       
       while(contador1<listaNumeros.length){
           if(primer_maximo!=listaNumeros[contador1]&&segundo_maximo<listaNumeros[contador1]){
                segundo_maximo=listaNumeros[contador1];
            }
           contador1++; 
        } 
       return segundo_maximo; 
    }

    /**
     * El m�todo coloca los valores que son segundos m�ximos al principio de
     * la lista respetando el orden de aparici�n del resto de elementos
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos m�ximos
     *          false si no se han colocado los segundos m�ximos porque no hab�a ninguno
     */
    public int[] segundosMaximosAlPrincipio() {
        //TODO
       int primer_maximo=-999;
       int segundo_maximo=-999;
       int contador=0;
       int contador1=0;
       int contador2=0;
       int contador3=0;
       int contadorSegundos=0;
       int guardadorNumSegundos=0;
       int[] segundosPrincipio = new int[listaNumeros.length];
       String lista = "";
       while(contador<listaNumeros.length){
           if(primer_maximo<listaNumeros[contador]){
                primer_maximo=listaNumeros[contador];
            }
           contador++; 
        }
       
       while(contador1<listaNumeros.length){
           if(primer_maximo!=listaNumeros[contador1]&&segundo_maximo<listaNumeros[contador1]){
                segundo_maximo=listaNumeros[contador1];
                contadorSegundos++;
            }
           contador1++; 
        } 
        
       guardadorNumSegundos = contadorSegundos-1;
        
       while(contadorSegundos!=0){
           segundosPrincipio[contador2] = segundo_maximo;
           contador2++;
           contadorSegundos = contadorSegundos-1;
       }
       
       
       
       while(contador3<=listaNumeros.length){
           if(listaNumeros[contador3]!=segundo_maximo){
               guardadorNumSegundos++;
               
               if(contador3!=3){
                    contador3++;
                }
                else if(contador3>=3){
                    contador3=3;
                }
               
               segundosPrincipio[contador3]=listaNumeros[guardadorNumSegundos];
               
               
           }
           else{
                contador3++;
           }

       }
       
       
       return segundosPrincipio;
    }

    /**
     * @param numero b�squeda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posici�n en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente m�todos de la clase Arrays
     */
    public void buscarBinario() {
         //TODO
         
         

    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tama�o DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public void crearBrillos() {
       //TODO
       
       

    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posici�n f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public void detectarEstrellas() {
       //TODO
       
       
       
    }

}
