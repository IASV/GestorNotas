package gestornotascolegio2020_1;
import java.util.ArrayList;

public class Boletin {
    
    public Estudiante Alumno;
    public Profesor Director;
    public String Curso;
    
    public ArrayList<String> NotasEstudiante=new ArrayList<>();
    
    private static  void CreateItem(int colNumber, int charNumber, boolean isLast)
    {
        //System.out.print
        for (int i = 0; i < colNumber; i++)
        {
            if (i == 0 && !isLast) System.out.print("╠");

            if (i == 0 && isLast) System.out.print("╚");   

            for (int j = 0; j < charNumber; j++) System.out.print("═");

            if (i != colNumber - 1 && !isLast) System.out.print("╬");

            if (i == colNumber - 1 && !isLast) System.out.print("╣\n");

            if (i != colNumber - 1 && isLast) System.out.print("╩");

            if (i == colNumber - 1 && isLast) System.out.print("╝\n");

        }
    }


    private static void CreateBody(ArrayList<String> list)
    {
        for (int j = 0; j < list.size(); j++)
        {
            String[] vs;
            if (list.get(j).contains(","))
            {
                vs = list.get(j).split(",");

                for (int i = 0; i < vs.length; i++)
                {
                    if (i == 0) System.out.print("║");
                    int k = (15 - vs[i].length()) / 2 + vs[i].length();
                    String s = PadRight(PadLeft(vs[i],k),15);;
                    System.out.print(s);

                    if (i != vs.length -1) System.out.print("║"); else System.out.print("║\n");
                }

                CreateItem(vs.length, 15, list.size() - 1 == j);
            }
        }
    }


    static public void CreateHeader(String[] header)
    {
        for (int i = 0; i < header.length; i++)
        {
            if (i == 0) System.out.print("╔");
            for (int j = 0; j < 15; j++) System.out.print("═");
            if (i != header.length - 1) System.out.print("╦"); else System.out.print("╗\n");
        }          

        for (int i = 0; i < header.length; i++)
        {
            if (i == 0) System.out.print("║");
            int k = (15 - header[i].length()) / 2 + header[i].length();
            String s = PadRight(PadLeft(header[i],k),15);
            System.out.print(s);

            if (i != header.length - 1) System.out.print("║"); else System.out.print("║\n");
        }

        for (int i = 0; i < header.length; i++)
        {
            if (i == 0) System.out.print("╠");
            for (int j = 0; j < 15; j++) System.out.print("═");
            if (i != header.length - 1) System.out.print("╬"); else System.out.print("╣\n");
        }

    }

    static String PadLeft(String text, int k)  
    {
        
        if (k <= text.length()) {
            return text;
        }
        int p=text.length();
        for (int i = 0; i < k - p; i++) {
            text = " " + text;
            
        }
        return text;
    }     
        
    static String PadRight(String text, int k)  
    {
        
        if (k <= text.length()) {
            return text;
        }
        int p=text.length();
        for (int i = 0; i < k - p; i++) {
            text += " ";
        }
        
        return text;
    }
        
    
    
    public static void PublicarBoletin(long NoID, Materia[] materia, Periodo periodo){
        
        ArrayList<String> notas=new ArrayList();
        
        notas.add("Cálculo".concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[0], Periodo.Periodo1))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[0], Periodo.Periodo2))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[0], Periodo.Periodo3))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[0], Periodo.Periodo4))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateriaFinal(NoID, materia[0], Periodo.Periodo4))));
        notas.add("Física".concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[1], Periodo.Periodo1))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[1], Periodo.Periodo2))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[1], Periodo.Periodo3))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[1], Periodo.Periodo4))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateriaFinal(NoID, materia[1], Periodo.Periodo4))));
        notas.add("Química".concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[2], Periodo.Periodo1))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[2], Periodo.Periodo2))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[2], Periodo.Periodo3))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[2], Periodo.Periodo4))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateriaFinal(NoID, materia[2], Periodo.Periodo4))));
        notas.add("Religión".concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[3], Periodo.Periodo1))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[3], Periodo.Periodo2))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[3], Periodo.Periodo3))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[3], Periodo.Periodo4))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateriaFinal(NoID, materia[3], Periodo.Periodo4))));
        notas.add("Ética".concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[4], Periodo.Periodo1))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[4], Periodo.Periodo2))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[4], Periodo.Periodo3))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateria(NoID, materia[4], Periodo.Periodo4))).concat(",").concat(String.valueOf(Notas.BuscarPromedioPeriodoMateriaFinal(NoID, materia[4], Periodo.Periodo4))));
        
        
        System.out.println("Estudinate: "+Estudiante.BuscarNombre(NoID)+"\n");
        System.out.println("Curso: 11\n");
        System.out.println("Director de grupo: Abduscan Tunez\n\n\n");
        
        CreateHeader(new String[]{"Asignatura","Preiodo 1","Periodo 2","Periodo 3","Periodo 4","Definitiva"});
        CreateBody(notas);
        
        
    }
    
    
}