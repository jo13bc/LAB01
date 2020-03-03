/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.Date;
import static prueba.Utils.calcularMesesAFecha;

/**
 *
 * @author Miker
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fechaUtil = new Date("02/03/2019");
        java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());
        System.out.println(calcularMesesAFecha(fecha, new Date()));
    }
    
}
