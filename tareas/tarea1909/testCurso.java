import java.util.Scanner;
public class testCurso
{
    static Curso curso= new Curso();
    public static void main(){
        menu();
    }
    
    private static void menu(){
        String selec;
        do{
            System.out.println("Seleccione:");
            System.out.println("1)Agregar alumno predeterminado");
            System.out.println("2)Agregar alumno con atributos");
            System.out.println("3)Eliminar alumno");
            System.out.println("4)Ver curso");
            System.out.println("5)Buscar alumno por rut o matricula");
            System.out.println("6)Salir");
            selec=leerStr();            
        }while (check(selec)==false);
        seleccion(selec);
    }
    
    private static void seleccion(String sel)
    {
        switch(sel){
            case "1":
                curso.addAlumno();
                break;            
            case "2":
                System.out.println("Ingrese nombre");
                String nom=leerStr();
                System.out.println("Ingrese apellido");
                String ap=leerStr();
                String rut="";
                do{
                    System.out.println("Ingrese rut con puntos y guión(ej: 12.345.678-9)");
                    rut=leerStr();
                }while(validarRut(rut)==false);
                String mat="";
                do{
                    System.out.println("Ingrese matrícula");
                    mat=leerStr();
                }while(validarMat(rut,mat)==false);                
                curso.addAlumno(nom,ap,mat,rut);
                break;            
            case "3":
                System.out.println("Ingrese rut o matricula para eliminar alumno");
                curso.suprAlumno(leerStr());
                break;            
            case "4":
                System.out.println(curso.toString());
                break;            
            case "5":
                System.out.println("Ingrese rut a buscar con puntos y guión(ej: 12.345.678-9)");
                String str=leerStr();
                if(validarRut(str))
                {
                    if(curso.buscar(str))
                    {
                        System.out.println("El rut ingresado existe en el cruso");
                    }else{System.out.println("No existe el rut ingresado en el curso");}
                }
                break;
        }
    }
    
    private static boolean validarMat(String r, String m){        
        String rut = r.replaceAll("\\.","").replaceAll("\\-","");
        String matricula = m.substring(0,m.length()-2);
        String año= m.substring(m.length()-2);
        if (rut.equals(matricula) && año.matches("[0-9]{2,2}")){
            return true;
        } else {          
        return false;
        }
    }

    
    private static boolean validarRut(String r)
    {
        r = r.toUpperCase();
        if (validarFormatoRut(r)){
            String n = r.substring(0, r.length()-2);
            String d = r.substring(r.length()-1);
            n = n.replaceAll("\\.","");
            int v = digitoVerificador(n);
            if (v < 10) {
                if(d.equals(String.valueOf(v))) return true;
            } else if (v == 10) {
                if(d == "K") return true;
            }
        }
        return false;
    }
    
    private static boolean validarFormatoRut(String r){   
        return r.matches("[0-9]{1,2}\\.[0-9]{3,3}\\.[0-9]{3,3}\\-[0-9K]{1,1}");
    }
    
    private static int digitoVerificador(String r)
    {
        int ver = 0;int c = 1;int s = 0;
        int d[] = new int[r.length()];
    	for (int i = r.length()-1; i >= 0; i--){
    		d[i] = Integer.valueOf(r.substring(i, i+1));
    		c ++;
    		if (c > 7){ 
    		c = 2;
            }
    		s += (d[i]*c);
        }
        ver = 11-(s%11);
        if (ver == 11){ 
        ver = 0;
        }
        return ver;
    }
    
    private static String leerStr(){
        Scanner scan= new Scanner(System.in);
        String str= scan.nextLine();                
        return str;
    }    
    
    private static boolean check (String question){
        if (question.matches("[1-6]")) {
            return true;
        } else {
            System.out.println("Opción no valida");
            return false;
        }   
    }
}
