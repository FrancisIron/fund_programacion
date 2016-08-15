/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema02;

import java.util.Random;

/**
 *
 * @author Gamer
 */
public class Problema02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int confirmar = 0, magicSquare[][] = new int[3][3], n = 0;        
        while (confirmar == 0) {
            int matriz[][] = new int[3][3];
            matriz = rellenar(matriz);
            if (suma(matriz) == 8) {
                confirmar = 1;
                magicSquare = matriz;
                System.out.println("Intento N° " + n);
            } else {
                System.out.println("Intento N° " + n + " - fallido");
                confirmar = 0;
            }
            n++;
        }
        System.out.println("Se consiguió armar el cuadrado mágico en "+ n + " intentos");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(magicSquare[i][j]);
            }
            System.out.println();
        }
    }
    
    public static int random() {
        int random;
        Random r = new Random();
        random = r.nextInt(9) + 1;
        return random;
    }

    public static int[][] rellenar(int m[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int confirm = 0;
                while (confirm == 0) {
                    m[i][j] = random();
                    if (comparar(m, m[i][j]) == 1) {
                        confirm = 1;
                    }
                }
            }
        }
        return m;
    }
    
    public static int comparar(int m[][], int n) {
        int suma = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (n == m[i][j]) {
                    suma++;
                }
            }
        }
        return suma;
    }
    
    public static int suma(int m[][]) {
        int total = 0, suma = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                suma += m[i][j];
            }
            if (suma == 15) {
                total++;
            }
            suma = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                suma += m[j][i];
            }
            if (suma == 15) {
                total++;
            }
            suma = 0;
        }
        if (m[0][0] + m[1][1] + m[2][2] == 15) {
            total++;
        }
        if (m[0][2] + m[1][1] + m[2][0] == 15) {
            total++;
        }
        return total;
    }

    

}
