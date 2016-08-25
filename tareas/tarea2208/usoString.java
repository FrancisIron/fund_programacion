/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usode_string;
import java.util.Scanner;
/**
 *
 * @author Francisco Fierro
 */
public class UsoDe_String {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        imprimirResultados();        
    }
    public static void imprimirResultados(){
        String cadena, subcadena;
        char caracter;
        System.out.println("Ingrese una cadena de caracteres");
        cadena=leerString();
        System.out.println("Ingrese sub cadena de caracteres (si es que así lo desea)");
        subcadena=leerString();
        System.out.println("Ingrese caracter a buscar (si es que así lo desea)");
        caracter=leerChar();
        System.out.println("El largo de la cadena es: "+largoCadena(cadena));
        System.out.println("La cadena "+cadena+" tiene "+contarVocales(cadena)+" vocales");
        System.out.println("La cadena "+cadena+" tiene "+contarConsonantes(cadena)+" consonantes");
        System.out.println("La cadena: "+cadena+" invertida queda: "+invertirString(cadena));
        if (existeChar(cadena, caracter)==true){
            System.out.println("En la cadena "+cadena+" existe el caracter: "+caracter);    
        } else 
            System.out.println("En la cadena "+cadena+" no existe el/los caracter/es: "+caracter);
        if(existeSubString(cadena, subcadena)==true){
            System.out.println("En la cadena "+cadena+" existe la subcadena: "+subcadena);
        } else 
            System.out.println("En la cadena "+cadena+" no existe la subcadena: "+subcadena);
        System.out.println("El arreglo de caracteres es: ");
        for (int n=0; n<cadena.length();n++){
            System.out.print(crearArrayChar(cadena)[n]+" ");
        }              
    }
    public static String leerString (){
        String cadena=null;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        while(!confirm){
            cadena=scan.nextLine();
            confirm=true;
        }
        return cadena;
    }
    public static char leerChar(){
        char cadenaChar=0;
        Scanner scan= new Scanner(System.in);
        cadenaChar= scan.next().charAt(0);
        return cadenaChar;
    }
    public static int largoCadena(String cadena){return cadena.length();}
    public static int contarVocales(String cadena){
        int conteo=0;
            for(int x=0;x<cadena.length();x++) {
                if ((cadena.charAt(x)=='a') || (cadena.charAt(x)=='e') || (cadena.charAt(x)=='i') || (cadena.charAt(x)=='o') || (cadena.charAt(x)=='u'))
                conteo++;
            }
        return conteo;
    }
    public static int contarConsonantes (String cadena){
        int conteo=0;
       for (int i=0; i<cadena.length();i++){
           String con= cadena.substring(i, i+1);
           if (con.matches("[aAeEiIoOuU]+")){
           }else
               if(con.matches("[a-zA-Z]")){
                   conteo++;
               }
       }
        return conteo;
    }
    public static String invertirString (String cadena){
        String anedac="";
        for (int i= cadena.length()-1; i>=0; i--){
            anedac+=cadena.charAt(i);
        }
        return anedac;
    }
    public static boolean existeChar(String cadena, char caracter){
        if (cadena.contains(Character.toString(caracter))){
            return true;
        } else
            return false;
    }
    public static boolean existeSubString(String cadena, String subcadena){
        if (cadena.contains(subcadena)){
            return true;
        } else
            return false;
    }
    public static char[] crearArrayChar (String cadena){
        char cadenaChar[]= cadena.toCharArray();
        return cadenaChar;
    }
    
    }
