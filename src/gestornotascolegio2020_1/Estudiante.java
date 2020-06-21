
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
        //ListaEstudiantes = new  ArrayList<>();
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
//            int cont = 0;
            while((linea = buffer.readLine())!= null) {
//                cont++;
//                System.out.println("Cuenta: "+ cont);
                String[] datos=linea.split(",");
                Fecha fecha = new Fecha(Fecha.getStringFecha(datos[4], "d"),Fecha.getStringFecha(datos[4], "m"),Fecha.getStringFecha(datos[4], "a"));
                Estudiante c = new Estudiante(TipoID.compareTipoID(datos[0]),Long.parseLong(datos[1]),datos[2],Sexo.compareSexo(datos[3]),fecha);
                Estudiante.ListaEstudiantes.add(c);
      
//                System.out.println(datos.length);
//                for (int i = 0; i < datos.length; i++) {
//                    System.out.print(datos[i] + ", ");
//                }
//                System.out.println();
                
//TarjetaIdentidad,1003245582,Camilo,Masculino,2/3/2002
//TarjetaIdentidad,1003245582,Andres,Masculino,2/3/2002
                
            }
//            System.out.println("Lista estudiantes");
//            Estudiante.Listar();
            
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
        
    }
    
    public static void Listar(){
        
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
    
    public boolean Encontrar(Estudiante c){
        
        for(Estudiante k: Estudiante.ListaEstudiantes){
            if(k.equals(c))
               return false;
        }
        return true;
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

