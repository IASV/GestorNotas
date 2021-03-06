
package gestornotascolegio2020_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    static ArrayList<Notas> ListaNotas = new ArrayList<>();
    
        public Notas(Periodo periodo, long NoID, Materia materia, float promedio, float NotaFinal) {
        this.periodo = periodo;
        this.NoID = NoID;
        this.materia = materia;
        this.NotaFinal = NotaFinal;
        this.promedio = promedio;
    }
    
    public float getPromedio() {
        return promedio;
    }

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
        for (int i = 0; i < nNotas; i++) {
            System.out.print("Ingrese nota "+(i+1)+"\n--> ");
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
                Notas c=new Notas(Periodo.comparePeriodo(datos[0]),Integer.parseInt(datos[1]), Materia.compareMateria(datos[2]), Float.parseFloat(datos[3]), Float.parseFloat(datos[4]));
                
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

              Lineas +=c.getLinea()+"\n";

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
        System.out.println("Notas añadida con éxito.");
        
    }
    
    public static void Listar(){
        for(Notas k: Notas.ListaNotas){
            k.imprimir();
        }
        
    }
      
    public boolean Buscar(long NoID){
        for(Notas k: Notas.ListaNotas){
            
            if(k.getNoID() == NoID){
                k.imprimir();
                return true;
            }
        }
        return false;
    }
    
    public float BuscarPromedioPeriodo(long NoID, Periodo periodo){
        for(Notas k: Notas.ListaNotas){
            if(k.getNoID() == NoID){
                if(k.getPeriodo() == periodo)
                    return k.getPromedio();
            }
        }
        return 0;
    }
    
    public static float BuscarPromedioPeriodoMateria(long NoID, Materia materia, Periodo periodo){
        for(Notas k: Notas.ListaNotas){
            if(k.getNoID() == NoID){
                if(k.getMateria().toString().equals(materia.toString())){
                    if(k.getPeriodo().toString().equals(periodo.toString()))
                        return k.getPromedio();
                }
            }
        }
        return 0;
    }
    
    public static float BuscarPromedioPeriodoMateriaFinal(long NoID, Materia materia, Periodo periodo){
        for(Notas k: Notas.ListaNotas){
            if(k.getNoID() == NoID){
                if(k.getMateria().toString().equals(materia.toString()))
                    if(k.getPeriodo().toString().equals(periodo.toString()))
                        return k.getNotaFinal();
            }
        }
        return 0;
    }
    
    public boolean Encontrar(long NoID){
        
        for(Notas k: Notas.ListaNotas){
            if(k.getNoID() == NoID)
               return true;
        }
        return false;
    }   

    public void imprimir() {
       
        System.out.println(getPeriodo() + "," + getNoID() + "," +  getMateria() + "," + getPromedio() + "," +  getNotaFinal());
        
    }
    
}

