
package gestornotascolegio2020_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Estudiante extends Persona{

    static ArrayList<Estudiante> ListaEstudiantes = new ArrayList<>();
    
    public Estudiante() {
    }

    public Estudiante(TipoID tipoID, long noID, String nombre, Sexo sexo, Fecha fechaNacimiento) {
        super(tipoID, noID, nombre, sexo, fechaNacimiento);
    }
    
    public void CargarLista(){
        //carga la lista de contactos del origen de datos
        
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;
        try {
            archivo = new File("Files\\Estudiante.txt");
            reader = new FileReader (archivo);
            buffer = new BufferedReader(reader);
            String linea;
            while((linea = buffer.readLine())!= null) {
                String[] datos=linea.split(",");
                Fecha fecha = new Fecha(Fecha.getStringFecha(datos[4], "d"),Fecha.getStringFecha(datos[4], "m"),Fecha.getStringFecha(datos[4], "a"));
                Estudiante c = new Estudiante(TipoID.compareTipoID(datos[0]),Long.parseLong(datos[1]),datos[2],Sexo.compareSexo(datos[3]),fecha);
                Estudiante.ListaEstudiantes.add(c);                      
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != reader ){
                    reader.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    String getLinea(){
        return getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento().getFecha();
    }
    
    public void Sincronizar(){
        //sincroniza la lista con el origen de datos
       File fichero = null;
       FileWriter writer = null;
       PrintWriter pw = null;
       try
       {
           String Lineas="";

           for(Estudiante c: Estudiante.ListaEstudiantes){

              Lineas +=c.getLinea() + "\n";

           }
           
            fichero = new File("Files\\Estudiante.txt");
            writer = new FileWriter(fichero,false);
            pw = new PrintWriter(writer);
            pw.print(Lineas);

       } catch (Exception e) {
           e.printStackTrace();
       } finally {

           try {
               if (null != writer) {
                   writer.close();
               }
           } catch (Exception e2) {
               e2.printStackTrace();
           }
       }
    }
        
    public void Add(Estudiante c){
        Estudiante.ListaEstudiantes.add(c);
        System.out.println("Estudiante añadido con éxito.\n");
        
    }
    
    public static void Listar(){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
            k.imprimir();
        }
        
    }
      
    public static boolean Buscar(long NoID){
        for(Estudiante k: Estudiante.ListaEstudiantes){
            
            if(k.getNoID() == NoID){
                k.imprimir();
                return true;
            }
        }
        return false;
    }
    
    public static int BuscarPosicion(long NoID){
        int c=0;
        for(Estudiante k: Estudiante.ListaEstudiantes){
            if(k.getNoID() == NoID){
                System.out.println("__________________________Datos__________________________");
                k.imprimir();
                System.out.println("_________________________________________________________");
                return c;
            }
            c++;
        }
        return -1;
    }
    
    public static String BuscarNombre(long NoID){
        for(Estudiante k: Estudiante.ListaEstudiantes){
            if(k.getNoID() == NoID){
                return k.getNombre();
            }
        }
        return null;
    }
    
    public boolean Encontrar(String nombre){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
            if(k.getNombre().equals(nombre))
               return true;
        }
        return false;
    }
    
    public boolean Encontrar(Estudiante c){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
            if(k.equals(c))
               return false;
        }
        return true;
    }
    
    public static boolean Eliminar(long NoID){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
           if(k.getNoID()==NoID){
               int q=BuscarPosicion(NoID);
               System.out.print("Esta seguro de eliminar este registro \n1. Si \n2. No\n--> ");
               String op=new java.util.Scanner(System.in).next();
               
               if (op.equals("1")) {
                    ListaEstudiantes.remove(q);  
                    System.out.println("Estudiante eliminado con exito.");
                    return true;
               }
              
           }
           
        }
        return false;
    }
  
    public void imprimir() {
       
        System.out.println(getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento().getFecha());
        
    }
    
}

