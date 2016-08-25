/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoscon_matriz;

import java.util.*;

/**
 *
 * @author Francisco Fierro
 */
public class MetodosCon_Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }
    public static boolean validarDimensiones(int filas, int cols) {
        if (filas <= 0 && cols <= 0) {            
            return false;
        } else {
            return true;

        }
    }
    public static void menu() {
        int matriz[][]= new int [0][0];
        int m, n, op,fila, cols;
        boolean zero;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese las dimensiones de la matriz");
        do{
        System.out.println("Ingrese cantidad de filas");
        m = leerDimensiones();
        System.out.println("Ingrese cantidad de columnas");
        n = leerDimensiones();        
        }while(!validarDimensiones(m,n));
        matriz=crearMatriz(m,n);
        System.out.println("Se ha creado la matriz");
        if ((matriz.length*matriz[0].length)>1000){        
        System.out.println("Espere, mientras se llena la matriz... \n(Dependiendo del tamaño de la matriz, puede demorar unos mins.)");
        }
        llenarMatriz(matriz);
        System.out.println("Se ha llenado la matriz");
        System.out.println("");
        do{
        System.out.println("¿Qué desea hacer ahora con la matriz?");
        System.out.println("1 - Mostrar fila");
        System.out.println("2 - Mostrar columna");
        System.out.println("3 - Verificar Tipo Cero");
        System.out.println("4 - Salir");
        op=leerOpcionMenu();
        switch(op){
            case 1:
                fila=leerFila(m);
                System.out.println("Se ha leido la fila");
                mostrarFila(matriz, fila);
                System.out.println("");
                break;
            case 2:
                cols=leerCols(n);
                System.out.println("Se ha leido la columna");
                mostrarCols(matriz, cols);
                System.out.println("");
                break;
            case 3:
                zero=matrizCero(matriz);
                if (zero==false){
                    System.out.println("No es Tipo Cero");
                } else {
                    System.out.println("Sí es Tipo Cero");
                }                
                break;
        }
        }while(op!=4);
    }
    static public int leerDimensiones() {
        int n = 0;
        Scanner scan = new Scanner(System.in);
        boolean confirm = false;
        do {
            String cadena = scan.nextLine();
            if (cadena.matches("[0-9]+")) {
                n = Integer.valueOf(cadena);
                if (n <= 0) {
                    System.out.println("Error, ingrese numero mayor a 0");
                } else {
                    confirm = true;
                }
            } else {
                System.out.println("Error, ingrese nuevamente el numero");
            }
        } while (!confirm);
        return n;
    }    
    static public int[][] crearMatriz (int m, int n){
        int matriz[][]= new int [m][n];
        return matriz;        
    }
    static public void llenarMatriz(int matriz[][]){
        //m= filas n=columnas
        int m,n, verificar=0;
        for (m = 0; m < matriz[0].length; m++) {            
            verificar=0;
            do{
            for (n = 0; n < matriz.length; n++) {
                int random = (int) (Math.random() * 10);
                matriz[m][n] = random;
                verificar+=matriz[m][n];               
            }                
        }while(verificar>100);
        }
    }
    static public int leerOpcionMenu(){
        int n = 0;
        Scanner scan = new Scanner(System.in);
        boolean confirm = false;
        do {
            String cadena = scan.nextLine();
            if (cadena.matches("[1-4]")) {
                n = Integer.valueOf(cadena);
                if (n <= 0) {
                    System.out.println("Error, ingrese nuevamente la opcion");
                } else {
                    confirm = true;
                }
            } else {
                System.out.println("Error, ingrese nuevamente la opcion");
            }
        } while (!confirm);
        return n;    
    }
    static public int leerFila(int filas){
        System.out.println("¿Qué fila desea revisar?");
        int n = 0;
        Scanner scan = new Scanner(System.in);
        boolean confirm = false;
        do {
            String cadena = scan.nextLine();
            if (cadena.matches("[0-9]+")) {
                n = Integer.valueOf(cadena);
                if (n > filas || n == 0) {
                    System.out.println("Error, ingrese un numero dentro de las dimensiones");
                } else {
                    confirm = true;
                }
            } else {
                System.out.println("Error, ingrese un numero dentro de las dimensiones");
            }
        } while (!confirm);
        return n;
    }
    static public void mostrarFila (int matriz[][], int fila){
        System.out.println("Datos de la fila "+fila);
        fila--;
        for (int cols=0; cols<matriz.length;cols++){
            System.out.println(matriz[cols][fila]);
        }
    }
    static public int leerCols(int cols){
        System.out.println("¿Qué columna desea revisar?");
        int n = 0;
        Scanner scan = new Scanner(System.in);
        boolean confirm = false;
        do {
            String cadena = scan.nextLine();
            if (cadena.matches("[0-9]+")) {
                n = Integer.valueOf(cadena);
                if (n > cols || n == 0) {
                    System.out.println("Error, ingrese un numero dentro de las dimensiones");
                } else {
                    confirm = true;
                }
            } else {
                System.out.println("Error, ingrese un numero dentro de las dimensiones");
            }
        } while (!confirm);
        return n;
        
    }
    static public void mostrarCols (int matriz[][], int cols){
    System.out.println("Datos de la fila "+cols);
        cols--;
        for (int fila=0; fila<matriz[cols].length;fila++){
            System.out.println(matriz[fila][cols]);
        }
    }
    static public boolean matrizCero (int matriz[][]){
        int cont=0, m, n, largo;
        for (m = 0; m < matriz[0].length; m++) {            
            for (n = 0; n < matriz.length; n++) {
                if (matriz[m][n]==0){
                    cont++;
                }                
            }
            }
        largo=matriz.length*matriz[0].length;
        if (cont>(largo/2)){
            return true;
        } else {
            return false;
        }
    }
}
