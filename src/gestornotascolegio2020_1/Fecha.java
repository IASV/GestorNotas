
package gestornotascolegio2020_1;


public class Fecha {
    
    private int dia;
    private int mes;
    private int año;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public void setFecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public String getFecha(){
        
        return dia+ "/" + mes + "/"+año;
        
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public static int getStringFecha(String fecha, String value){
        String[] values = fecha.split("/");
        if(value == "d")
            return Integer.parseInt(values[0]);
        else if(value == "m")
            return Integer.parseInt(values[1]);
        else if(value == "a")
            return Integer.parseInt(values[2]);
        else
            return -1;
    }
            
}
