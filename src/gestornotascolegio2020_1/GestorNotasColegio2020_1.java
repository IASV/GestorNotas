package gestornotascolegio2020_1;
import java.util.Scanner;

public class GestorNotasColegio2020_1 {

  
    public static void main(String[] args) {
        
        Administrador admin = new Administrador();
        Profesor teacher = new Profesor();
        Estudiante student = new Estudiante();
        
        int op;
        Scanner teclado = new Scanner(System.in);
        
//        Profesor p=new Profesor();
//        
//        p.CargarLista();
//        
//        for (Profesor q : Profesor.ListaProfesores) {
//            q.imprimir();
//        }
        do{
            System.out.print("1. Administradores\n"
                    + "2. Profesores\n"
                    + "3. Salir\n"
                    + "--> ");
            
            op = teclado.nextInt();
            
            switch(op){
                case 1:
                    //Administradores
                    admin.CargarLista();
                    admin.MenuOption();
                    break;
                
                case 2:
                    //Profesores
                    teacher.CargarLista();
                    teacher.MenuOption();
                    break;
                   
                case 3:
                    //admin.Sincronizar();
                    teacher.Sincronizar();
                    student.Sincronizar();
                    System.out.println("Saliste.");
                    break;
                    
                default:
                    System.out.println("¡Oops!, ha ocurrido un error.");
                    break;
            }
        }while(op != 3);
        
    }
    
}
