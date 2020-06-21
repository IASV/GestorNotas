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
public enum Periodo {
    Periodo1,
    Periodo2,
    Periodo3,
    Periodo4,
    Null;

    public static Periodo getPeriodo1() {
        return Periodo1;
    }

    public static Periodo getPeriodo2() {
        return Periodo2;
    }

    public static Periodo getPeriodo3() {
        return Periodo3;
    }

    public static Periodo getPeriodo4() {
        return Periodo4;
    }

    public static Periodo getNull() {
        return Null;
    }
    
    public static Periodo comparePeriodo(String periodo){
        if("Periodo1".equals(periodo)){
            return getPeriodo1();
        }
        else if("Periodo2".equals(periodo)){
            return getPeriodo2();
        }
        else if("Periodo3".equals(periodo)){
            return getPeriodo3();
        }
        else if("Periodo4".equals(periodo)){
            return getPeriodo4();
        }
        else
            return getNull();
    }
}
