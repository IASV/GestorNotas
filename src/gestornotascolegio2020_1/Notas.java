/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestornotascolegio2020_1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */

// 1003245587, Calculo, notaFinal
public class Notas {
    private Scanner teclado = new Scanner(System.in);
    private long NoID;
    private Materia asignature;
    private float NotaFinal;

    public Notas() {
    }
    
    static ArrayList<Notas> ListaNotas;
    
    public Notas(long NoID, Materia asignature, float NotaFinal) {
        this.NoID = NoID;
        this.asignature = asignature;
        this.NotaFinal = NotaFinal;
        
        ListaNotas = new ArrayList<>();
    }

    public void setNoID(long NoID) {
        this.NoID = NoID;
    }

    public void setAsignature(Materia asignature) {
        this.asignature = asignature;
    }

    public void setNotaFinal(float NotaFinal) {
        this.NotaFinal = NotaFinal;
    }

    public long getNoID() {
        return NoID;
    }

    public Materia getAsignature() {
        return asignature;
    }

    public float getNotaFinal() {
        return NotaFinal;
    }


    
    public float promedioNotas(int nNotas){
        float n = 0;
        for (int i = 0; i <= nNotas; i++) {
            System.out.println("Ingrse nota "+(i+1));
            n += teclado.nextFloat();
        }
        return n/nNotas;
    }
    
    public void CargarLista(){
        //carga la lista de contactos del origen de datos
        
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;
        try {
            archivo = new File("Files\\Notas.txt");
            reader = new FileReader (archivo);
            buffer = new BufferedReader(reader);
            String linea;
            
            while( (linea=buffer.readLine()) != null) {
                
                String[] datos=linea.split(",");
                Notas c=new Notas(getNoID(), getAsignature(), getNotaFinal());
                
                Notas.ListaNotas.add(c);
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
        return getNoID() + "," +  getAsignature() + "," +  getNotaFinal();
    }
    
    public void Sincronizar(){
        //sincroniza la lista con el origen de datos
       File fichero = null;
       FileWriter writer = null;
       PrintWriter pw = null;
       try
       {
           String Lineas="";

           for(Notas c: Notas.ListaNotas){

              Lineas +=c.getLinea();

           }
           
            fichero = new File("Files\\Notas.txt");
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
        
    public void Add(Notas c){
        Notas.ListaNotas.add(c);
        
    }
    
    public void Listar(){
        
        for(Notas k: Notas.ListaNotas){
            k.imprimir();
        }
        
    }
      
    public boolean Buscar(long NoID){
        //int c=0;
        for(Notas k: Notas.ListaNotas){
            
            if(k.getNoID() == NoID){
                k.imprimir();
                return true;
            }
        }
        return false;
    }
    
    public boolean Encontrar(long NoID){
        
        for(Notas k: Notas.ListaNotas){
            if(k.getNoID() == NoID)
               return true;
        }
        return false;
    }
    
    public boolean Eliminar(long numero){
        
        for(Notas k: Notas.ListaNotas){
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
    
   
//    public void Actualizar(long NoID){
//       
//        int op=Buscar(NoID);
//        
//        if (op>=0) {
//             //Profesor.ListaProfesores.;
//        }
//         
//    }

    public void imprimir() {
       
        System.out.println(getNoID() + "," +  getAsignature() + "," +  getNotaFinal());
        
    }
    
}

