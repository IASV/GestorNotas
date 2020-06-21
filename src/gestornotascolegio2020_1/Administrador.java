
package gestornotascolegio2020_1;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Persona{
    
    static ArrayList<Administrador> ListaAdministradores;
    Scanner teclado = new Scanner(System.in);

    public Administrador() {
    }
    
    
    public Administrador(TipoID tipoID, long noID, String nombre, Sexo sexo, Fecha fechaNacimiento) {
        super(tipoID, noID, nombre, sexo, fechaNacimiento);
        
        ListaAdministradores = new ArrayList<>();
    }
    
    
    public void MenuOption(){
        String NameUser;
        long NoIDUser;
        int op;
        boolean exit = false;
        
        TipoID tipoID;
        long noID;
        String nombre;
        Sexo sexo;
        Fecha fechaNacimiento;
        
        
//        System.out.print("_______________ Bienvenido _______________\n\n"
//                + "Ingrese usuario\n--> ");
//        NameUser = teclado.nextLine();
//        System.out.print("Ingrese contraseña\n--> ");
//        NoIDUser = teclado.nextLong();
//        "root".equals(NameUser) & NoIDUser == 12345
        if (true){ 
            do{
                System.out.print("_______________ Menú administrador _______________\n\n"
                        + "1. Crear estudiante\n"
                        + "2. Crear maestro\n"
                        + "3. Eliminar estudiante\n"
                        + "4. Eliminar maestro\n"
                        + "5. Salir\n"
                        + "6. Ver estudiantes\n"
                        + "7. Ver profesores\n"
                        + "\n--> ");
                op = teclado.nextInt();

                switch(op){
                    case 1:
                        //Create student
                        Estudiante newStudent = new Estudiante();
                        //TipoID
                        System.out.print("Escoja tipo de ID\n1. Tarjeta de identidad\n2. Cédula\n3. Pasaporte\n--> ");
                        switch(teclado.nextInt()){
                            case 1:
                                newStudent.setTipoID(TipoID.TarjetaIdentidad);
                                break;
                                
                            case 2:
                                newStudent.setTipoID(TipoID.Cedula);
                                break;
                                
                            case 3:
                                newStudent.setTipoID(TipoID.Pasaporte);
                                break;
                        }    

                        //NoID
                        System.out.print("Ingrese el número de identifiacación del estudiante\n--> ");
                        newStudent.setNoID(teclado.nextLong());

                        //Nombre
                        System.out.print("Ingrese el nombre del estudiante\n--> ");
                        //String name = teclado.nextLine();
                        newStudent.setNombre(teclado.next());

                        //Sexo
                        System.out.print("Elija el sexo\n1. Masculino\n 2. Femenino\n--> ");
                        switch(teclado.nextInt()){
                            case 1:
                                newStudent.setSexo(Sexo.Masculino);
                                break;
                            
                            case 2:
                                newStudent.setSexo(Sexo.Femenino);
                                break;
                        }

                        //Fecha de nacimiento
                        fechaNacimiento = new Fecha();
                        System.out.println("Ingrese fecha de nacimiento");
                        System.out.print("Día\n--> ");
                        fechaNacimiento.setDia(teclado.nextInt());
                        System.out.print("Mes\n--> ");
                        fechaNacimiento.setMes(teclado.nextInt());
                        System.out.print("Año\n--> ");
                        fechaNacimiento.setAño(teclado.nextInt());
                        
                        newStudent.setFechaNacimiento(fechaNacimiento);

                        //Añdir estudiante la lista
                        //if(newStudent.Encontrar(newStudent))
                        newStudent.Add(newStudent);
                        System.out.println("Estudiante agregado a la lista.");
                        newStudent.imprimir();
                        System.out.println("Lista estudiantes");
                        Estudiante.Listar();
                        
                        break;
                        
                    case 2:
                        //Cargar profesores
                        Profesor newProfesor = new Profesor();
                        //Create teacher
                        //TipoID
                        System.out.print("Escoja tipo de ID\n1. Tarjeta de identidad\n2. Cédula\n3. Pasaporte\n--> ");
                        switch(teclado.nextInt()){
                            case 1:
                                newProfesor.setTipoID(TipoID.TarjetaIdentidad);
                                break;
                            
                            case 2:
                                newProfesor.setTipoID(TipoID.Cedula);
                                break;
                                
                            case 3:
                                newProfesor.setTipoID(TipoID.Pasaporte);
                                break;
                        } 

                        //NoID
                        System.out.print("Ingrese el número de identifiacación del profesor/a\n--> ");
                        newProfesor.setNoID(teclado.nextLong());
                        
                        //Nombre
                        System.out.print("Ingrese el nombre del profesor/a\n--> ");
                        newProfesor.setNombre(teclado.next());

                        //Sexo
                        System.out.print("Elija el sexo\n1. Masculino\n2. Femenino\n--> ");
                        switch(teclado.nextInt()){
                            case 1:
                                newProfesor.setSexo(Sexo.Masculino);
                                break;
                            
                            case 2:
                                newProfesor.setSexo(Sexo.Femenino);
                                break;
                        }

                        //Fecha de nacimiento
                        Fecha fechaNacimientoProfesor;

                        System.out.println("Ingrese fecha de nacimiento");
                        System.out.print("Día\n--> ");
                        int d = teclado.nextInt();
                        System.out.print("Mes\n--> ");
                        int m = teclado.nextInt();
                        System.out.print("Año\n--> ");
                        int a = teclado.nextInt();
                        fechaNacimientoProfesor = new Fecha(d, m, a);
                        newProfesor.setFechaNacimiento(fechaNacimientoProfesor);
                        
                        //Acta de Posición
                        System.out.print("Ingrese el acta de posición númerica\n--> ");
                        newProfesor.setActaPosecion(teclado.nextInt());
                        
                        //Título
                        System.out.print("Ingrese el título del profesor/a\nSolo una plabra. Ej: Ingeniero/a, Licenciado/a, etc\n--> ");
                        newProfesor.setTitulo(teclado.next());
                        
                        
                        //Set asignature to teachers
                        System.out.print("Elige materia a saignar al maestro\n1. Cálculo\n2. Física\n3. Quimica\n4. Religión\n5. Ética\n--> ");
                        switch(teclado.nextInt()){
                            case 1:
                                newProfesor.setMateria(Materia.Calculo);
                                break;

                            case 2:
                                newProfesor.setMateria(Materia.Fisica);
                                break;

                            case 3:
                                newProfesor.setMateria(Materia.Quimica);
                                break;

                            case 4:
                                newProfesor.setMateria(Materia.Religion);
                                break;

                            case 5:
                                newProfesor.setMateria(Materia.Etica);
                                break;
                        }
                        
                        //Añdir estudiante la lista
                        newProfesor.Add(newProfesor);
                        
                        break;

                    case 3:
                        //Delete student
                            System.out.print("Ingrese el número de identificación del estudiante\n--> ");
                            long id = teclado.nextLong();
                            System.out.print("Dese eliminar el estudiante\n1. Si\n2. No\n--> ");
                            if(teclado.nextInt() == 1){
                                //newStudent.Eliminar(id);
                                System.out.print("Estudiante eliminado con exito");
                            }
                            else{
                                System.out.print("Estudiante no eliminado");
                            }
                        break;

                    case 4:
                        //Delete teacher
                            System.out.print("Ingrese el número de identificación del profesor\n--> ");
                            long idProfe = teclado.nextLong();
                            System.out.print("Desea eliminar el profesor\n1. Si\n2. No\n--> ");
                            if(teclado.nextInt() == 1){
                                //newProfesor.Eliminar(idProfe);
                                System.out.println("Profesor eliminado con exito");
                            }
                            else{
                                System.out.println("Profesor no eliminado");
                            }
                        break;
                        
                    case 5:
                        //Exit
                        exit = true;
                        break;
                        
                    case 6:
                        //Ver estudiantes
                        System.out.println("Lista estudiantes");
                        Estudiante.Listar();
                        break;
                        
                    case 7:
                        //Ver profesores
                        System.out.println("Lista profesores");
                        Profesor.Listar();
                        break;

                    default:
                        System.out.println("¡Oops!, ha ocurrido un error.");
                        break;
                }
                
            }while(exit != true);
        }
        
    }
}
    
//    
//    public void CargarLista(){
//        //carga la lista de contactos del origen de datos
//        
//        File archivo = null;
//        FileReader reader = null;
//        BufferedReader buffer = null;
//        try {
//            archivo = new File("Files\\Administrador.txt");
//            reader = new FileReader (archivo);
//            buffer = new BufferedReader(reader);
//            String linea;
//            
//            while( (linea=buffer.readLine()) != null) {
//                
//                String[] datos=linea.split(",");
//                Administrador c=new Administrador(getTipoID(),getNoID(),getNombre(),getSexo(),getFechaNacimiento());
//                
//                Administrador.ListaAdministradores.add(c);
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            try{
//                if( null != reader ){
//                    reader.close();
//                }
//            }catch (Exception e2){
//                e2.printStackTrace();
//            }
//        }
//
//    }
//
//    
//    
//    String getLinea(){
//        return getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento().getFecha();
//    }
//    
//    public void Sincronizar(){
//        //sincroniza la lista con el origen de datos
//       File fichero = null;
//       FileWriter writer = null;
//       PrintWriter pw = null;
//       try
//       {
//           String Lineas="";
//
//           for(Administrador c: Administrador.ListaAdministradores){
//
//              Lineas +=c.getLinea();
//
//           }
//           
//            fichero = new File("Files\\Administrador.txt");
//            writer = new FileWriter(fichero,false);
//            pw = new PrintWriter(writer);
//            pw.print(Lineas);
//
//       } catch (Exception e) {
//           e.printStackTrace();
//       } finally {
//
//           try {
//               if (null != writer) {
//                   writer.close();
//               }
//           } catch (Exception e2) {
//               e2.printStackTrace();
//           }
//       }
//    }
//        
//    public void Add(Administrador c){
//        Administrador.ListaAdministradores.add(c);
//        
//    }
//    
//    public void Listar(){
//        
//        for(Administrador k: Administrador.ListaAdministradores){
//            k.imprimir();
//        }
//        
//    }
//    
//    public static boolean BuscarNoID(long NoID){
//        for(Administrador k: Administrador.ListaAdministradores){
//           
//            if(k.getNoID() == NoID){
//                k.imprimir(); 
//                return true;
//            }
//           
//        }
//        return false;
//    }
//      
//    public static boolean BuscarNombre(String nombre){
//        for(Administrador k: Administrador.ListaAdministradores){
//            
//            if(k.getNombre().equals(nombre)){
//                k.imprimir();
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public boolean Encontrar(String nombre){
//        
//        for(Administrador k: Administrador.ListaAdministradores){
//            if(k.getNombre().equals(nombre))
//               return true;
//        }
//        return false;
//    }
//    
//    public boolean Eliminar(long numero){
//        
//        for(Administrador k: Administrador.ListaAdministradores){
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
//           
//        }
//        return false;
//    }
//    
//   
//    public void Actualizar(String nombre, long telefono){
//       
//        int op=Buscar(nombre);
//        
//        if (op>=0) {
//             //Profesor.ListaProfesores.;
//        }
//         
//    }
//
//    public void imprimir() {
//       
//        System.out.println(getTipoID() + "," +  getNoID() + "," +  getNombre() + "," +  getSexo() + "," + getFechaNacimiento());
//        
//    }
//}
