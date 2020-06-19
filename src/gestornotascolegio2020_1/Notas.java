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

public class Notas {
    private Scanner teclado = new Scanner(System.in);
    private Periodo periodo;


    private long NoID;
    private Materia materia;
    private float NotaFinal;
    private float promedio;

    public Notas() {
        NotaFinal = 0;
        promedio = 0;
    }
    //0,0,0,0,1003245577,Calculo,Promedio,0
    //1,0,0,0,1003245577,Calculo,Promedio,6
    //1,2,0,0,1003245577,Calculo,Promedio,6+PrimedioP2
    //1,2,3,0,1003245577,Calculo,Promdeio,PromedioP2+PrimedioP3
    //1,2,3,4,1003245577,Calculo,Promedio,(PromedioP3+PrimedioP4)/4
    
    //0,1003245577,Calculo,Promedio,0
    //1,1003245577,Calculo,6,6
    //2,1003245577,Calculo,7,6+PrimedioP2
    //3,1003245577,Calculo,Promdeio,PromedioP2+PrimedioP3
    //4,1003245577,Calculo,Promedio,(PromedioP3+PrimedioP4)/4
    
    static ArrayList<Notas> ListaNotas;
    
        public Notas(Periodo periodo, long NoID, Materia materia, float promedio,float NotaFinal) {
        this.periodo = periodo;
        this.NoID = NoID;
        this.materia = materia;
        this.NotaFinal = NotaFinal;
        
        ListaNotas = new ArrayList<>();
    }
    
    public float getPromedio() {
        return promedio;
    }

//    public Notas(long NoID, Materia materia, float NotaFinal) {
//        this.NoID = NoID;
//        this.materia = materia;
//        this.NotaFinal = NotaFinal;
//        
//        ListaNotas = new ArrayList<>();
//    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

        
    public long getNoID() {
        return NoID;
    }

    public void setNoID(long NoID) {
        this.NoID = NoID;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public float getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(float NotaFinal) {
        this.NotaFinal = NotaFinal;
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
                Notas c=new Notas(getPeriodo(),getNoID(), getMateria(), getPromedio(), getNotaFinal());
                
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
        return getPeriodo() + "," + getNoID() + "," +  getMateria() + "," + getPromedio() + "," +  getNotaFinal();
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
    
        public float BuscarPromedioPeriodo(long NoID, Periodo periodo){
        //int c=0;
        for(Notas k: Notas.ListaNotas){
            
            if(k.getNoID() == NoID){
                //k.imprimir();
                if(k.getPeriodo() == periodo)
                    return k.getPromedio();
            }
        }
        return -1;
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
       
        System.out.println(getPeriodo() + "," + getNoID() + "," +  getMateria() + "," + getPromedio() + "," +  getNotaFinal());
        
    }
    
}

