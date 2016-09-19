
/**
 * Write a description of class Alumno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alumno
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String apellido;
    private String rut;
    private String nmatricula;
        
    public Alumno()
    {
        nombre="Nombre";
        apellido="Apellido";
        rut="12.345.678-0";
        nmatricula="12345678901";
    }

    public Alumno (String name, String lastName, String run, String matricula){
        nombre=name;
        apellido=lastName;
        rut=run;
        nmatricula=matricula;
    }
    
    public void setNombre (String name){
        nombre=name;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public void setApellido (String lastName){
        apellido=lastName;
    }
    
    public String getApellido (){
        return apellido;
    }
    
    public void setRut (String run){        
        rut=run;
    }
    
    public String getRut (){
        return rut;
    }
    
    public void setMatricula (String matricula){
        nmatricula=matricula;
    }
    
    public String getMatricula (){
        return nmatricula;
    }
    
    public String toString (){
        String str="nombre:"+nombre+"apellido:"+apellido+"rut:"+rut+"n°matricula:"+nmatricula;
        return str;
    }
}
