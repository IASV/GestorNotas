
package gestornotascolegio2020_1;


public class Persona {
    
    private TipoID tipoID;
    private long noID;
    private String nombre;
    private Sexo sexo;
    private Fecha fechaNacimiento;

    public Persona(){
        
    }
    
    public Persona(TipoID tipoID, long noID, String nombre, Sexo sexo, Fecha fechaNacimiento) {
        this.tipoID = tipoID;
        this.noID = noID;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoID getTipoID() {
        return tipoID;
    }

    public void setTipoID(TipoID tipoID) {
        this.tipoID = tipoID;
    }

    public long getNoID() {
        return noID;
    }

    public void setNoID(long noID) {
        this.noID = noID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
