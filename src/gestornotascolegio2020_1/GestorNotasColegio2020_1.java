
package gestornotascolegio2020_1;

import java.util.Scanner;

public class GestorNotasColegio2020_1 {

  
    public static void main(String[] args) {
        
        Administrador admin = new Administrador();
        Profesor teacher = new Profesor();
        Estudiante student = new Estudiante();
        Notas note = new Notas();

        int op;
        Scanner teclado = new Scanner(System.in);
        
        student.CargarLista();
        teacher.CargarLista();
        note.CargarLista();

        System.out.println("_______________________________________________________\n"
            + "Colaboradores: Iván Suarez, Kevin García, Jesús Ramirez,\n"
            + "Yuliana Trigos, Sebastian Quitero, Fray Herrera\n"
            + "_______________________________________________________\n"
            + "Integrantes del grupo: Iván Suarez, Kevin García\n"
            + "_______________________________________________________");
        
        do{ 
            System.out.print("1. Administradores\n"
                    + "2. Docentes\n"
                    + "3. Salir\n"
                    + "--> ");
            
            op = teclado.nextInt();
            
            switch(op){
                case 1:
                    //Administradores
                    admin.MenuOption();
                    break;
                
                case 2:
                    //Profesores
                    teacher.MenuOption();
                    break;
                   
                case 3:
                    //student.getLinea();
                    student.Sincronizar();
                    teacher.Sincronizar();
                    note.Sincronizar();
                    System.out.println("Saliste.");
                    break;
                    
                default:
                    System.out.println("¡Oops!, ha ocurrido un error.");
                    break;
            }
        }while(op != 3);
        
    }
    
}
