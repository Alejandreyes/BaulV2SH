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
       /* p.aceptarPrestamo(813856055);
        p.aceptarPrestamo(911267262);
        /*p.aceptarPrestamo(-1183918521);
        p.aceptarPrestamo(-853404886);
        /*p.aceptarPrestamo(205575791);
        p.aceptarPrestamo(911267262);*/
        //p.rechazarPrestamo(760182686);
        
        //List<Prestamo> lst = p.verPrestamos(-2588655);
        
        //System.out.println(lst.size());
        
        /*PrestarDao prtDao = new PrestarDao();
        List<Prestamo> lst = prtDao.obtenerPrestamosPorConsumidor(4048445, 77066);
        System.out.println( lst.get(0).getIdprestamo());*/
        PrestarDao p1 = new PrestarDao();
        System.out.println("calificacion restador: "+ p1.getCalifPrestador(81871)); 
    }
    
}
