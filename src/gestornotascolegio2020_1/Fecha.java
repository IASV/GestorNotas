
package gestornotascolegio2020_1;


public class Fecha {
    
    int dia;
    int mes;
    int año;
    
    public Fecha(int dd,int mm, int yyyy){
        dia=dd;
        mes=mm;
        año=yyyy;
    }
    
    public String getFecha(){
        
        return dia+"/" + mes + "/"+año;
        
    }
            
}
