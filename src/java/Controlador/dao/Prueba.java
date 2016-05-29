/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.dao;

import MB.MBPrestar;
import Modelo.Prestamo;
import Modelo.Solicitar;
import java.util.List;

/**
 *
 * @author rodrigorojo
 */
public class Prueba {
    static SolicitudDao pd = new SolicitudDao();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        MBPrestar p = new MBPrestar();
        //p.aceptarPrestamo(-1859919263);
        /*p.aceptarPrestamo(-1154227792);
        p.aceptarPrestamo(-1003100817);
        p.aceptarPrestamo(-146324770);
        p.aceptarPrestamo(54491215);
        p.aceptarPrestamo(205575791);
        p.aceptarPrestamo(911267262);*/
        //p.rechazarPrestamo(760182686);
        
        //List<Prestamo> lst = p.verPrestamos(-2588655);
        
        //System.out.println(lst.size());
        
    }
    
}
