import java.util.ArrayList;
/**
 * Write a description of class Curso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Curso
{
    ArrayList<Alumno> curso = new ArrayList<Alumno>();   
    
    public void addAlumno()
    {
        Alumno alum= new Alumno();
        curso.add(alum);
    }
    
    public void addAlumno(String name, String lastName, String run, String matricula){
        Alumno alum= new Alumno(name, lastName, run, matricula);
        curso.add(alum);
    }
    
    private boolean checkRUT(String consulta){
    if (consulta.matches("[0-9]+\\d{7,8}[-][0-9]")){
        return true;
    } else 
        return false;
    }
    
    public boolean buscar(String run)
    {
        for (int i = 0; i < curso.size(); i++)
        {
            if (curso.get(i).getRut().equals(run)){
                return true;
            }
        }
        return false;
    }   
    
    public void suprAlumno(String str){
        boolean confirm=false;        
        for (int i=0; i<curso.size();i++){            
          if(curso.get(i).getRut().equals(str)){
                    curso.remove(i);
                    confirm=true;
                    break;
          }
          if(curso.get(i).getMatricula().equals(str)){
                    curso.remove(i);
                    confirm=true;
                    break;
          }            
        }
        if (confirm=false){
            System.out.println("El alumno no existe");
        } else {
            System.out.println("El alumno fue suprimido exitosamente");
        }
    }
    
     public String toString()
    {
        String str="";
        for(int i=0;i<curso.size();i++)
        {
            str+="Alumno "+(i+1)+":\n"+curso.get(i).toString()+"\n";
        }
        return str;
    }

    
}
