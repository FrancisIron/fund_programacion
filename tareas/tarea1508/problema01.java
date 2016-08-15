/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema01;

import java.util.*;
import static java.lang.Character.toUpperCase;
/**
 *
 * @author Gamer
 */
public class Problema01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    
    int n = 0, hombres = 0, mujeres = 0, hombresFavor = 0, mujeresContra = 0, total=0, totalFavor = 0, confirm = 0;
    while (confirm == 0) {
            System.out.println("Ingrese cantidad de hombres encuestados");
            hombres = leerInt();
            System.out.println("Ingrese cantidad de mujeres encuestados");
            mujeres = leerInt();
            if (hombres + mujeres == 0) {
                System.out.println("Ingrese por lo menos un encuestado");
            } else {
                confirm = 1;
            }    
            total = mujeres+hombres;
    }
            char encuest[][] = new char[2][hombres + mujeres];
        char answer;
        while (n < total) {
            while (hombres > 0) {
                System.out.println("Ingrese respuesta del Caballero \nEscriba S si aprueba la gestión, N si no y X si no sabe/no responde");
                answer = leerRespuesta();
                encuest[0][n] = answer;
                hombres--;
                n++;
                if (answer == 'S') {
                    hombresFavor++;
                    totalFavor++;
                }
            }
            if (mujeres != 0) {
                while (mujeres > 0) {
                    System.out.println("Ingrese respuesta de la Señora/Señorita \nEscriba S si aprueba la gestión, N si no y X si no sabe/no responde");
                    answer = leerRespuesta();
                    encuest[1][n] = answer;
                    mujeres--;
                    n++;
                    if (answer == 'N') {
                        mujeresContra++;
                    }
                    if (answer == 'S') {
                        totalFavor++;
                    }
                }
            }
        }        
        System.out.println("\nHombres a favor: " + hombresFavor);
        System.out.println("Mujeres en contra: " + mujeresContra);
        System.out.println("Porcentaje de aprobación: " + ((totalFavor * 100) / total));
        System.out.println("Cantidad total de gente encuestada: " + total);
}
    
    public static char leerRespuesta(){
        char answer= '0';
        String string;
        Scanner eleccion = new Scanner(System.in);
        while (answer != 'S' && answer != 'N' && answer != 'X') {
            string = eleccion.next();
            answer = string.charAt(0);
            if (answer == 's' || answer == 'n' || answer == 'x') {
                answer = toUpperCase(answer);
            }
                if (answer != 'S' && answer != 'N' && answer != 'X') {
                System.out.println("Ingrese una letra/opción válida");
            }            
        }
    return answer;
    }
    
    public static int leerInt() {
        int n = 0, confirm = 0, aux;
        Scanner num = new Scanner(System.in);
                aux = num.nextInt();
                if (aux < 0) {
                    System.out.println("Error! - Por favor, ingrese un número positivo");
                } else {
                    n = aux;
                    confirm = 1;
                }         
    return n;         
    }    

}

