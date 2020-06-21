/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestornotascolegio2020_1;

/**
 *
 * @author Usuario
 */
public enum Materia {
    Calculo,
    Fisica,
    Quimica,
    Religion,
    Etica,
    Null;

    public static Materia getCalculo() {
        return Calculo;
    }

    public static Materia getFisica() {
        return Fisica;
    }

    public static Materia getQuimica() {
        return Quimica;
    }

    public static Materia getReligion() {
        return Religion;
    }

    public static Materia getEtica() {
        return Etica;
    }

    public static Materia getNull() {
        return Null;
    }
    
    public static Materia compareMateria(String materia){
        if("Calculo".equals(materia)){
            return getCalculo();
        }
        else if("Fisica".equals(materia)){
            return getFisica();
        }
        else if("Qimica".equals(materia)){
            return getQuimica();
        }
        else if("Religion".equals(materia)){
            return getReligion();
        }
        else if("Etica".equals(materia)){
            return getEtica();
        }
        else
            return getNull();
    }
}
