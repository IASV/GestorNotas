
package gestornotascolegio2020_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Profesor extends Persona{
    
    private Notas newNota = new Notas();
    private Estudiante student = new Estudiante();
    
    boolean exit = false;
    private Scanner teclado = new Scanner(System.in);
    private int actaPosecion = 0;
    private String titulo = "";
    private Materia materia;

    static ArrayList<Profesor> ListaProfesores;

//    public Profesor(int actaPosecion, String titulo, Materia materia) {
//        this.actaPosecion = actaPosecion;
//        this.titulo = titulo;
//        this.materia = materia;
//    }
    
    public Profesor() {
        this.actaPosecion =0;
        this.titulo = "";
        ListaProfesores = new ArrayList<>();
    }

    public Profesor(int actaPosecion, String titulo, Materia materia, TipoID tipoID, long noID, String nombre, Sexo sexo, Fecha fechaNacimiento) {
        super(tipoID, noID, nombre, sexo, fechaNacimiento);
        this.actaPosecion = actaPosecion;
        this.titulo = titulo;
        this.materia = materia;
        
        ListaProfesores = new ArrayList<>();
    }

    
    public void MenuOption(){
        long NoIDProfesor;
        float notaStudiante;
        long NoID;
        int op;
        do{
            System.out.print("_______________ Bienvenido _______________\n\n"
                + "Ingrese su número de identificación\n--> ");
            NoIDProfesor = teclado.nextLong();
            if(Encontrar(NoIDProfesor)){
                System.out.print("_______________ Menú Profesor _______________\n\n"
                            + "1. Registrar nota estudiante\n"
                            + "2. Salir\n"
                            + "\n--> ");
                    op = teclado.nextInt();

                    switch(op){
                        case 1:
                            //Register student
                            //TipoID
                            System.out.print("Ingrese el número de identificación del estudiante\n--> ");
                            NoID = teclado.nextLong();
                            if(student.Buscar(NoID)){
                                
                                //Student ID
                                newNota.setNoID(NoID);
                                
                                //Materia
                                newNota.setMateria(getMateria());
                                
                                //Periodo
                                System.out.print("Elija el periodo a asignar notas\n1. Periodo 1\n2. Periodo 2\n3. Periodo 3\n4. Periodo 4\n--> ");
                                switch(teclado.nextInt()){
                                    case 1:
                                        newNota.setPeriodo(Periodo.Periodo1);
                                        break;
                                     
                                    case 2:
                                        newNota.setPeriodo(Periodo.Periodo2);
                                        break;
                                     
                                    case 3:
                                        newNota.setPeriodo(Periodo.Periodo3);
                                        break;
                                    
                                    case 4:
                                        newNota.setPeriodo(Periodo.Periodo4);
                                        break;
                                        
                                    default:
                                        System.out.println("¡Oops!, ha ocurrido un error.");
                                        break;
                                }
                                
                                //Promedio de notas
                                System.out.println("Defina la cantidad de notas del estudiante a ingresar\n--> ");
                                newNota.setPromedio(newNota.promedioNotas(teclado.nextInt()));
                                
                                //Promedio nota final
                                newNota.setNotaFinal(newNota.promedioNotas(teclado.nextInt()) + newNota.getNotaFinal());
                                
                                //Add note
                                newNota.Add(newNota);
                            }
                            else
                                System.out.println("¡Oops!, el estudiante no existe o no esta registrado");
                            break;

                        case 2: 
                            exit = true;
                            break;

                    }
            }
            else
                System.out.println("¡Oops!, intenta de nuevo...");
        }while(exit == true);
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
    public int getActaPosecion() {
        return actaPosecion;
    }

    public void setActaPosecion(int actaPosecion) {
        this.actaPosecion = actaPosecion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    public void ToString(){
        
    }
    
    
     public void CargarLista(){
        //carga la lista de contactos del origen de datos
        
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;
        try {
            archivo = new File("Files\\Profesor.txt");
            reader = new FileReader (archivo);
            buffer = new BufferedReader(reader);
            String linea;
            
            while( (linea=buffer.readLine()) != null) {
                
                String[] datos=linea.split(",");
                Profesor c=new Profesor(getActaPosecion(),getTitulo(),getMateria(),getTipoID(),getNoID(),getNombre(),getSexo(),getFechaNacimiento());
                
                Profesor.ListaProfesores.add(c);
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
        return getActaPosecion() + "," +  getTitulo() + "," + getMateria() + "," +  getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento().getFecha();
    }
    
    public void Sincronizar(){
        //sincroniza la lista con el origen de datos
       File fichero = null;
       FileWriter writer = null;
       PrintWriter pw = null;
       try
       {
           String Lineas="";

           for(Profesor c: Profesor.ListaProfesores){

              Lineas +=c.getLinea();

           }
           
            fichero = new File("Files\\Profesor.txt");
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
        
    public void Add(Profesor c){
        Profesor.ListaProfesores.add(c);
        
    }
    
    public void Listar(){
        
        for(Profesor k: Profesor.ListaProfesores){
            k.imprimir();
        }
        
    }
      
    public int Buscar(Long NoID){
        int c=0;
        for(Profesor k: Profesor.ListaProfesores){
            
            if(k.getNoID() == NoID){
                k.imprimir();
                return c;
            }
            c++;
        }
        return -1;
    }
    
    public boolean Encontrar(long NoID){
        
        for(Profesor k: Profesor.ListaProfesores){
            if(k.getNoID() == NoID)
               return true;
        }
        return false;
    }
    
    public boolean Eliminar(long numero){
        
        for(Profesor k: Profesor.ListaProfesores){
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
    
   
    public void Actualizar(long NoID){
       
        int op=Buscar(NoID);
        
        if (op>=0) {
             //Profesor.ListaProfesores.;
        }
         
    }

    public void imprimir() {
       
        System.out.println(getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento());
        
    }
    
}
