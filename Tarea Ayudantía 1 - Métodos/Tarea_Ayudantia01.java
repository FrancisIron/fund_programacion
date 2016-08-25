/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_ayudantia1;
import java.util.Scanner;
/**
 *
 * @author Francisco Fierro
 */
public class Tarea_Ayudantia1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        String answer;
        do{
        System.out.println("Ingrese operación a calcular");
        answer=leer();        
        }while(!check(answer));
        operations(answer);
        
    }
    
    public static String leer(){
        Scanner scan= new Scanner(System.in);
        String str= scan.nextLine();
        str=str.replaceAll("\\s", "");        
        return str;
    } 
    
    public static boolean check (String question){
        if (question.matches("[0-9]+[\\+\\-\\*\\/\\^][0-9]+")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void operations (String question){        
        String op= question.replaceAll("[0-9]", "");
        String scan_num1= question.substring(0, question.indexOf(op));
        String scan_num2= question.replaceFirst(scan_num1, "").substring(1);
        double num1= Integer.valueOf(scan_num1);
        double num2= Integer.valueOf(scan_num2);
        switch(op){
            case "+" :                
                System.out.println("La suma es: "+suma(num1,num2));
                break;
            case "-":
                System.out.println("La resta es: "+resta(num1, num2));
                break;
            case "*":
                System.out.println("La multiplicación es: "+multi(num1, num2));
                break;
            case "/":
                System.out.println("La división es: "+div(num1, num2));
                break;
            case "^":
                System.out.println("La potencia es: "+pow(num1, num2));
    }
    }
    
    public static double suma (double num1, double num2){
        double answer=num1+num2;
        return answer;
    }
    
    public static double resta (double num1, double num2){
        double answer=num1-num2;
        return answer;
    }
    
    public static double multi(double num1, double num2){
        double answer=num1*num2;
        return answer;
    }
    
    public static double div(double num1, double num2){
        double answer=num1/num2;
        return answer;
    }
     
    public static double pow (double num1, double num2){
        double answer= Math.pow(num1, num2);
        return answer;
    }
}
