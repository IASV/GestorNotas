
package gestornotascolegio2020_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante extends Persona{

    static ArrayList<Estudiante> ListaEstudiantes;
    
    public Estudiante() {
        ListaEstudiantes = new  ArrayList<>();
    }

    public Estudiante(TipoID tipoID, long noID, String nombre, Sexo sexo, Fecha fechaNacimiento) {
        super(tipoID, noID, nombre, sexo, fechaNacimiento);
    }
    
    
//    public void MenuOption(){
//        Scanner teclado = new Scanner(System.in);
//        Notas note = new Notas();
//        System.out.print("Ingrese número de identifiacación\n--> ");
//        note.Buscar(teclado.nextLong());
//    }
    
    
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
            
            while( (linea=buffer.readLine()) != null) {
                
                String[] datos=linea.split(",");
                Estudiante c=new Estudiante(getTipoID(),getNoID(),getNombre(),getSexo(),getFechaNacimiento());
                
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
        return getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento();
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

              Lineas +=c.getLinea();

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
        
    }
    
    public void Listar(){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
            k.imprimir();
        }
        
    }
      
    public boolean Buscar(long NoID){
        for(Estudiante k: Estudiante.ListaEstudiantes){
            
            if(k.getNoID() == NoID){
                k.imprimir();
                return true;
            }
        }
        return false;
    }
    
    public boolean Encontrar(String nombre){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
            if(k.getNombre().equals(nombre))
               return true;
        }
        return false;
    }
    
    public boolean Eliminar(long numero){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
//           if(k.getNumero()==numero){
//               
//               int q=Buscar(numero);
//               System.out.println("Esta seguro de eliminar este registro Si --> y, No cualquier tecla");
//               String op=new java.util.Scanner(System.in).next();
//               
//               if (op.equals("y")) {
//                    length--;
//                    lista.remove(q);              
//                    return true;
//               }
//              
//           }
           
        }
        return false;
    }
    
   
//    public void Actualizar(String nombre, long telefono){
//       
//        int op=Buscar(nombre);
//        
//        if (op>=0) {
//             //Profesor.ListaProfesores.;
//        }
//         
//    }

    public void imprimir() {
       
        System.out.println(getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento().getFecha());
        
    }
    
}

