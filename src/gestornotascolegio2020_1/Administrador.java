
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
        Fecha fechaNacimiento;
        
        
        System.out.println("_______________ Bienvenido _______________");
        System.out.print("Ingrese usuario\n--> ");
        NameUser = teclado.next();
        System.out.print("Ingrese contraseña\n--> ");
        NoIDUser = teclado.nextLong();
        
        if ("root".equals(NameUser) & NoIDUser == 12345){ 
            do{
                System.out.print("_______________ Menú administrador _______________\n\n"
                        + "1. Crear estudiante\n"
                        + "2. Crear profesor/a\n"
                        + "3. Eliminar estudiante\n"
                        + "4. Eliminar profesor/a\n"
                        + "5. Consultar o ver boletines\n"
                        + "6. Salir\n"
                        + "7. Ver estudiantes\n"
                        + "8. Ver profesores\n"
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
                        System.out.print("Elija el sexo\n1. Masculino\n2. Femenino\n--> ");
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
                                System.out.println("Profesor eliminado con exito");
                            }
                            else{
                                System.out.println("Profesor no eliminado");
                            }
                        break;
                    
                    case 5:
                        //Consultar boletines
                        System.out.print("Ingrese número de identificación del estudiante\n--> ");
                        long NoIDStudent = teclado.nextInt();
                        if(Estudiante.Buscar(NoIDStudent)){
                            Materia[] materia = {Materia.Calculo, Materia.Fisica, Materia.Quimica, Materia.Religion, Materia.Etica};
                            float p1 = Notas.BuscarPromedioPeriodoMateria(NoIDStudent, Materia.Calculo, Periodo.Periodo1);
                            float p2 = Notas.BuscarPromedioPeriodoMateria(NoIDStudent, Materia.Calculo, Periodo.Periodo2);
                            float p3 = Notas.BuscarPromedioPeriodoMateria(NoIDStudent, Materia.Calculo, Periodo.Periodo3);
                            float p4 = Notas.BuscarPromedioPeriodoMateria(NoIDStudent, Materia.Calculo, Periodo.Periodo4);
                            if(p2 == 0.0 & p3 == 0.0 & p4 == 0.0){
                                Boletin.PublicarBoletin(NoIDStudent, materia, Periodo.Periodo1);
                            }
                            else if(p3 == 0.0 && p4 == 0.0){
                                Boletin.PublicarBoletin(NoIDStudent, materia, Periodo.Periodo2);
                            }
                            else if(p4 == 0.0){
                                Boletin.PublicarBoletin(NoIDStudent, materia, Periodo.Periodo3);
                            }
                            else if(p1 != 0.0 && p2 != 0.0 && p3 != 0.0 && p4 != 0.0){
                                Boletin.PublicarBoletin(NoIDStudent, materia, Periodo.Periodo4);
                            }
                        }
                        else
                            System.out.println("Estudiante no encontrado");
                        break;
                        
                    case 6:
                        //Exit
                        exit = true;
                        break;
                        
                    case 7:
                        //Ver estudiantes
                        System.out.println("Lista estudiantes");
                        Estudiante.Listar();
                        break;
                        
                    case 8:
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
        else
            System.out.println("¡Oops!, ha ocurrido un error.\nIntenta de nuevo.");
    }
}
    
