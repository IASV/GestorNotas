
package gestornotascolegio2020_1;

public enum Sexo {
    Femenino,
    Masculino,
    Null;

    public static Sexo getNull() {
        return Null;
    }

    public static Sexo getFemenino() {
        return Femenino;
    }

    public static Sexo getMasculino() {
        return Masculino;
    }
    
    public static Sexo compareSexo(String sexo){
        if("Femenino".equals(sexo))
            return getFemenino();
        else if("Masculino".equals(sexo))
            return getMasculino();
        else
            return getNull();
    }
}
