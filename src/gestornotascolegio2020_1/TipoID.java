
package gestornotascolegio2020_1;

public enum TipoID {
    
    TarjetaIdentidad,
    Cedula,
    Pasaporte,
    Null;

    public static TipoID getNull() {
        return Null;
    }

    public static TipoID getTarjetaIdentidad() {
        return TarjetaIdentidad;
    }

    public static TipoID getCedula() {
        return Cedula;
    }

    public static TipoID getPasaporte() {
        return Pasaporte;
    }
    
    public static TipoID compareTipoID(String tipoID){
        if("TarjetaIdentidad".equals(tipoID))
            return getTarjetaIdentidad();
        else if("Cedula".equals(tipoID))
            return getCedula();
        else if("Pasaporte".equals(tipoID))
            return getPasaporte();
        else
            return getNull();
    }

}
